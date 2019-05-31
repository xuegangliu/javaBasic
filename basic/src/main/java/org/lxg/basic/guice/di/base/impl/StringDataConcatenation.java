package org.lxg.basic.guice.di.base.impl;

import org.lxg.basic.guice.di.base.DataProcessor;

/**
 * @author xuegangliu
 * @date 2017/3/16 0016.
 */
public class StringDataConcatenation implements DataProcessor {

    private String template = "%s%s";

    @Override
    public String process(final String first, final String second) {
        return  String.format(template, first, second);
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(final String template) {
        this.template = template;
    }
}
