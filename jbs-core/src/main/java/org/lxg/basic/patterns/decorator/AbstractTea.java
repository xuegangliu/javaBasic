package org.lxg.basic.patterns.decorator;

/**
 * @author xuegangliu
 *  2017/1/21 0021.
 */
abstract class AbstractTea {
    private String name = "茶";

    public String getName() { return name; }

    void setName(String name) { this.name = name; }

    /**
     * price
     * @return
     */
    public abstract int price();
}
