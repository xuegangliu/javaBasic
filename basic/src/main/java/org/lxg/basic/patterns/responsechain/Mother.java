package org.lxg.basic.patterns.responsechain;

/**
 * @author xuegangliu
 *  2017/3/16 0016.
 */
public class Mother extends AbstractHandler {
    @Override public void handlerRequest(String str, int money) {
        int k = 1000;
        if(money <= k) {
            System.out.println("麻麻：1000块，麻麻还是有的，给你~");
        } else {
            System.out.println("麻麻：你拿那么多钱干嘛？");
        }
    }
}
