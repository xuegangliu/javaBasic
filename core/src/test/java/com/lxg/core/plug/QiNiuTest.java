package com.lxg.core.plug;

import lombok.extern.log4j.Log4j2;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;

/**************************
 * @description: QiNiuTest
 * @author: xuegangliu
 * @date: 2019/3/1 16:58
 ***************************/
@Log4j2
public class QiNiuTest {

    @Test
    public void test1() throws FileNotFoundException {
        String result = QiNiuPlug.upLoadImage(new File("D:\\AA.jpg"));
        log.info(result);
    }
}
