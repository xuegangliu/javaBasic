package org.lxg.basic.patterns.adapter.s2;

import org.junit.Test;

/**
 * @author xuegangliu
 *  8/10/2018 5:39 PM
 *
 * @version: v1.0
 */
public class AdapterS2Test {

    @Test
    public void test(){
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3", "beyond the horizon.mp3");
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("vlc", "far far away.vlc");
        audioPlayer.play("avi", "mind me.avi");
    }
}
