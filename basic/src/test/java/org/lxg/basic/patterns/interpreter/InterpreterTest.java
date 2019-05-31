package org.lxg.basic.patterns.interpreter;

import org.junit.Test;

/**
 * @author: xuegangliu
 * @date: 8/30/2018 3:25 PM
 * @DES:
 * @version: v1.0
 */
public class InterpreterTest {

    @Test
    public void interpreterTest(){
        Context context = new Context();

        VariableAbstractExpression a = new VariableAbstractExpression("a");
        VariableAbstractExpression b = new VariableAbstractExpression("b");
        ConstantAbstractExpression c = new ConstantAbstractExpression(6);

        context.addExpression(a, 2);
        context.addExpression(b, 3);

        AbstractExpression expression = new PlusAbstractExpression(new PlusAbstractExpression(a,b),new MinusAbstractExpression(a,c));
        System.out.println(expression.toString() + " = " + expression.interpret(context));
    }
}
