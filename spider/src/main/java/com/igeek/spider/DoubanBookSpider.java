package com.igeek.spider;

import com.igeek.common.util.DateUtil;
import com.igeek.spider.model.entity.DoubanBook;
import com.igeek.spider.model.entity.DoubanBookType;
import com.igeek.spider.service.base.DoubanBookService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@Component
public class DoubanBookSpider implements PageProcessor {

    private static final String HOST = "https://book.douban.com";

    private Site site = Site.me().setUserAgent("Mozilla/5.0 (Windows NT 10.0; WOW64; rv:56.0) Gecko/20100101 Firefox/56.0").setRetryTimes(3).setSleepTime(1000);

    private final List<String> urlList = new ArrayList<>();

    @Autowired
    private DoubanBookService doubanBookService;

    @Override
    public Site getSite() {
        return site;
    }

    @Override
    public void process(Page page) {
        Selectable url = page.getUrl();
        System.out.println("-------------------------------" + url.toString() + "-------------------------------");
        if (StringUtils.equals("https://book.douban.com/tag/", url.toString())) {
            List<Selectable> nodes = page.getHtml().xpath("//table[@class='tagCol']/tbody/tr").nodes();
            for (Selectable node : nodes) {
                String link = HOST + node.xpath("//td/a/@href").get();
                String typeName = node.xpath("//td/a/text()").get();
                String count = node.xpath("//td/b/text()").get().replaceAll("[^0-9]", "");

                System.out.println("----- link = " + link + ", typeName = " + typeName + ", count = " + count);

                doubanBookService.insertOrUpdateBookType(DoubanBookType.builder()
                        .type(typeName)
                        .link(link)
                        .count(StringUtils.isEmpty(count) ? 0 : Integer.parseInt(count))
                        .build());

                try {
                    Spider.create(this).addUrl(HOST + "/tag/" + URLEncoder.encode(typeName,"utf-8")).thread(1).run();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        } else if (url.toString().startsWith("https://book.douban.com/tag/")) {
            Integer typeId = 0;
            int lastIndex = url.toString().indexOf("?");
            String type = lastIndex == -1 ? url.toString().substring("https://book.douban.com/tag/".length())
                    : url.toString().substring("https://book.douban.com/tag/".length(), lastIndex);
            if (StringUtils.isNotBlank(type)) {
                DoubanBookType doubanBookType = null;
                try {
                    doubanBookType = doubanBookService.selectByTypeName(URLDecoder.decode(type, "utf-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                if (doubanBookType != null) {
                    typeId = doubanBookType.getTableId();
                }
            }

            List<Selectable> nodes = page.getHtml().xpath("//ul[@class='subject-list']/li").nodes();
            for (Selectable node : nodes) {
                String link = node.xpath("//div[@class='pic']/a/@href").get();
                String img = node.xpath("//div[@class='pic']/a/img/@src").get();
                String name = node.xpath("//div[@class='info']/h2/a/text()").get().trim();
                Integer bookId = Integer.valueOf(node.xpath("//div[@class='info']/h2/a/@href").get().replaceAll("[^0-9]", ""));
                String authorInfo = node.xpath("//div[@class='info']/div[@class='pub']/text()").get();
                String[] split = authorInfo.split("/");

                String score = node.xpath("//div[@class='star']/span[@class='rating_nums']/text()").get();
                String count = node.xpath("//div[@class='star']/span[@class='pl']/text()").get().replaceAll("[^0-9]", "");

                if (split.length == 4) {
                    DoubanBook book = DoubanBook.builder()
                            .bookId(bookId)
                            .bookName(name)
                            .typeId(typeId)
                            .link(link)
                            .author(split[0].trim())
                            .img(img)
                            .publishingHouse(split[1].trim())
                            .publishTime(DateUtil.tryParseDate(split[2].trim()))
                            .rateCount(StringUtils.isEmpty(count) ? 0 : Integer.parseInt(count))
                            .price(new BigDecimal(split[3].trim().replaceAll("[^0-9]", "")).divide(new BigDecimal(100)))
                            .build();

                    doubanBookService.insertOrUpdateBook(book);
                } else if (split.length == 5) {
                    DoubanBook book = DoubanBook.builder()
                            .bookId(bookId)
                            .bookName(name)
                            .typeId(typeId)
                            .link(link)
                            .author(split[0].trim())
                            .translator(split[1].trim())
                            .img(img)
                            .publishingHouse(split[2].trim())
                            .publishTime(DateUtil.tryParseDate(split[3].trim()))
                            .score(new BigDecimal(score))
                            .rateCount(StringUtils.isEmpty(count) ? 0 : Integer.parseInt(count))
                            .price(new BigDecimal(split[4].replaceAll("[^0-9]", "").trim()).divide(new BigDecimal(100)))
                            .build();
                    doubanBookService.insertOrUpdateBook(book);
                }
            }

            List<Selectable> list = page.getHtml().xpath("//div[@class='paginator']/a").nodes();
            for (Selectable node : list) {
                String s = node.xpath("//a/@href").get();
                String uri = HOST + "/tag/" + URLEncoder.encode(s.substring(s.lastIndexOf("/") + 1, s.indexOf("?"))) + s.substring(s.indexOf("?"));
                if (!urlList.contains(uri)) {
                    urlList.add(uri);
                    Spider.create(this).addUrl(uri).thread(1).run();
                }
            }
        } else if (url.toString().startsWith("https://book.douban.com/subject/")) {
            String title = page.getHtml().xpath("//div[@id='wrapper']/h1/span/text()").get();
            String img = page.getHtml().xpath("//div[@id='mainpic']/a/@href").get();
            String author = page.getHtml().xpath("//div[@id='info']/a[1]/text()").get();
            String publishingHouse = page.getHtml().xpath("//div[@id='info']/span[2]/text()").get();
            String publisher = page.getHtml().xpath("//div[@id='info']/span[3]/text()").get();
        }
    }
}
