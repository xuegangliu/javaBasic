package org.lxg.basic.patterns.adapter.s2;

/**
 * @author xuegangliu
 *  8/10/2018 5:36 PM
 *
 * @version: v1.0
 */
public class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("VlcPlayer playVlc: Playing mp4 file. Name: "+ fileName);
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("VlcPlayer playMp4...");
    }
}
