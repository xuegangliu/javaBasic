package com.lxg.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**************************
 * @description: UserEntity
 * @author xuegangliu
 * @date: 2019/4/10 15:14
 * @since: jdk1.8+
 ***************************/
@Data
@ToString
@AllArgsConstructor
@Slf4j
public class UserEntity {
    private String name;
    private Integer age;

    public UserEntity(){
        log.info("UserEntity()");
        name = "Hello";
        age = null;
    }
}
