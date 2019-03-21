package com.lxg.common.util.crawler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * ClassName: DataDownloaderUtil
 * Package ：com.lxg.common.util.crawler
 * Description: 搜索引擎爬虫技术  批量抓取
 * @author lxg
 * @date 2017年9月12日 上午10:38:35
 * @version v1.0
 */
public class DataDownloaderUtil {

    /**
     * 根据网址和页面的编码集  获取网页的源代码
     * @param url 需要被获取源代码的网址
     * @param encoding  网页的编码集
     * @return String 网页的源代码
     *
     * */
    public static String getHtmlResourceByUrl(String url ,String encoding){

        // 存储源代码的容器
        StringBuffer buffer = new StringBuffer();
        // 建立网页连接
        URL urlObj = null;
        // 打开网络连接
        URLConnection uc = null;
        // 建立文件的写入流
        InputStreamReader isr = null;
        // 在内存中建立缓冲写入流
        BufferedReader reader = null;

        try {
            // 建立网页连接
            urlObj = new URL(url);
            // 打开网络连接
            uc = urlObj.openConnection();
            // 建立文件的写入流
            isr = new InputStreamReader(uc.getInputStream(),encoding);
            // 在内存中建立缓冲写入流
            reader = new BufferedReader(isr);
            // 建立临时文件
            String temp = null;
            // 循环读取网页源码
            while((temp = reader.readLine()) != null){
                // 添加到buffer的尾部
                buffer.append(temp+"\n");
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println("世界上最遥远的距离就是没网,请检查网络设置！！！");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("您的网络打开失败，请稍后重试......");
        } finally {
            if(isr != null){
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("文件写入流关闭失败。");
                }
            }
        }
        return buffer.toString();
    }
}
