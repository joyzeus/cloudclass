package com.igeek.cloudclass.task.task;

import com.igeek.cloudclass.task.dao.ShadowskyAccountMapper;
import com.igeek.cloudclass.task.dao.ShadowskySigninLogMapper;
import com.igeek.cloudclass.task.model.dto.ShadowSkySignInResult;
import com.igeek.cloudclass.task.model.entity.ShadowskyAccount;
import com.igeek.cloudclass.task.model.entity.ShadowskySigninLog;
import com.igeek.cloudclass.task.service.ShadowSkyService;
import com.igeek.common.util.JacksonUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;

/**
 * @author zhouxu
 * @email 1419982188@qq.com
 * @date 2020/05/02
 */
@Slf4j
@Component
public class ShadowSkySingInTask {

    @Autowired
    private ShadowSkyService shadowSkyService;

    @Autowired
    private ShadowskyAccountMapper shadowskyAccountMapper;

    @Autowired
    private ShadowskySigninLogMapper shadowskySigninLogMapper;

    @Scheduled(cron = "0 0 0 * * ? ")
    public void autoSignIn() {
        log.error(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
        List<ShadowskyAccount> shadowskyAccountList = shadowskyAccountMapper.selectList(null);
        for (ShadowskyAccount shadowskyAccount : shadowskyAccountList) {
            String token = shadowSkyService.login(shadowskyAccount.getAccount(), shadowskyAccount.getPassword());
            if (StringUtils.isNotBlank(token)) {
                log.error("登录成功,token = " + token);
            } else {
                log.error("登录失败");
            }

            String result = shadowSkyService.signIn(token);
            ShadowSkySignInResult shadowSkySignInResult = JacksonUtil.parseToObject(result, ShadowSkySignInResult.class);
            shadowSkySignInResult.setMsg(URLDecoder.decode(shadowSkySignInResult.getMsg(), StandardCharsets.UTF_8));
            ShadowskySigninLog shadowskySigninLog = ShadowskySigninLog.builder()
                    .account(shadowskyAccount.getAccount())
                    .createTime(new Date())
                    .result(JacksonUtil.toJson(shadowSkySignInResult))
                    .build();
            shadowskySigninLogMapper.insertSelective(shadowskySigninLog);
        }
    }
}
