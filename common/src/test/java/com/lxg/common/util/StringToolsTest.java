package com.lxg.common.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**************************
 * @description: StringToolsTest
 * @author: xuegangliu
 * @date: 2019/3/6 15:50
 ***************************/
@Slf4j
public class StringToolsTest {

    @Test
    public void test1(){
        String sql = "select * from a where a.col1=':1' and a.col2=':2' and a.col3=':3' and a.col4=:4";
        log.info("{}",StringTools.getSubCount(sql,":"));
        log.info("{}",StringTools.getSql(sql,new String[]{"a","b","c","d"}));
    }
}
