package com.ghl.EmailSender;

public class MailController {

    public static void main(String[] args) {
        MailUtil mailUtil = new MailUtil();
        try {
            mailUtil.sendMail("xxxxxx@163.com", "邮件发送测试", "<a href='https://www.baidu.com' >百度一下</a>");

        } catch (Exception e) {

        }

    }
}
