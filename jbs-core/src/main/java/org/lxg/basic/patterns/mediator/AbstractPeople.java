package org.lxg.basic.patterns.mediator;

/**
 * @author xuegangliu
 */
public abstract class AbstractPeople {
    protected String name;
    /**
     * 每个人都知道中介
     */
    protected AbstractMediator mediator;

    public AbstractPeople(String name, AbstractMediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }
}
