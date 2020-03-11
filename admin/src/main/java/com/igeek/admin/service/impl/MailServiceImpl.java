package com.igeek.admin.service.impl;

import com.igeek.admin.entity.EmailConfig;
import com.igeek.admin.service.base.EmailConfigService;
import com.igeek.admin.service.base.MailService;
import com.igeek.common.util.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class MailServiceImpl implements MailService {

    private final JavaMailSender mailSender;

    private final EmailConfigService emailConfigService;

    @Autowired(required = false)
    public MailServiceImpl(JavaMailSender mailSender, EmailConfigService emailConfigService) {
        this.mailSender = mailSender;
        this.emailConfigService = emailConfigService;
    }

    /**
     * 发送文本邮件
     *
     * @param toAddr
     * @param title
     * @param content
     */
    @Override
    public void sendTextMail(String title, String content, String[] toAddr) {
        // 纯文本邮件对象
        SimpleMailMessage message = new SimpleMailMessage();
        EmailConfig emailConfig = emailConfigService.selectSendEmailAccount();
        message.setFrom(emailConfig.getAccount());
        message.setTo(toAddr);
        message.setSubject(title);
        message.setText(content);
        try {
            mailSender.send(message);
            LogUtil.debug("Text邮件已经发送。");
        } catch (Exception e) {
            LogUtil.error("发送Text邮件时发生异常！", e);
        }
    }

    /**
     * 发送html邮件
     *
     * @param toAddr
     * @param title
     * @param content
     */
    @Override
    public void sendHtmlMail(String title, String content, String[] toAddr) {
        // html 邮件对象
        MimeMessage message = mailSender.createMimeMessage();
        try {
            //true表示需要创建一个multipart message
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            EmailConfig emailConfig = emailConfigService.selectSendEmailAccount();
            message.setFrom(emailConfig.getAccount());
            helper.setTo(toAddr);
            helper.setSubject(title);
            helper.setText(content, true);

            mailSender.send(message);
            LogUtil.debug("html邮件发送成功。");
        } catch (MessagingException e) {
            LogUtil.error("发送html邮件时发生异常！", e);
        }
    }


    /**
     * 发送带附件的邮件
     *
     * @param toAddr
     * @param title
     * @param content
     * @param filePath
     */
    public void sendAttachmentsMail(String title, String content, String filePath, String[] toAddr) {
        MimeMessage message = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            EmailConfig emailConfig = emailConfigService.selectSendEmailAccount();
            message.setFrom(emailConfig.getAccount());
            helper.setTo(toAddr);
            helper.setSubject(title);
            helper.setText(content, true);

            FileSystemResource file = new FileSystemResource(new File(filePath));
            String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
            helper.addAttachment(fileName, file);
            //helper.addAttachment("test"+fileName, file);

            mailSender.send(message);
            LogUtil.debug("带附件的邮件已经发送。");
        } catch (MessagingException e) {
            LogUtil.error("发送带附件的邮件时发生异常！", e);
        }
    }


    /**
     * 发送正文中有静态资源（图片）的邮件
     *
     * @param toAddr
     * @param title
     * @param content
     * @param rscPath
     * @param rscId
     */
    public void sendInlineResourceMail(String title, String content, String rscPath, String rscId, String[] toAddr) {
        MimeMessage message = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            EmailConfig emailConfig = emailConfigService.selectSendEmailAccount();
            message.setFrom(emailConfig.getAccount());
            helper.setTo(toAddr);
            helper.setSubject(title);
            helper.setText(content, true);

            FileSystemResource res = new FileSystemResource(new File(rscPath));
            helper.addInline(rscId, res);

            mailSender.send(message);
            LogUtil.debug("嵌入静态资源的邮件已经发送。");
        } catch (MessagingException e) {
            LogUtil.error("发送嵌入静态资源的邮件时发生异常！", e);
        }
    }
}
