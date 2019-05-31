package org.lxg.basic.patterns.mediator;

/**
 * @author xuegangliu
 * @date 2017/3/16 0016.
 */
public abstract class AbstractMediator {

    /**
     * contact
     * @param people
     * @param msg
     */
    abstract void contact(AbstractPeople people, String msg);
}
