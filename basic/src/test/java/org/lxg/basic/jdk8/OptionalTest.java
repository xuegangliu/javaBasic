package org.lxg.basic.jdk8;

import com.lxg.common.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import javax.swing.text.html.Option;
import java.util.NoSuchElementException;
import java.util.Optional;

/**************************
 *  OptionalTest
 * @author xuegangliu
 *  2019/4/10 14:33
 * @since: jdk1.8+
 ***************************/
@Slf4j
public class OptionalTest {

    @Test
//    @Test(expected = NoSuchElementException.class)
    public void testOptionalIsNull(){
        Optional<String> emptyOpt = Optional.empty();
//        emptyOpt.get(); // null throws java.util.NoSuchElementException: No value present
//        emptyOpt.of(null); // 数据不为空的时候使用 throws java.lang.NullPointerException
        emptyOpt.ofNullable(null);
    }

//    @Test
    public void testOptionalGetValue(){
        String hello = null;
        log.info("hello:{}",hello);

//        String hello = "Hello World";
        // check params if null
        Optional<String> opt = Optional.ofNullable(hello);
        log.info("opt.get:{}",opt.get());
    }

    @Test
    public void testOptionOrElseGet(){
        UserEntity entity = new UserEntity("Tony",123);
        UserEntity entity1 = new UserEntity();// 默认构造参数 Hello 0
        UserEntity entity2 = null;

        // check obj
        Optional<UserEntity> optional = Optional.ofNullable(entity);
        Optional<UserEntity> optional1 = Optional.ofNullable(entity1);
//        Optional<UserEntity> optional2 = Optional.ofNullable(entity2);

        // 对象不为空orElse() 方法仍然创建对象  对象不为空orElseGet() 方法不创建对象。
//        Optional<UserEntity> optional2 = Optional.ofNullable(Optional.ofNullable(entity2).orElse(new UserEntity()));
//        Optional<UserEntity> optional2 = Optional.ofNullable(Optional.ofNullable(entity1).orElseGet(() ->new UserEntity()));
        Optional<UserEntity> optional2 = Optional.ofNullable(Optional.ofNullable(entity2).orElseGet(() ->new UserEntity()));

        Assert.assertEquals("Tony",optional.get().getName());
        Assert.assertEquals("Hello",optional1.get().getName());
        Assert.assertEquals(true,optional1.isPresent());
        Assert.assertEquals("Hello",optional2.get().getName());
        Assert.assertEquals(null,optional2.get().getAge());

        // optional2 不为空时,执行断言
        optional2.ifPresent(t ->
                Assert.assertEquals(null,t.getAge())
        );
    }
}
