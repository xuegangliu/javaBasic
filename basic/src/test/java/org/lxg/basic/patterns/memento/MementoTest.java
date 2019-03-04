package org.lxg.basic.patterns.memento;

import org.junit.Test;

/**
 * @author: xuegangliu
 * @date: 8/30/2018 11:54 AM
 * @DES:
 * @version: v1.0
 */
public class MementoTest {

    @Test
    public void test(){
        Caretaker caretaker= new Caretaker();
        Character character = new Character(2000,1000,500);
        //存档
        System.out.println("=== 存档中... ===");
        character.showMsg();
        caretaker.setMemento(character.save());

        System.out.println("=== 单挑Boss，不敌，金钱扣除一半... ===");
        character.setHp(0);
        character.setHp(0);
        character.setHp(250);
        character.showMsg();

        //读档
        System.out.println("=== 读取存档中... ===");
        character.restore(caretaker.getMemento());
        character.showMsg();
    }
}
