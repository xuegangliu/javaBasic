package org.lxg.basic.patterns.visitor;

import org.junit.Test;

/**
 * @author: xuegangliu
 * @date: 8/24/2018 3:05 PM
 * @DES:
 * @version: v1.0
 */
public class VisitorTest {

    @Test
    public void visitorTest(){
        GameRoom room = new GameRoom();
        room.add(new Shooting());
        room.add(new Dancing());
        room.add(new Driving());

        Player player1 = new MalePlayer();
        Player player2 = new FemalePlayer();

        room.action(player1);
        room.action(player2);
    }
}
