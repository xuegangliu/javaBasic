package org.lxg.basic.patterns.responsechain;

/**
 * @author xuegangliu
 *    2017/3/20 0020.
 */
public abstract class AbstractHandler {

    /** 下家处理者 */
    private AbstractHandler nextHandler;

    public AbstractHandler getNextHandler() {
        return  nextHandler;
    }

    public void setNextHandler(AbstractHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    /**
     * 请求
     * @param str
     * @param money
     */
    public abstract void handlerRequest(String str, int money);

}
