package com.ghl.EmailSender;

public class MailController {

    public static void main(String[] args) {
        MailUtil mailUtil = new MailUtil();
        try {
            String html = "<!DOCTYPE html>"+
                    "<html>"+
                        "<head>"+
                            "<meta charset=\"utf-8\">"+
                            "<title></title>"+
                        "</head>"+
                        "<body>"+
                            "<p>尊敬的XXXX公司集团：</p>"+
                            "<p style=\"text-indent:2em;\">截至5月22日18时30分，您的账户余额为30000.00元，为了不影响您的正常使用，请及时充值。如有疑问，请联系五洲运通平台对接人员。</p>"+
                        "</body>"+
                    "</html>";
            mailUtil.sendMail("15022195606@163.com", "【五洲运通】余额提醒", html);

        } catch (Exception e) {

        }

    }
}
