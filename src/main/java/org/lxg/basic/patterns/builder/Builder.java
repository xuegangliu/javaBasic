package org.lxg.basic.patterns.builder;

/**
 * 描述:抽象Builder类
 * Created by Administrator on 2017/1/16 0016.
 */
interface Builder {

    void setSex(String sex);

    void setFace(String face);

    void setClothes(String clothes);

    Character build();

}
