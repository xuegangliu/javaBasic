package org.lxg.basic.util;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

/**************************
 * @description 图片添加水印
 * @author xuegangliu
 * @date 2019/1/23
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
        //水印颜色
        Color markContentColor = Color.LIGHT_GRAY;
        //设置水印文字的旋转角度
        Integer degree = -30;
        //设置水印透明度 默认为1.0  值越小颜色越浅
        float alpha = 0.5f;
        OutputStream outImgStream = null;
        try {
            //得到文件
//            File srcImgFile = new File(sourceImgPath);
            //文件转化为图片
            Image srcImg = ImageIO.read(inputStream);
            //获取图片的宽
            int srcImgWidth = srcImg.getWidth(null);
            //获取图片的高
            int srcImgHeight = srcImg.getHeight(null);
            // 加水印
            BufferedImage bufImg = new BufferedImage(srcImgWidth, srcImgHeight, BufferedImage.TYPE_INT_RGB);
            //得到画笔
            Graphics2D g = bufImg.createGraphics();
            g.drawImage(srcImg, 0, 0, srcImgWidth, srcImgHeight, null);
            //设置水印颜色
            g.setColor(markContentColor);
            int size = srcImgWidth>srcImgHeight?srcImgHeight/35:srcImgWidth/35;
            //水印字体，大小
            Font font = new Font("宋体", Font.BOLD, size);
            //设置字体
            g.setFont(font);
            //设置水印文字透明度
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
            if (null != degree) {
                //设置水印旋转
                g.rotate(Math.toRadians(degree),(double)bufImg.getWidth(),(double)bufImg.getHeight());
            }
            //文字水印的宽

            int x = -srcImgWidth / 2;
            int y;
            // 字体长度
            int markWidth = size * getTextLength (waterMarkContent);
            int xMove = srcImgWidth/3;
            int yMove = srcImgHeight/5;
            double m = 1.5;
            while (x < srcImgWidth * m) {
                y = -srcImgHeight / 2;
                while (y < srcImgHeight * m) {
                    g.drawString(waterMarkContent, x, y);
                    y += size + yMove;
                }
                x += markWidth + xMove;
            }
            // 释放资源
            g.dispose();
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
