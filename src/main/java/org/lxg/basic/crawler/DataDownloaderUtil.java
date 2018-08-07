package org.lxg.basic.crawler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * ClassName: DataDownloaderUtil
 * Package ：com.lxg.test
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

    public static void main(String[] args) {

        String url = "http://tuan.ctrip.com/group/hotel/city_shanghai/#ctm_ref=gro_hp_ac_def_b";
        String encoding = "gb2312";

        // 创建一个List集合
        List<HashMap<String,String>> maps = new ArrayList<HashMap<String,String>>();

        // 根据网址和页面编码集获取网页的源代码
        String html = getHtmlResourceByUrl(url, encoding);
//		System.out.println(html);
        // 解析源代码
        Document document = Jsoup.parse(html);
        // 获取酒店最外层的div盒子源代码  id="hot_list"
        Element element = document.getElementById("gp-list-left");
        // 获取酒店结果列表  class="searchresult_info"
        Elements elements = document.getElementsByClass("gp-list-box");

        // 遍历
        for(Element el : elements){

            // 采用集合存储获取到的所有酒店信息
            HashMap<String,String> map = new HashMap<String,String>();

            // 获取酒店的图片
            String imgSrc = el.getElementsByTag("img").attr("src");
            // 获取酒店的名字
            String title = el.getElementsByTag("h3").text();
            // 获取酒店描述
            String content = el.getElementsByTag("p").text();
            // 获取酒店链接
            String href = el.getElementsByTag("a").attr("href");

            map.put("imgSrc", imgSrc);
            map.put("title", title);
            map.put("content", content);
            map.put("href", href);

            maps.add(map);
        }

        // 筛选
        if(maps != null && maps.size() > 0){
            for(HashMap<String, String> map : maps){
                System.out.println("酒店的名字："+ map.get("title"));
                System.out.println("酒店的图片："+ map.get("imgSrc"));
                System.out.println("酒店的描述："+ map.get("content"));
                System.out.println("酒店的链接地址："+ map.get("href"));
            }
        }
    }
}
