package org.lxg.basic.util;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

/**************************
 * @description: 图片添加水印
 * @user: xuegangliu
 * @date: 2019/1/23
 ***************************/
public class PictureWaterMarkUtil {

    /**
     * @description 添加水印
     * @param inputStream 源图片流
     * @param tarImgPath 保存的图片路径
     * @param waterMarkContent 水印内容
     * @param fileExt 图片格式
     * @return void
     */
    public static void addWatermark(InputStream inputStream, String tarImgPath,
                                    String waterMarkContent, String fileExt){
        Color markContentColor = Color.LIGHT_GRAY;//水印颜色
        Integer degree = -30;//设置水印文字的旋转角度
        float alpha = 0.5f;//设置水印透明度 默认为1.0  值越小颜色越浅
        OutputStream outImgStream = null;
        try {
//            File srcImgFile = new File(sourceImgPath);//得到文件
            Image srcImg = ImageIO.read(inputStream);//文件转化为图片
            int srcImgWidth = srcImg.getWidth(null);//获取图片的宽
            int srcImgHeight = srcImg.getHeight(null);//获取图片的高
            // 加水印
            BufferedImage bufImg = new BufferedImage(srcImgWidth, srcImgHeight, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = bufImg.createGraphics();//得到画笔
            g.drawImage(srcImg, 0, 0, srcImgWidth, srcImgHeight, null);
            g.setColor(markContentColor); //设置水印颜色
            int size = srcImgWidth>srcImgHeight?srcImgHeight/35:srcImgWidth/35;
            Font font = new Font("宋体", Font.BOLD, size);//水印字体，大小
            g.setFont(font);              //设置字体
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));//设置水印文字透明度
            if (null != degree) {
                g.rotate(Math.toRadians(degree),(double)bufImg.getWidth(),(double)bufImg.getHeight());//设置水印旋转
            }
//            JLabel label = new JLabel(waterMarkContent);
//            FontMetrics metrics = label.getFontMetrics(font);
//            int markWidth = metrics.stringWidth(label.getText());//文字水印的宽

            int x = -srcImgWidth / 2;
            int y;
            int markWidth = size * getTextLength (waterMarkContent);// 字体长度
            int XMOVE = srcImgWidth/3;
            int YMOVE = srcImgHeight/5;
            while (x < srcImgWidth * 1.5) {
                y = -srcImgHeight / 2;
                while (y < srcImgHeight * 1.5) {
                    g.drawString(waterMarkContent, x, y);
                    y += size + YMOVE;
                }
                x += markWidth + XMOVE;
            }
            g.dispose();// 释放资源
            // 输出图片
            outImgStream = new FileOutputStream(tarImgPath);
            ImageIO.write(bufImg, fileExt, outImgStream);
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        } finally{
            try {
                if(outImgStream != null){
                    outImgStream.flush();
                    outImgStream.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
                e.getMessage();
            }
        }
    }

    /**
     * 获取文本长度。汉字为1:1，英文和数字为2:1
     */
    private static int getTextLength (String text) {
        int length = text.length ();
        for (int i = 0; i < text.length (); i++) {
            String s = String.valueOf (text.charAt (i));
            if (s.getBytes ().length > 1) {
                length++;
            }
        }
        length = length % 2 == 0 ? length / 2 : length / 2 + 1;
        return length;
    }
}
