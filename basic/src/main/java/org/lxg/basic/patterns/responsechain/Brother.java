package org.lxg.basic.patterns.responsechain;

/**
 * @author xuegangliu
 *  2017/3/16 0016.
 */
public class Brother extends AbstractHandler {
    private final Integer NUM = 100;
    @Override
    public void handlerRequest(String str, int money) {
        if(money <= NUM) {
            System.out.println("哥哥：100块，哥哥还是有的，给你~");
        } else {
            if(getNextHandler() != null) {
                System.out.println("哥哥：大于100块，哥哥木有那么多钱，找粑粑去~");
                getNextHandler().handlerRequest(str, money);
            } else {
                System.out.println("哥哥：大于100块，哥哥木有那么多钱，粑粑不在家~");
            }
        }
    }
}
