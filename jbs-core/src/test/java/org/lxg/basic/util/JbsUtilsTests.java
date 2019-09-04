package org.lxg.basic.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.lang.management.ManagementFactory;

/**
 * JbsUtilsTests
 * <p>
 * This is description
 * </p>
 *
 * @author xuegangliu 2019/08/29
 * @since 1.8
 **/
@Slf4j
public class JbsUtilsTests {

    @Test
    public void test_format(){
        log.error(JbsUtils.format("{} hello,{} world",new Object[]{"1234",4}));
        String jvmName = ManagementFactory.getRuntimeMXBean().getName();
        log.error("{}",jvmName);
    }

}
