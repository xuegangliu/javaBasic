package org.lxg.basic.patterns.interpreter;

/**
 * @author xuegangliu
 *  2017/3/16 0016.
 */
public abstract class AbstractExpression {

    /**
     * interpret
     * @param context
     * @return
     */
    public abstract int interpret(Context context);

    /**
     * toString
     * @return
     */
    @Override
    public abstract String toString();

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
