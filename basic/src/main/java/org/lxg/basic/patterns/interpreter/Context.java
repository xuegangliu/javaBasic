package org.lxg.basic.patterns.interpreter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xuegangliu
 */
public class Context {

    private Map<AbstractExpression, Integer> map = new HashMap<>();

    public void addExpression(AbstractExpression expression, int value) {
        map.put(expression, value);
    }

    public int lookup(AbstractExpression expression) {
        return map.get(expression);
    }

}
