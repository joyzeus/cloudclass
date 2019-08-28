package com.jay.book.spider;

import com.jay.book.admin.module.user.dao.CSDNBlogMapper;
import com.jay.book.admin.module.user.entity.CSDNBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

@Component
public class CsdnBlogPageProcessor implements PageProcessor {

    @Autowired
    private CSDNBlogMapper csdnBlogMapper;

    private static String username = "CHENYUFENG1991";  // 设置csdn用户名

    private static int size = 0;// 共抓取到的文章数量

    // 抓取网站的相关配置，包括：编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    public Site getSite() {
        return site;
    }

    // process是定制爬虫逻辑的核心接口，在这里编写抽取逻辑
    public void process(Page page) {
        // 列表页
        if (!page.getUrl().regex("http://blog\\.csdn\\.net/" + username + "/article/details/\\d+").match()
            && !page.getUrl().regex("https://blog\\.csdn\\.net/" + username + "/article/details/\\d+").match()) {
            // 添加所有文章页
            page.addTargetRequests(page.getHtml()
                    .xpath("//div[@class='article-list']")
                    .links()// 限定文章列表获取区域
//                    .regex("/" + username + "/article/details/\\d+")
//                    .replace("/" + username + "/", "http://blog.csdn.net/" + username + "/")// 巧用替换给把相对url转换成绝对url
                    .all());
            // 添加其他列表页
            page.addTargetRequests(page.getHtml()
                    .xpath("//div[@id='papelist']")
                    .links()// 限定其他列表页获取区域
//                    .regex("/" + username + "/article/list/\\d+")
//                    .replace("/" + username + "/", "http://blog.csdn.net/" + username + "/")// 巧用替换给把相对url转换成绝对url
                    .all());
            // 文章页
        } else {
            size++;// 文章数量加1
            // 用CsdnBlog类来存抓取到的数据，方便存入数据库
            CSDNBlog csdnBlog = new CSDNBlog();
            // 设置编号
            csdnBlog.setArticleId(Integer.parseInt(page.getUrl().regex("https://blog\\.csdn\\.net/" + username + "/article/details/(\\d+)").get()));
            // 设置标题，！ 第二个span
            csdnBlog.setTitle(
                    page.getHtml().xpath("//div[@class='article_title']//span[@class='link_title']/a/text()").get());
            // 设置日期
            csdnBlog.setDate(
                    page.getHtml().xpath("//div[@class='article_r']/span[@class='link_postdate']/text()").get());
            // 设置标签（可以有多个，需要分割）
            csdnBlog.setTag(listToString(page.getHtml()
                    .xpath("//div[@class='article_l']/span[@class='link_categories']/a/allText()").all()));
            // 设置类别（可以有多个，需要分割）
            csdnBlog.setCategory(
                    listToString(page.getHtml().xpath("//div[@class='category_r']/label/span/text()").all()));
            // 设置阅读人数
            csdnBlog.setViewCount(Integer.parseInt(page.getHtml().xpath("//div[@class='article_r']/span[@class='link_view']")
                    .regex("阅读数 (\\d+)").get()));
            // 设置评论人数
            csdnBlog.setCommentCount(Integer.parseInt(page.getHtml()
                    .xpath("//div[@class='article_r']/span[@class='link_comments']").regex("\\((\\d+)\\)").get()));
            // 设置是否原创
            csdnBlog.setCopyright(page.getHtml().regex("bog_copyright").match() ? 1 : 0);

            csdnBlogMapper.insertSelective(csdnBlog);
        }
    }

    // 把list转换为string，用,分割
    public static String listToString(List<String> stringList) {
        if (stringList == null) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        boolean flag = false;
        for (String string : stringList) {
            if (flag) {
                result.append(",");
            } else {
                flag = true;
            }
            result.append(string);
        }
        return result.toString();
    }
}
