package com.jay.book.admin.interceptor;

import com.jay.book.admin.entity.EmailConfig;
import com.jay.book.admin.entity.ExceptionLog;
import com.jay.book.admin.service.base.EmailConfigService;
import com.jay.book.admin.service.base.ExceptionLogService;
import com.jay.book.admin.service.base.MailService;
import com.jay.book.admin.util.IPUtil;
import com.jay.book.admin.util.JacksonUtil;
import com.jay.book.admin.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
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

    private final ExceptionLogService exceptionLogService;

    private final EmailConfigService emailConfigService;

    private final MailService mailService;

    @Autowired(required = false)
    public GolbalExceptionResolver(ExceptionLogService exceptionLogService, EmailConfigService emailConfigService, MailService mailService) {
        this.exceptionLogService = exceptionLogService;
        this.emailConfigService = emailConfigService;
        this.mailService = mailService;
    }

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
            log.setExceptionMsg(sw.toString()); // 异常详细信息
            log.setView((byte) 0);
            log.setAddtime(new Date());
            exceptionLogService.insertSelective(log);

            String subject = "【系统异常通知】";
            String content = "管理员，您好：<br/>   系统出现异常，请立即登录后台系统：“系统管理”--“异常日志管理”进行查看。<br/>   "
                    + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            List<EmailConfig> emailConfigs = emailConfigService.selectReceiveEmailAccountWithRedisCache();
            List<String> userList = emailConfigs.stream().filter(Objects::nonNull).map(EmailConfig::getAccount).distinct().collect(Collectors.toList());
            mailService.sendHtmlMail(subject, content, userList.toArray(new String[]{}));
        }
        response.setStatus(HttpStatus.OK.value()); //设置状态码
        response.setContentType(MediaType.APPLICATION_JSON_VALUE); //设置ContentType
        response.setCharacterEncoding("UTF-8"); //避免乱码
        response.setHeader("Cache-Control", "no-cache, must-revalidate");
        try {
            response.getWriter().write(JacksonUtil.toJson(R.error("系统异常")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ModelAndView();
    }
}
