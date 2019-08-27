package org.lxg.basic.patterns.mediator;

import org.junit.Test;

/**
 * @author xuegangliu
 *  8/30/2018 3:12 PM
 *
 * @version: v1.0
 */
public class MediatorTest {

    @Test
    public void mediatorTest(){
        //实例化中介者
        HouseMediator mediator = new HouseMediator();
        //实例化同事对象，传入中介者实例
        Landlord landlord = new Landlord("包租婆",mediator);
        Tenant tenant = new Tenant("小猪",mediator);
        //为中介者传入同事实例
        mediator.setLandlord(landlord);
        mediator.setTenant(tenant);
        //调用
        landlord.contact("单间500一个月，有兴趣吗？");
        tenant.contact("热水器，空调，网线有吗？");
        landlord.contact("都有。");
        tenant.contact("好吧，我租了。");
    }
}
