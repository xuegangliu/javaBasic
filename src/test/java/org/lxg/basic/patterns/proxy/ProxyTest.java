package org.lxg.basic.patterns.proxy;

import org.junit.Test;

/**
 * @author: xuegangliu
 * @date: 8/21/2018 2:45 PM
 * @DES:
 * @version: v1.0
 */
public class ProxyTest {

    @Test
    public void proxyTest(){
        Agent agent = new Agent();
        agent.fetchShoes();
    }
}
