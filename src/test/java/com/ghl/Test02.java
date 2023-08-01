package com.ghl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class Test02 {
    @Test
    public void test_01() {
        QrCodeUtil.generate("https://www.baidu.com/", 300, 300, FileUtil.file("e:/qrcode.jpg"));
    }

    @Test
    public void test_02() {
        QrConfig config = new QrConfig(400, 400);
        // 设置边距，既二维码和背景之间的边距
        config.setMargin(3);
        // 设置前景色，既二维码颜色（青色）
        //        config.setForeColor(Color.CYAN.getRGB());
        //// 设置背景色（灰色）
        //        config.setBackColor(Color.GRAY.getRGB());

        // 生成二维码到文件，也可以到流
        //File crcode = QrCodeUtil.generate("https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&rsv_idx=1&tn=baidu&wd=%E4%BD%A0%E5%A5%BD&fenlei=256&rsv_pq=0x8df8ed020028fa3e&rsv_t=e3ebJXpZX%2B48Lb0Aoz5oH0AgOvd3xW3CXFYMF9ZxxrkJSYpX4Cxr9ein5GSR&rqlang=en&rsv_enter=1&rsv_dl=tb&rsv_sug3=3&rsv_sug1=3&rsv_sug7=101&rsv_sug2=0&rsv_btype=i&inputT=1132&rsv_sug4=1749", config, FileUtil.file("e:/qrcode.jpg"));
        //输出流

        BufferedImage bufferedImage = QrCodeUtil.generate("https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&rsv_idx=1&tn=baidu&wd=%E4%BD%A0%E5%A5%BD&fenlei=256&rsv_pq=0x8df8ed020028fa3e&rsv_t=e3ebJXpZX%2B48Lb0Aoz5oH0AgOvd3xW3CXFYMF9ZxxrkJSYpX4Cxr9ein5GSR&rqlang=en&rsv_enter=1&rsv_dl=tb&rsv_sug3=3&rsv_sug1=3&rsv_sug7=101&rsv_sug2=0&rsv_btype=i&inputT=1132&rsv_sug4=1749", config);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        try {
            ImageIO.write(bufferedImage, "jpg", stream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test_03() throws Exception {
        /**
         * 1.设置背景板
         */
        // 设置背景宽高
        int width = 800, height = 800;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        // 获取图形上下文对象
        Graphics graphics = image.getGraphics();
        // 填充
        graphics.fillRect(0, 0, width, height);
        // 设定字体大小及样式
        graphics.setFont(new Font("宋体", Font.BOLD, 20));
        // 字体颜色
        graphics.setColor(Color.BLUE);

        //graphics.dispose();
        //return image;
        /**
         *2.生成二维码
         */
        QrConfig config = new QrConfig(400, 400);
        // 设置边距，既二维码和背景之间的边距
        config.setMargin(3);
        // 设置前景色，既二维码颜色（青色）
        //        config.setForeColor(Color.CYAN.getRGB());
        //// 设置背景色（灰色）
        //        config.setBackColor(Color.GRAY.getRGB());

        // 生成二维码到文件，也可以到流
        //File crcode = QrCodeUtil.generate("https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&rsv_idx=1&tn=baidu&wd=%E4%BD%A0%E5%A5%BD&fenlei=256&rsv_pq=0x8df8ed020028fa3e&rsv_t=e3ebJXpZX%2B48Lb0Aoz5oH0AgOvd3xW3CXFYMF9ZxxrkJSYpX4Cxr9ein5GSR&rqlang=en&rsv_enter=1&rsv_dl=tb&rsv_sug3=3&rsv_sug1=3&rsv_sug7=101&rsv_sug2=0&rsv_btype=i&inputT=1132&rsv_sug4=1749", config, FileUtil.file("e:/qrcode.jpg"));
        //输出流

        BufferedImage bufferedImage = QrCodeUtil.generate("https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&rsv_idx=1&tn=baidu&wd=%E4%BD%A0%E5%A5%BD&fenlei=256&rsv_pq=0x8df8ed020028fa3e&rsv_t=e3ebJXpZX%2B48Lb0Aoz5oH0AgOvd3xW3CXFYMF9ZxxrkJSYpX4Cxr9ein5GSR&rqlang=en&rsv_enter=1&rsv_dl=tb&rsv_sug3=3&rsv_sug1=3&rsv_sug7=101&rsv_sug2=0&rsv_btype=i&inputT=1132&rsv_sug4=1749", config);
        //写入图片
        graphics.drawImage(bufferedImage,250,30,null);


        /**
         * 3.写入数字
         */
        String strs[] = new String[5];
        strs[0] = "订单号：D112308013829";
        strs[1] = "客户名：3924239803243";
        strs[2] = "客户名：3924239803243";
        strs[3] = "客户名：3924239803243";
        strs[4] = "发货地：太原发货地";
        // 获取BufferedImage对象
        for (int i = 0; i < strs.length; i++) {
            // 描绘字符串
            graphics.drawString(strs[i], 250, 450 + (i + 1) * 40);
        }

        graphics.dispose();
        //BufferedImage image = createImage(strs);
        File file = new File("e:");
        String fileName = "111.jpg";
        File jpgFile = new File(file, fileName);
        if (!jpgFile.exists()) {
            jpgFile.createNewFile();
        }
        // 创建图片输出流对象，基于文件对象
        ImageOutputStream imageOutputStream = ImageIO.createImageOutputStream(jpgFile);
        // 写入
        ImageIO.write(image, "jpg", imageOutputStream);
        // 关闭流
        imageOutputStream.close();



        System.out.println("图片写入完成，请查看！");

    }

    public static BufferedImage createImage(String[] strs) {
        // 设置背景宽高
        int width = 800, height = 800;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        // 获取图形上下文对象
        Graphics graphics = image.getGraphics();
        // 填充
        graphics.fillRect(0, 0, width, height);
        // 设定字体大小及样式
        graphics.setFont(new Font("宋体", Font.BOLD, 20));
        // 字体颜色
        graphics.setColor(Color.BLUE);
        for (int i = 0; i < strs.length; i++) {
            // 描绘字符串
            graphics.drawString(strs[i], 250, 450 + (i + 1) * 40);
        }
        graphics.dispose();
        return image;
    }
}
