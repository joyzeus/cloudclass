package com.igeek.admin.interceptor;

import com.igeek.admin.model.entity.EmailConfig;
import com.igeek.admin.model.entity.ExceptionLog;
import com.igeek.admin.service.base.EmailConfigService;
import com.igeek.admin.service.base.ExceptionLogService;
import com.igeek.admin.service.base.MailService;
import com.igeek.common.util.IPUtil;
import com.igeek.common.util.JacksonUtil;
import com.igeek.common.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author zhouxu
 * @date 2019/12/24
 */
@ControllerAdvice
public class GolbalExceptionResolver implements HandlerExceptionResolver {

    @Autowired(required = false)
    private ExceptionLogService exceptionLogService;

    @Autowired(required = false)
    private EmailConfigService emailConfigService;

    @Autowired(required = false)
    private MailService mailService;

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        if (handler instanceof HandlerMethod) {
            // 远程访问IP
            String ip = IPUtil.getIpAddr(request);
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            String className = handlerMethod.getBeanType().getName();
            String methodName = handlerMethod.getMethod().getName();
            StringWriter sw = new StringWriter();
            ex.printStackTrace(new PrintWriter(sw, true));

            // 插入异常日志到数据库
            ExceptionLog log = new ExceptionLog();
            log.setIp(ip);
            log.setClassName(className);
            log.setMethodName(methodName);
            log.setExceptionType(ex.getClass().getSimpleName());
            log.setExceptionMsg(sw.toString());
            log.setView((byte) 0);
            log.setCreateTime(new Date());
            exceptionLogService.insertSelective(log);

            String subject = "【系统异常通知】";
            String content = "管理员，您好：<br/>   系统出现异常，请立即登录后台系统：“系统管理”--“异常日志管理”进行查看。<br/>   "
                    + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            List<EmailConfig> emailConfigs = emailConfigService.selectReceiveEmailAccountWithRedisCache();
            List<String> userList = emailConfigs.stream().filter(Objects::nonNull).map(EmailConfig::getAccount).distinct().collect(Collectors.toList());
            mailService.sendHtmlMail(subject, content, userList.toArray(new String[]{}));
        }
        response.setStatus(HttpStatus.OK.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Cache-Control", "no-cache, must-revalidate");
        try {
            response.getWriter().write(JacksonUtil.toJson(R.error("系统异常")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ModelAndView();
    }
}
