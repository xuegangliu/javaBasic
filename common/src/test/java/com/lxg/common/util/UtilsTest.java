package com.lxg.common.util;

import com.lxg.common.util.crawler.DataDownloaderUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**************************
 *  UtilsTest
 * @author xuegangliu
 *  2019/3/21 14:31
 ***************************/
public class UtilsTest {

    @Test
    public void test(){
        String url = "http://tuan.ctrip.com/group/hotel/city_shanghai/#ctm_ref=gro_hp_ac_def_b";
        String encoding = "gb2312";

        // 创建一个List集合
        List<HashMap<String,String>> maps = new ArrayList<HashMap<String,String>>();

        // 根据网址和页面编码集获取网页的源代码
        String html = DataDownloaderUtil.getHtmlResourceByUrl(url, encoding);
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
