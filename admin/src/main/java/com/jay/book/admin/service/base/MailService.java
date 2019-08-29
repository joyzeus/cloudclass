package com.jay.book.admin.service.base;

public interface MailService {

    /**
     * 发送纯文本邮件
     *
     * @param title   标题
     * @param content 内容
     * @param toAddr  发送给谁
     */
    void sendTextMail(String title, String content, String[] toAddr);

    /**
     * 发送 html 邮件
     *
     * @param title
     * @param content 内容（HTML）
     * @param toAddr
     */
    void sendHtmlMail(String title, String content, String[] toAddr);

    /**
     * 发送待附件的邮件
     *
     * @param toAddr
     * @param title
     * @param content
     * @param filePath 附件地址
     */
    void sendAttachmentsMail(String title, String content, String filePath, String[] toAddr);

    /**
     * 发送文本中有静态资源（图片）的邮件
     *
     * @param toAddr
     * @param title
     * @param content
     * @param rscPath 资源路径
     * @param rscId   资源id (可能有多个图片)
     */
    void sendInlineResourceMail(String title, String content, String rscPath, String rscId, String[] toAddr);
}
