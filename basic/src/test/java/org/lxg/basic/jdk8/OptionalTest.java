package org.lxg.basic.jdk8;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

/**************************
 * @description: OptionalTest
 * @author: xuegangliu
 * @date: 2019/4/10 14:33
 * @since: jdk1.8+
 ***************************/
@Slf4j
public class OptionalTest {

    @Test
//    @Test(expected = NoSuchElementException.class)
    public void testOptionalIsNull(){
        Optional<String> emptyOpt = Optional.empty();
        emptyOpt.get(); // null throws java.util.NoSuchElementException: No value present
        emptyOpt.of(null); // 数据不为空的时候使用 throws java.lang.NullPointerException
        emptyOpt.ofNullable(null);
    }

    @Test
    public void testOptionalGetValue(){
        String hello = null;
        log.info("hello:{}",hello);

//        String hello = "Hello World";
        // check params if null
        Optional<String> opt = Optional.ofNullable(hello);
        log.info("opt.get:{}",opt.get());
    }
}
