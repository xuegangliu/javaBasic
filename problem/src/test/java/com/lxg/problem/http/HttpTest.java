package com.lxg.problem.http;

import com.alibaba.fastjson.JSONObject;
import com.lxg.common.util.HttpClientTools;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**************************
 *  HttpTest
 * @author xuegangliu
 *  2019/3/15 13:29
 ***************************/
@Slf4j
public class HttpTest {

    @Test
    public void testPost(){
        String url = "https://id.exocr.com:8080/bankcard";

        String result = HttpClientTools.doPost(url);

        log.info(result);

    }

    @Test
    public void testQuery(){
        String url = "http://v.juhe.cn/verifybankcard3/query";
        Map params = new HashMap<>();
//        key string 是 在个人中心->我的数据,接口名称上方查看
//        realname string 是 姓名，需要utf8 Urlencode
//        idcard string 是 身份证号码
//        bankcard string 是 银行卡卡号
//        uorderid string 否 用户订单号,8到32位数字字母组合，要保
//        isshow int 否 是否显示匹配信息0默认不显示，1
        params.put("key","test");
        params.put("realname","test");
        params.put("idcard","test");
        params.put("bankcard","test");
        params.put("uorderid","test");
        params.put("isshow","test");
        log.info("请求参数:{}", JSONObject.toJSON(params));
        String result = HttpClientTools.doPost(url,params);
        log.info("返回参数:{}", result);
    }

//    @Test
    public void testVerify(){
        String url = "http://v.juhe.cn/verifybankcard3/verify";
        Map params = new HashMap<>();
//        key string 是 在个人中心->我的数据,接口名称上方查看
//        realname string 是 姓名，需要utf8 Urlencode
//        idcard string 是 身份证号码
//        bankcard string 是 银行卡卡号
//        uorderid string 否 用户订单号,不超过32位，要保证唯一
//        isshow int 否 是否显示匹配信息,0默认不显示，1显示
//        sign string 是 md5(openid+appkey+bankcard+realname+idcard),openid在个人中心查询

        params.put("key","test");
        params.put("realname","test");
        params.put("idcard","test");
        params.put("bankcard","test");
        params.put("uorderid","test");
        params.put("isshow","test");
        params.put("sign","test");
        log.info("请求参数:{}", JSONObject.toJSON(params));
        String result = HttpClientTools.doPost(url,params);
        log.info("返回参数:{}", result);
    }
}
