package org.lxg.basic.patterns.adapter.s2;

/**
 * @author: xuegangliu
 * @date: 8/10/2018 5:48 PM
 * @DES:
 * @version: v1.0
 */
public class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("Mp4Player playVlc....");
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Mp4Player playMp4: Playing mp4 file. Name: "+ fileName);
    }
}
