package com.lxg.problem.http;

import com.lxg.common.util.HttpClientTools;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**************************
 * @description: HttpTest
 * @author: xuegangliu
 * @date: 2019/3/15 13:29
 ***************************/
@Slf4j
public class HttpTest {

    @Test
    public void testPost(){
        String url = "https://id.exocr.com:8080/bankcard";

        String result = HttpClientTools.doPost(url);

        log.info(result);

    }
}
