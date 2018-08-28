package org.lxg.basic.patterns.state;

import org.junit.Test;

/**
 * @author: xuegangliu
 * @date: 8/28/2018 3:55 PM
 * @DES:
 * @version: v1.0
 */
public class StateTest {

    @Test
    public void stateTest(){
        MorningState morningState = new MorningState();
        AfternoonState afternoonState = new AfternoonState();
        EveningState eveningState = new EveningState();

        Context context = new Context();
        context.setState(morningState);
        context.setState(afternoonState);
        context.setState(eveningState);
    }
}
