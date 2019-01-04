package org.lxg.get;

import org.junit.Test;
import org.lxg.get.Loader;

/**
 * @author: xuegangliu
 * @date: 8/15/2018 2:48 PM
 * @DES:
 * @version: v1.0
 */
public class LoaderTest {

    @Test
    public void test(){
        System.out.println("-------main start-------");
        new Loader();
        System.out.println("------------------------");
        new Loader();
        System.out.println("-------main end-------");
    }
}
