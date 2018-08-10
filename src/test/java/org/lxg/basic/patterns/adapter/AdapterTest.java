package org.lxg.basic.patterns.adapter;

import org.junit.Test;

/**
 * @author: xuegangliu
 * @date: 8/10/2018 5:00 PM
 * @DES:
 * @version: v1.0
 */
public class AdapterTest {

    @Test
    public void clientTest1(){
        Chinese chinese = new Translator(new English());
        chinese.speakChinese("那你很棒棒哦！");
    }

    @Test
    public void clientTest2(){
        ClassTranslator translator = new ClassTranslator();
        translator.speakChinese("你也很好啊！");
    }

    @Test
    public void clientTest3(){
        BaseAdapter adapter = new ChineseAdapter(new English());
        adapter.speakChinese("好！");
    }
}
