package org.lxg.basic.patterns.adapter.s1;

import org.junit.Test;
import org.lxg.basic.patterns.adapter.s1.*;

/**
 * @author xuegangliu
 *  8/10/2018 5:00 PM
 *
 * @version: v1.0
 */
public class AdapterS1Test {

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
