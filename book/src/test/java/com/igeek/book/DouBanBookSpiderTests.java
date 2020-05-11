package com.igeek.book;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import us.codecraft.webmagic.Spider;

/**
 * @author zhouxu
 * @version v1.0
 * @email 1419982188@qq.com
 * @date 2020/4/9 10:36
 */
public class DouBanBookSpiderTests extends BookApplicationTests{

    @Autowired
    DoubanBookSpider doubanBookSpider;

    @Test
    public void pullDoubanData(){
        Spider.create(doubanBookSpider).addUrl("https://book.douban.com/tag/").run();
    }
}
