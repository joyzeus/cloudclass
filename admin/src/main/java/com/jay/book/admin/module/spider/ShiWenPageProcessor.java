package com.jay.book.admin.module.spider;

import com.jay.book.admin.module.user.entity.Article;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShiWenPageProcessor implements PageProcessor {

    /**
     * 匹配朝代
     **/
    private final static String PATTER_DYNASTY =
            "(xianqin|hanchao|weijin|nanbeichao|suichao|tangshi|wudai|"
                    + "songci|jinchao|yuanchao|mingchao|qingchao)";
    /**
     * 朝代链接
     **/
    private final static String URL_DYNASTY =
            "http://www\\.shici\\.net/" + PATTER_DYNASTY + "/$";
    /**
     * 作者链接
     **/
    private final static String URL_AUTHOR =
            "http://www\\.shici\\.net/shiren/[a-z]{5}\\.html";
    /**
     * 诗词链接
     **/
    private final static String URL_ARTICLE =
            "http://www\\.shici\\.net/" + PATTER_DYNASTY + "/[a-z]{5}\\.html";
    /**
     * 翻译链接
     **/
    private final static String URL_TRANSLATION =
            "/fanyi/[a-z]{5}\\.html";//http://www\\.shici\\.net
    /**
     * 赏析链接
     **/
    private final static String URL_APPRECIATION =
            "/shangxi/[a-z]{5}\\.html";
    /**
     * 文章Map，暂存Article
     **/
    private static Map<String, Article> articleMap =
            new HashMap<String, Article>();

    /**
     * 保存Article
     **/
    private void saveArticle(Article article, Page page) {
        System.out.println("诗歌：" + article);
        page.putField("dynasty", article.getDynasty());
        page.putField("author", article.getAuthor());
        page.putField("authorInfo", article.getAuthorInfo());
        page.putField("title", article.getTitle());
        page.putField("content", article.getContent());
        page.putField("translation", article.getTranslation());
        page.putField("comment", article.getComment());
        page.putField("appreciation", article.getAppreciation());
    }

    private Site site = Site.me().setCycleRetryTimes(5)
            .setRetryTimes(5).setSleepTime(1000)
            .setUserAgent("Mo zilla/5.0 (Windows NT 6.1; WOW64; rv:38.0) Gecko/20100101 Firefox/38.0")
            .addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
            .addHeader("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3")
            .setCharset("UTF-8");


    public void process(Page page) {
        if (page.getUrl().regex(URL_DYNASTY).match()) {
            //System.out.println("朝代："+page.getUrl());
            //作者列表
            List<String> authorUrl = page.getHtml()
                    .xpath("//div[@class='shirenlist']")
                    .links().all();
            page.addTargetRequests(authorUrl);
            //古诗文列表
            List<String> essayUrl = page.getHtml()
                    .xpath("//div[@id='related']/ul")
                    .links().all();
            page.addTargetRequests(essayUrl);
            page.setSkip(true);//跳过这个页面
        } else if (page.getUrl().regex(URL_AUTHOR).match()) {
            //System.out.println("作者："+page.getUrl());
            //诗词列表
            List<String> poemUrl = page.getHtml()
                    .xpath("//div[@id='related']/ul/li/a/@href")
                    .all();
            //System.out.println(poemUrl);
            page.addTargetRequests(poemUrl);
            page.setSkip(true);//跳过这个页面
        } else if (page.getUrl().regex(URL_ARTICLE).match()) {
            //System.out.println("诗词："+page.getUrl());
            Html html = page.getHtml();
            Article article = new Article();
            //朝代
            String dynasty = html
                    .xpath("//div[@id='article']/div[@class='info']")
                    .regex("<span>朝代：</span>(.*?)</p>").toString();
            //System.out.println(dynasty);
            article.setDynasty(dynasty);
            //作者
            String author = html
                    .xpath("//div[@id='article']/div[@class='info']")
                    .regex("<span>作者：</span><.*>(.*?)</a>").toString();
            //System.out.println(author);
            article.setAuthor(author);
            if (!author.equals("佚名")) {
                //作者简介
                String authorInfo = html
                        .xpath("//div[@class='authorinfo']")
                        .regex("<br>(.*)</div>").toString();
                //System.out.println(authorInfo);
                article.setAuthorInfo(authorInfo);
            }
            //标题
            String title = html.xpath("div[@id='article']/h1/text()")
                    .toString();
            //System.out.println(title);
            article.setTitle(title);
            //原文
            String content = html
                    .xpath("div[@id='article']/div[@class='content']")
                    .regex("<div class=\"content\">(.*)</div>")
                    .toString();
            //System.out.println(content);
            article.setContent(content);
            //译文链接
            String translationUrl = html
                    .xpath("div[@id='related']/ul/li/h3/a/@href")
                    .regex(URL_TRANSLATION)
                    .toString();
            //赏析链接
            String appreciateUrl = html
                    .xpath("div[@id='related']/ul/li/h3/a/@href")
                    .regex(URL_APPRECIATION)
                    .toString();
            //System.out.println("翻译：" + translationUrl);
            //System.out.println("赏析：" + appreciateUrl);
            if (translationUrl == null && appreciateUrl == null) {
                saveArticle(article, page);
            } else {
                if (translationUrl != null) {
                    article.setTranslation("http://www.shici.net" + translationUrl);
                    page.addTargetRequest("http://www.shici.net" + translationUrl);
                }
                if (appreciateUrl != null) {
                    article.setAppreciation("http://www.shici.net" + appreciateUrl);
                    page.addTargetRequest("http://www.shici.net" + appreciateUrl);
                }
                articleMap.put(page.getUrl().toString(), article);
                page.setSkip(true);//跳过这个页面
            }
        } else if (page.getUrl().regex(URL_TRANSLATION).match()) {
            Html html = page.getHtml();
            String articleUrl = "http://www.shici.net" + html
                    .xpath("//div[@class='relatedshici']/h2/a/@href")
                    .toString();
            System.out.println(articleUrl);
            String title = html.xpath("//div[@id='article']/h1/text()").toString();
            String translation = null;
            String comment = null;
            //处理译文与注释
            if (title.endsWith("译文及注释")) {
                translation = html
                        .xpath("//div[@id='article']/div[@class='content']")
                        .regex("<p><strong>译文</strong><br>(.*?)</p>")
                        .toString();
                comment = html
                        .xpath("//div[@id='article']/div[@class='content']")
                        .regex("<p><strong>注释</strong><br>(.*?)</p>")
                        .toString();
            } else {
                if (title.endsWith("译文")) {
                    translation = html
                            .xpath("//div[@id='article']")
                            .regex("<div class=\"content\">(.*?)</div>")
                            .toString();
                }
                if (title.endsWith("注释")) {
                    comment = html
                            .xpath("//div[@id='article']")
                            .regex("<div class=\"content\">(.*?)</div>")
                            .toString();
                }
            }
            System.out.println("注释：" + comment);
            System.out.println("翻译：" + translation);
            Article article = articleMap.get(articleUrl);
            article.setTranslation(translation);
            article.setComment(comment);
            String appreciation = article.getAppreciation();
            if (appreciation != null && appreciation.startsWith("http")) {
                page.setSkip(true);//跳过这个页面
            } else {
                saveArticle(article, page);
                articleMap.remove(articleUrl);
            }
        } else if (page.getUrl().regex(URL_APPRECIATION).match()) {
            Html html = page.getHtml();
            String articleUrl = "http://www.shici.net" + html
                    .xpath("//div[@class='relatedshici']/h2/a/@href")
                    .toString();
            System.out.println(articleUrl);
            String title = html.xpath("//div[@id='article']/h1").toString();
            String appreciation = html
                    .xpath("//div[@id='article']")
                    .regex("<div class=\"content\">(.*?)</div>")
                    .toString();
            System.out.println("赏析：" + title + appreciation);
            Article article = articleMap.get(articleUrl);
            article.setAppreciation(title + appreciation);
            String translation = article.getTranslation();
            if (translation != null && translation.startsWith("http")) {
                page.setSkip(true);//跳过这个页面
            } else {
                saveArticle(article, page);
                articleMap.remove(articleUrl);
            }
        }
    }

    public Site getSite() {
        return site;
    }

    private final static String[] intiUrls = {
            "http://www.shici.net/xianqin/",
            "http://www.shici.net/hanchao/",
            "http://www.shici.net/weijin/",
            "http://www.shici.net/nanbeichao/",
            "http://www.shici.net/suichao/",
            "http://www.shici.net/tangshi/",
            "http://www.shici.net/wudai/",
            "http://www.shici.net/songci/",
            "http://www.shici.net/jinchao/",
            "http://www.shici.net/yuanchao/",
            "http://www.shici.net/mingchao/",
            "http://www.shici.net/qingchao/",
    };

    public static void main(String[] args) {
        Spider.create(new ShiWenPageProcessor())
//                .addUrl("http://www.shici.net/xianqin/")
                .addUrl(intiUrls)
                .addPipeline(new JsonFilePipeline("/Users/liaoxuyi/Desktop/data"))
                .thread(5)
                .run();
        System.out.println("运行结束");
    }

}