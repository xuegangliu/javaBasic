package org.lxg.basic.util;

import java.util.regex.Matcher;

/**
 * JbsUtils
 * <p>
 * This is description
 * </p>
 *
 * @author xuegangliu 2019/08/29
 * @since 1.8
 **/
public final class JbsUtils {

    /**
     * 格式化字符串中的{}
     * @param from 源字符串
     * @param arguments 格式化数据信息
     * @return
     */
    public static String format(String from, Object... arguments) {
        if (from != null) {
            String computed = from;
            if (arguments != null && arguments.length != 0) {
                for (Object argument : arguments) {
                    computed = computed.replaceFirst("\\{\\}", Matcher.quoteReplacement(argument.toString()));
                }
            }
            return computed;
        }
        return null;
    }
}
