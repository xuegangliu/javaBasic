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
     * @param inputStream 源图片路径
     * @param tarImgPath 保存的图片路径
     * @param waterMarkContent 水印内容
     * @param fileExt 图片格式
     * @return void
     */
//    public static void addWatermark(String sourceImgPath, String tarImgPath, String waterMarkContent,String fileExt){
    public static void addWatermark(InputStream inputStream, String tarImgPath, String waterMarkContent, String fileExt){
//        Font font = new Font("宋体", Font.BOLD, 24);//水印字体，大小
//        Font font = new Font("宋体", Font.BOLD, 14);//水印字体，大小
        Font font = null;//水印字体，大小
//        Color markContentColor = Color.white;//水印颜色
        Color markContentColor = Color.GRAY;//水印颜色
        Integer degree = -30;//设置水印文字的旋转角度
        float alpha = 1.0f;//设置水印透明度 默认为1.0  值越小颜色越浅
        OutputStream outImgStream = null;
        try {
//            File srcImgFile = new File(sourceImgPath);//得到文件
            Image srcImg = ImageIO.read(inputStream);//文件转化为图片
            int srcImgWidth = srcImg.getWidth(null);//获取图片的宽
            int srcImgHeight = srcImg.getHeight(null);//获取图片的高
//            int size = srcImgWidth>srcImgHeight?
//                    (srcImgHeight<600?srcImgHeight*4:srcImgHeight)/70:(srcImgWidth<600?srcImgWidth*4:srcImgWidth)/70;
            int size = 14;
            font = new Font("宋体", Font.BOLD, size);

            // 加水印
            BufferedImage bufImg = new BufferedImage(srcImgWidth, srcImgHeight, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = bufImg.createGraphics();//得到画笔
            g.drawImage(srcImg, 0, 0, srcImgWidth, srcImgHeight, null);
            g.setColor(markContentColor); //设置水印颜色
            g.setFont(font);              //设置字体
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));//设置水印文字透明度
            if (null != degree) {
                g.rotate(Math.toRadians(degree),(double)bufImg.getWidth(),(double)bufImg.getHeight());//设置水印旋转
            }
            JLabel label = new JLabel(waterMarkContent);
            FontMetrics metrics = label.getFontMetrics(font);
            int width = metrics.stringWidth(label.getText());//文字水印的宽
            width = width>40?width:40;
            int rowsNumber = srcImgHeight/width+srcImgHeight%width;// 图片的高  除以  文字水印的宽  打印的行数(以文字水印的宽为间隔)
//            int rowsNumber = srcImgHeight/width;// 图片的高  除以  文字水印的宽  打印的行数(以文字水印的宽为间隔)
            int columnsNumber = srcImgWidth/width+srcImgWidth%width;//图片的宽 除以 文字水印的宽  每行打印的列数(以文字水印的宽为间隔)
//            int columnsNumber = srcImgWidth/(width);//图片的宽 除以 文字水印的宽  每行打印的列数(以文字水印的宽为间隔)
            //防止图片太小而文字水印太长，所以至少打印一次
            if(rowsNumber < 1){
                rowsNumber = 1;
            }
            if(columnsNumber < 1){
                columnsNumber = 1;
            }
//            for(int j=0;j<rowsNumber*2;j++){
//                for(int i=0;i<columnsNumber;i++){
//                    g.drawString(waterMarkContent, i*width/2 + j*width, -i*width/2 + j*width);//画出水印,并设置水印位置
//                }
//            }

            for(int j=0;j<rowsNumber;j++){
                for(int i=0;i<columnsNumber;i++){
                    g.drawString(waterMarkContent, i*width + j*width, -i*width + j*width);//画出水印,并设置水印位置
                }
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
}
