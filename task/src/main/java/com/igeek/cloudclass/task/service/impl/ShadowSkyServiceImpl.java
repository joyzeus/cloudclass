package com.igeek.cloudclass.task.service.impl;

import com.igeek.cloudclass.task.config.ShadowSkyConfig;
import com.igeek.cloudclass.task.manager.OkHttpClientManager;
import com.igeek.cloudclass.task.service.ShadowSkyService;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
public class ShadowSkyServiceImpl implements ShadowSkyService {

    final String COOKES_NAME = "Set-Cookie";

    public String login(String account, String password) {
        try {
            FormBody.Builder builder = new FormBody.Builder();
            builder.add("email", account);
            builder.add("passwd", password);
            builder.add("remember_me", "week");
            FormBody formBody = builder.build();

            Request request = new Request.Builder()
                    .url(ShadowSkyConfig.SHADOWSKY_HOST + ShadowSkyConfig.LOGININ_API)
                    .post(formBody)
                    .build();
            Call call = OkHttpClientManager.getInstance().newCall(request);
            Response response = call.execute();
            String header = response.header(COOKES_NAME);
            String result = "";
            if (StringUtils.isNotEmpty(header)) {
                String[] split = header.split(";");
                for (String s : split) {
                    String[] strings = s.split("=");
                    if (strings.length == 2) {
                        if (StringUtils.equals("sid", strings[0].trim())) {
                            result = strings[1];
                        }
                    }
                }
            }
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public String signIn(String token) {
        try {
            FormBody formBody = new FormBody.Builder().build();
            Request request = new Request.Builder()
                    .url(ShadowSkyConfig.SHADOWSKY_HOST + ShadowSkyConfig.CHEKIN_API)
                    .post(formBody)
                    .header("Cookie", "sid=" + token)
                    .build();
            Call call = OkHttpClientManager.getInstance().newCall(request);
            Response response = call.execute();
            ResponseBody responseBody = response.body();
            return responseBody != null ? responseBody.string() : "";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}