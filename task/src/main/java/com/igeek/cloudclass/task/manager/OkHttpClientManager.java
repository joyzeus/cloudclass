package com.igeek.cloudclass.task.manager;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.concurrent.TimeUnit;

public class OkHttpClientManager {

    private static final long READ_TIMEOUT = 10;
    private static final long WRITE_TIMEOUT = 10;
    private static final long CONNECT_TIMEOUT = 10;
    private static final long CALL_TIMEOUT = 30;

    private static volatile OkHttpClient sInstance;

    private static Logger logger = LoggerFactory.getLogger(OkHttpClientManager.class);

    public static OkHttpClient getInstance() {
        if (sInstance == null) {
            synchronized (OkHttpClientManager.class) {
                if (sInstance == null) {
                    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                        @Override
                        public void log(String message) {
                            try {
                                String text = URLDecoder.decode(message, "utf-8");
                                logger.error(text);
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                                logger.error(message);
                            }
                        }
                    });
                    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

                    sInstance = new OkHttpClient.Builder()
                            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                            .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                            .callTimeout(CALL_TIMEOUT, TimeUnit.SECONDS)
                            .addInterceptor(interceptor)
                            .build();
                }
            }
        }
        return sInstance;
    }
}
