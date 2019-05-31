package org.lxg.basic.patterns.adapter.s1;

/**
 * Created by Administrator on 2017/1/20 0020.
 */

interface ChineseTarget  {

    /**
     * 普通话
     * @param string
     */
    void speakChinese(String string);

    /**
     * 广东话
     * @param string
     */
    void speakCantonese(String string);

    /**
     * 上海话
     * @param string
     */
    void speakShanghainese(String string);
}
