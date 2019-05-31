package org.lxg.basic.patterns.builder;

/**
 * @author xuegangliu
 * 描述:抽象Builder类
 * Created by Administrator on 2017/1/16 0016.
 */
interface Builder {

    /**
     * setSex
     * @param sex
     */
    void setSex(String sex);

    /**
     * setFace
     * @param face
     */
    void setFace(String face);

    /**
     * setClothes
     * @param clothes
     */
    void setClothes(String clothes);

    /**
     * build
     * @return
     */
    Character build();

}
