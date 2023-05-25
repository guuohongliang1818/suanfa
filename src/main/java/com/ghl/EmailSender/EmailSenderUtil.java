package com.ghl.EmailSender;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailSenderUtil {

    public static void main(String[] args) {
        // 收件人电子邮箱
        String to = "15022195606@163.com";

        // 发件人电子邮箱
        String from = "807834167@qq.com";

        // 指定发送邮件的主机为 localhost
        String host = "smtp.qq.com";

        // 获取系统属性
        Properties properties = new Properties();

        // 设置邮件服务器
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.transport.protocol", "smtp");
        properties.setProperty("mail.smtp.auth", "false");
        // 获取默认的 Session 对象。
        Authenticator authenticator = new PopAuthenticator("807834167@qq.com", "Go35@k0a");

        Session session = Session.getInstance(properties,authenticator);

        try{
            //填写信封写信
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(from));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            msg.setSubject("激活邮箱!");
            msg.setText("你好请到这个地址激活你的账号：http://www.estore.com/ActiveServlet?activecode=");
            //验证用户名密码发送邮件
            Transport transport = session.getTransport();
            transport.send(msg);
        }catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }
}
