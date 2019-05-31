package org.lxg.basic.patterns.adapter.s2;

/**
 * @author xuegangliu
 *  8/10/2018 5:36 PM
 *
 * @version: v1.0
 */
public interface AdvancedMediaPlayer {

    /**
     * playVlc
     * @param fileName
     */
    void playVlc(String fileName);

    /**
     * playMp4
     * @param fileName
     */
    void playMp4(String fileName);
}
