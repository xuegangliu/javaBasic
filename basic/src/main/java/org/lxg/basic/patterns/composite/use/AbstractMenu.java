package org.lxg.basic.patterns.composite.use;

/**
 * @author xuegangliu
 * @date 2017/1/25 0025.
 */
abstract class AbstractMenu {

    /**add
     *
     * @param menu
     */
    public abstract void add(AbstractMenu menu);

    /**
     * get
     * @param index
     * @return
     */
    public abstract AbstractMenu get(int index);

    /**
     * getString
     * @return
     */
    public abstract String getString();
}
