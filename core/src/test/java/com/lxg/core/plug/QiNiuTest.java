package com.lxg.core.plug;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;

/**************************
 *  QiNiuTest
 * @author xuegangliu
 *  2019/3/1 16:58
 ***************************/
@Slf4j
public class QiNiuTest {

    @Test
    public void test1() throws FileNotFoundException {
        String result = QiNiuPlug.upLoadImage(new File("D:\\AA.jpg"));
        log.info(result);
    }
}
