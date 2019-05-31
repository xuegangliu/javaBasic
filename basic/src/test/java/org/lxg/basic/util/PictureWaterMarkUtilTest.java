package org.lxg.basic.util;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**************************
 *  PictureWaterMarkUtilTest
 * @user: xuegangliu
 *  2019/1/24 9:02
 ***************************/
public class PictureWaterMarkUtilTest {

    @Test
    public void testWaterMark() {
        System.out.println("开始水印：");
        FileInputStream is = null;
        try {
            is = new FileInputStream(new File("D:/1.jpg"));
//            is = new FileInputStream(new File("D:/D.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//        new PictureWaterMarkUtil().addWatermark(is, "D:/new1.jpg", "xxxxxxxxx", "jpg");
        System.out.println("水印完成。");
    }
}
