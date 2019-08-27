package org.lxg.basic.patterns.iterator;

/**
 * @author xuegangliu
 *  2017/3/16 0016.
 */
public interface Iterator {

    /**
     * first
     * @return
     */
    Song first();

    /**
     * next
     * @return
     */
    Song next();

    /**
     * hashNext
     * @return
     */
    boolean hashNext();

    /**
     * currentItem
     * @return
     */
    Song currentItem();
}
