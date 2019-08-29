package com.jay.book.spider;

import com.jay.book.module.book.entity.DoubanBook;
import com.jay.book.module.book.entity.DoubanBookType;
import com.jay.book.service.base.DoubanBookService;
import com.jay.book.admin.util.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.math.BigDecimal;
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
        if (StringUtils.equals("https://book.douban.com/tag/?view=type&icn=index-sorttags-all", url.toString())) {
            List<Selectable> nodes = page.getHtml().xpath("//table[@class='tagCol']/tbody/tr").nodes();
            for (Selectable node : nodes) {
                String link = HOST + node.xpath("//td/a/@href").get();
                String typeName = node.xpath("//td/a/text()").get();
                String count = node.xpath("//td/b/text()").get().replaceAll("[^0-9]", "");

                System.out.println("----- link = " + link + ", typeName = " + typeName + ", count = " + count);

                doubanBookService.insertOrUpdateBookType(DoubanBookType.Builder.aDoubanBookType()
                        .withType(typeName)
                        .withLink(link)
                        .withCount(Integer.valueOf(count))
                        .build());

                Spider.create(this).addUrl(HOST + "/tag/" + URLEncoder.encode(typeName)).thread(1).run();
            }
        } else if (url.toString().startsWith("https://book.douban.com/tag/")) {
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
                    DoubanBook book = DoubanBook.Builder.aDoubanBook()
                            .withBookId(bookId)
                            .withBookName(name)
                            .withLink(link)
                            .withAuthor(split[0].trim())
                            .withImg(img)
                            .withPublishingHouse(split[1].trim())
                            .withPublishTime(DateUtil.tryParseDate(split[2].trim()))
                            .withRateCount(Integer.valueOf(count))
                            .withPrice(new BigDecimal(split[3].trim().replaceAll("[^0-9]", "")).divide(new BigDecimal(100)))
                            .build();

                    doubanBookService.insertOrUpdateBook(book);
                } else if (split.length == 5) {
                    DoubanBook book = DoubanBook.Builder.aDoubanBook()
                            .withBookId(bookId)
                            .withBookName(name)
                            .withLink(link)
                            .withAuthor(split[0].trim())
                            .withTranslator(split[1].trim())
                            .withImg(img)
                            .withPublishingHouse(split[2].trim())
                            .withPublishTime(DateUtil.tryParseDate(split[3].trim()))
                            .withScore(new BigDecimal(score))
                            .withRateCount(Integer.valueOf(count))
                            .withPrice(new BigDecimal(split[4].replaceAll("[^0-9]", "").trim()).divide(new BigDecimal(100)))
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
