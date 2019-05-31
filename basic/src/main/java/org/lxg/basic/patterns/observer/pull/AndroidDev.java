package org.lxg.basic.patterns.observer.pull;

/**
 * @author xuegangliu
 * @date 2017/3/16 0016.
 */
public class AndroidDev implements User {
    @Override public void update(AbstractOfficialAccount account) {
        System.out.println("读者查看公众号更新信息：" +  ((CoderPig)account).getMsg());
    }
}
