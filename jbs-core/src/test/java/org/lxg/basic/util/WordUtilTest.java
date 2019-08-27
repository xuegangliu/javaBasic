package org.lxg.basic.util;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**************************
 *  WordUtilTest
 * @user: xuegangliu
 *  2019/1/29 10:49
 ***************************/
public class WordUtilTest {

//    @Test
    public void testCreateWordDoc() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("title", "Test");
        map.put("year", "2019");
        map.put("month","01");
        map.put("company", "xxxx");
        try {
            WordUtil.createDoc(map,"test.ftl","test_1.doc");
            File t = new File("test_1.doc");
            Thread.sleep(6000l);
            if(t.exists())
                t.delete();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
