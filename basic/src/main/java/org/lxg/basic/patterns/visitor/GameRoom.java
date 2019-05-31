package org.lxg.basic.patterns.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuegangliu
 * @date 2017/3/16 0016.
 */
public class GameRoom  {

    private List<Machine> machines = new ArrayList<>();

    public void add(Machine machine) {
        machines.add(machine);
    }

    public void action(Player player) {
        for (Machine machine: machines) {
            machine.accept(player);
        }
    }
}
