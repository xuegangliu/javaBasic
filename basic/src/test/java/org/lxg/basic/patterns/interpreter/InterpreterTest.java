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

        VariableExpression a = new VariableExpression("a");
        VariableExpression b = new VariableExpression("b");
        ConstantExpression c = new ConstantExpression(6);

        context.addExpression(a, 2);
        context.addExpression(b, 3);

        Expression expression = new PlusExpression(new PlusExpression(a,b),new MinusExpression(a,c));
        System.out.println(expression.toString() + " = " + expression.interpret(context));
    }
}
