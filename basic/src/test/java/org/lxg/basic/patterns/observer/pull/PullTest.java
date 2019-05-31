package org.lxg.basic.patterns.observer.pull;

import org.junit.Test;

/**
 * @author xuegangliu
 *  8/30/2018 11:46 AM
 *
 * @version: v1.0
 */
public class PullTest {

    @Test
    public void test(){
        AbstractOfficialAccount account = new CoderPig();
        User user = new AndroidDev();
        account.registerUser(user);
        ((CoderPig)account).update("《观察者模式》");
        account.unregisterUser(user);
    }
}
