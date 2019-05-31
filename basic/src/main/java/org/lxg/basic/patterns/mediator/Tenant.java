package org.lxg.basic.patterns.mediator;

/**
 * @author xuegangliu
 * @date 2017/3/16 0016.
 */
public class Tenant extends AbstractPeople {

    public Tenant(String name, AbstractMediator mediator) {
        super(name, mediator);
    }

    public void contact(String msg) {
        mediator.contact(this, msg);
    }

    public void getMessage(String msg) {
        System.out.println("【房客】" + name + "：" + msg);
    }

}
