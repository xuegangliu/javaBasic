package org.lxg.basic.patterns.observer.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @author xuegangliu
 * @date 2017/3/16 0016.
 */
public class AndroidDev implements Observer{
    @Override public void update(Observable o, Object object) {
        System.out.println("收到公众号更新信息：" + object);
    }
}
