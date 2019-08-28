package com.jay.book.admin.module.spider;

import com.github.pagehelper.util.StringUtil;
import org.apache.log4j.Logger;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.proxy.Proxy;
import us.codecraft.webmagic.proxy.ProxyProvider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;

public class KuaidailiProxyProvider implements ProxyProvider {
    private Logger logger = Logger.getLogger(KuaidailiProxyProvider.class);

    private List<Proxy> proxyList = new ArrayList<>();
    private volatile Map<String, ArrayBlockingQueue<Proxy>> siteProxysMap = new HashMap<String, ArrayBlockingQueue<Proxy>>();
    private Object siteProxysMapLock = new Object();
    //获取代理信息的地址
    private String apiurl;
    //用户名
    private String username;
    //密码
    private String password;
    private volatile static KuaidailiProxyProvider instance = null;

    public KuaidailiProxyProvider(String apiurl, String username, String password) {
        this.apiurl = apiurl;
        this.username = username;
        this.password = password;
        this.init();
    }

    public static KuaidailiProxyProvider getInstance(String apiurl, String username, String password) {
        if (instance == null) {
            synchronized (KuaidailiProxyProvider.class) {
                if (instance == null) {
                    instance = new KuaidailiProxyProvider(apiurl, username, password);
                }
            }
        }
        return instance;
    }

    private void init() {
//        try {
//            logger.info("get proxy");
////            String s = HttpsUtil.requestGet(this.apiurl);
//            logger.info(s);
//            if (StringUtil.isNotEmpty(s)) {
//                final JSONObject jsonObject = JSON.parseObject(s);
//                if (jsonObject == null) {
//                    return;
//                }
//                final JSONObject data = jsonObject.getJSONObject("data");
//                if (data == null) {
//                    return;
//                }
//                final JSONArray proxy_list = data.getJSONArray("proxy_list");
//                if (proxy_list == null && proxy_list.size() == 0) {
//                    return;
//                }
//                List<String> tempList = new ArrayList<>();
//                for (int i = 0; i < proxy_list.size(); i++) {
//                    final String string = proxy_list.getString(i);
//                    final String[] split = string.split(":");
//                    proxyList.add(new Proxy(split[0], Integer.parseInt(split[1]), this.username, this.password));
//                }
//            }
//        } catch (Exception e) {
//            logger.error(e.getMessage(), e);
//        }
    }

    private ArrayBlockingQueue<Proxy> get(String key) {
        try {
            ArrayBlockingQueue<Proxy> queue = siteProxysMap.get(key);
            if (queue == null) {
                synchronized (siteProxysMapLock) {
                    queue = siteProxysMap.get(key);
                    if (queue == null) {
                        ArrayBlockingQueue<Proxy> proxies = new ArrayBlockingQueue<Proxy>(proxyList.size());
                        for (Proxy proxy : proxyList) {
                            proxies.put(proxy);
                        }
                        siteProxysMap.put(key, proxies);
                    }
                }
            }
        } catch (InterruptedException e) {
            this.logger.error(e.getMessage(), e);
        }
        return siteProxysMap.get(key);
    }

    @Override
    public void returnProxy(Proxy proxy, Page page, Task task) {
        this.logger.info(proxy);
        try {
            String key = getKey(task);
            this.get(key).put(proxy);
        } catch (InterruptedException e) {
            this.logger.error(e.getMessage(), e);
        }
    }

    private String getKey(Task task) {
        final String domain = task != null && task.getSite() != null ? task.getSite().getDomain() : null;
        return StringUtil.isNotEmpty(domain) ? domain : KuaidailiProxyProvider.class.getName();
    }

    @Override
    public Proxy getProxy(Task task) {
        Proxy proxy = null;
        try {
            proxy = this.get(this.getKey(task)).take();
            this.logger.info(proxy);
        } catch (InterruptedException e) {
            logger.error(e.getMessage(), e);
        }
        return proxy;
    }
}