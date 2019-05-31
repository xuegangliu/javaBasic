package org.lxg.basic.patterns.interpreter;

/**
 * @author xuegangliu
 * @date 2017/3/16 0016.
 */
public class MinusAbstractExpression extends AbstractExpression {

    private AbstractExpression leftExpression;
    private AbstractExpression rightExpression;

    public MinusAbstractExpression(AbstractExpression leftExpression, AbstractExpression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override public int interpret(Context context) {
        return leftExpression.interpret(context) - rightExpression.interpret(context);
    }

    @Override public String toString() {
        return leftExpression.toString() + " - " + rightExpression.toString();
    }
}
