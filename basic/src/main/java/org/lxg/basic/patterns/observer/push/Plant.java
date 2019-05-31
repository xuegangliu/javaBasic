package org.lxg.basic.patterns.observer.push;

/**
 * @author xuegangliu
 * @date 2017/3/16 0016.
 */
public interface Plant {

    /**
     * registerInsect
     * @param insect
     */
    void registerInsect(Insect insect);

    /**
     * unregisterInsect
     * @param insect
     */
    void unregisterInsect(Insect insect);

    /**
     * notifyInsect
     * @param isOpen
     */
    void notifyInsect(boolean isOpen);
}
