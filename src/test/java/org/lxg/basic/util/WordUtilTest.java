package org.lxg.basic.util;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**************************
 * @description: WordUtilTest
 * @user: xuegangliu
 * @date: 2019/1/29 10:49
 ***************************/
public class WordUtilTest {

    @Test
    public void testCreateWordDoc() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("title", "Test");
        map.put("year", "2019");
        map.put("month","01");
        map.put("company", "xxxx");
        try {
            WordUtil.createDoc(map,"test.ftl","test_1.doc");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
