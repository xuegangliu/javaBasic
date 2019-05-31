package org.lxg.basic.patterns.interpreter;

/**
 * @author xuegangliu
 * @date 2017/3/16 0016.
 */
public class ConstantAbstractExpression extends AbstractExpression {

    private int value;

    public ConstantAbstractExpression(int value) {
        this.value = value;
    }

    @Override public int interpret(Context context) {
        return value;
    }

    @Override public String toString() {
        return Integer.toString(value);
    }
}
