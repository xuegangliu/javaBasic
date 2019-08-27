package org.lxg.basic.patterns.visitor;

/**
 * @author xuegangliu
 *  2017/3/16 0016.
 */
public class Driving implements Machine{

    @Override public void accept(Player player) {
        player.visit(this);
    }

    public String feature() {
        return "开车";
    }
}
