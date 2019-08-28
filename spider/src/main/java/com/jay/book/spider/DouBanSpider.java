package com.jay.book.spider;

import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;

@Component
public class DouBanSpider implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    @Override
    public Site getSite() {
        return site;
    }

    @Override
    public void process(Page page) {
        List<Selectable> nodes = page.getHtml().xpath("//ol[@class='grid_view']/li").nodes();
        for (Selectable node : nodes) {
            String link = node.xpath("//div[@class='pic']/a/@href").get();
            String id = link.replaceAll("[^0-9]", "");
            String rank = node.xpath("//div[@class='pic']/em/text()").get();
            String imgSrc = node.xpath("//div[@class='pic']/a/img/@src").get();

            String title = node.xpath("//div[@class='hd']/a/span[1]/text()").get();
            String titleEnglish = node.xpath("//div[@class='hd']/a/span[2]/text()").get();
            String titleHongKong = node.xpath("//div[@class='hd']/a/span[3]/text()").get();

            String director = node.xpath("//div[@class='bd']/p/text()").get();
            String count = node.xpath("//div[@class='bd']/div[@class='star']/span[4]/text()").get().replaceAll("[^0-9]", "");
            String comment = node.xpath("//div[@class='bd']/p[2]/span/text()").get();
        }
    }
}
