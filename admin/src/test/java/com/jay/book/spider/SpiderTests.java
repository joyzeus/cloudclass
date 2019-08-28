package com.jay.book.spider;

import com.jay.book.ApplicationTests;
import com.jay.book.admin.module.spider.CsdnBlogPageProcessor;
import com.jay.book.admin.module.spider.DouBanSpider;
import com.jay.book.admin.module.spider.DoubanBookSpider;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.HttpClientDownloader;
import us.codecraft.webmagic.proxy.Proxy;
import us.codecraft.webmagic.proxy.SimpleProxyProvider;

@Component
public class SpiderTests extends ApplicationTests {

    @Autowired
    private CsdnBlogPageProcessor csdnBlogPageProcessor;

    @Autowired
    private DouBanSpider douBanSpider;


    @Autowired
    private DoubanBookSpider doubanBookSpider;

    @Test
    public void csdnSpidertest() {
        Spider.create(csdnBlogPageProcessor).addUrl("https://blog.csdn.net/CHENYUFENG1991").thread(5).run();
    }

    @Test
    public void doubanSpidertest() {
        for (int i = 0; i < 10; i++) {
            Spider.create(douBanSpider).addUrl("https://movie.douban.com/top250?start=" + (25 * i) + "&filter=").thread(5).run();
        }
    }


    @Test
    public void doubanBookSpidertest() {
        HttpClientDownloader httpClientDownloader = new HttpClientDownloader();
        httpClientDownloader.setProxyProvider(SimpleProxyProvider.from(
                new Proxy("121.232.194.146", 9000),
                new Proxy("27.188.64.70", 8060)
        ));
        Spider.create(doubanBookSpider).setDownloader(httpClientDownloader).addUrl("https://book.douban.com/tag/?view=type&icn=index-sorttags-all").thread(1).run();
//        Spider.create(doubanBookSpider).addUrl("https://book.douban.com/tag/%E5%B0%8F%E8%AF%B4").thread(5).run();
//        Spider.create(doubanBookSpider).addUrl("https://book.douban.com/tag/%E5%B0%8F%E8%AF%B4?start=20&type=T").thread(5).run();
    }

}
