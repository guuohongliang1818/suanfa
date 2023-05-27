package com.ghl.EmailSender;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MailController {

    public static void main(String[] args) {
        MailUtil mailUtil = new MailUtil();
        try {
            String html = "<!DOCTYPE html>" +
                    "<html>" +
                    "<head>" +
                    "<meta charset=\"utf-8\">" +
                    "<title></title>" +
                    "</head>" +
                    "<body>" +
                    "<p>尊敬的name：</p>" +
                    "<p style=\"text-indent:2em;\">截至date，您的账户余额为balance元，为了不影响您的正常使用，请及时充值。如有疑问，请联系五洲运通平台对接人员。</p>" +
                    "</body>" +
                    "</html>";
            SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日HH时mm分");
            html = html.replace("name", "效果文化加油站");
            html = html.replace("date", sdf.format(new Date()));
            BigDecimal bd = new BigDecimal(0);
            html = html.replace("balance", String.format("%.2f", bd.movePointLeft(2)));
            System.out.println(html);
            mailUtil.sendMail("15022195606@163.com", "【五洲运通】余额提醒", html);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
