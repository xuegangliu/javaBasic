package com.lxg.problem.simple;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * Test1
 * <p>
 * This is description
 * </p>
 *
 * @author xuegangliu 2019/08/29
 * @since 1.8
 **/
@Slf4j
public class Test1 {

    @Test
    public void test1(){
        log.error("{}","\033[0m");
        log.error("{}","[32m" + 11 + "[0m");
        System.out.println("[32m" + 11 + "[0m");

    }
}
