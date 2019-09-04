package com.lxg.problem.others;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * BaseTests
 * <p>
 * This is description
 * </p>
 *
 * @author xuegangliu 2019/09/03
 * @since 1.8
 **/
@Slf4j
public class BaseTests {

    @Test
    public void test1(){
        Byte t =126;
        Byte t1 =126;
        log.error("{},{}",Byte.MAX_VALUE,Byte.MIN_VALUE);
        log.error("{}",t==t1);
    }
}
