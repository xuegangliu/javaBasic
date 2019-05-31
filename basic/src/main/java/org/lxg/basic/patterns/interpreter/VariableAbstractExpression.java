package org.lxg.basic.patterns.interpreter;

/**
 * @author xuegangliu
 * @date 2017/3/16 0016.
 */
public class VariableAbstractExpression extends AbstractExpression {

    private String name;

    public VariableAbstractExpression(String name) {
        this.name = name;
    }

    @Override public int interpret(Context context) {
        return context.lookup(this);
    }

    @Override public String toString() {
        return name;
    }
}
