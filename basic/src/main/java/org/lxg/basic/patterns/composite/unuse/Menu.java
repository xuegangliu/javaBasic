package org.lxg.basic.patterns.composite.unuse;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuegangliu
 *  2017/1/25 0025.
 */
class Menu {
    private String name;
    private String desc;
    /** 子菜单 */
    private List<Menu> menus = new ArrayList<>();
    private List<Juice> juices = new ArrayList<>();
    private List<MilkTea> teas = new ArrayList<>();
    private List<HandCake> handCakes = new ArrayList<>();
    private List<FishBall> fishBalls = new ArrayList<>();

    Menu(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    void addMenu(Menu menu) { menus.add(menu); }

    void addJuice(Juice juice) { juices.add(juice); }

    void addMilkTea(MilkTea tea) { teas.add(tea); }

    void addHandCake(HandCake cake) { handCakes.add(cake); }

    void addFishBall(FishBall ball) { fishBalls.add(ball); }

    @Override public String toString() {
        String line = "\n";
        StringBuilder sb = new StringBuilder("\n【菜单】：" + name + " 信息：" + desc + line);
        for (Menu menu: menus) { sb.append(menu.toString()).append(line); }
        for (Juice juice: juices) { sb.append(juice.toString()).append(line); }
        for (MilkTea tea: teas) { sb.append(tea.toString()).append(line); }
        for (HandCake cake: handCakes) { sb.append(cake.toString()).append(line); }
        for (FishBall ball: fishBalls) { sb.append(ball.toString()).append(line); }
        return sb.toString();
    }
}
