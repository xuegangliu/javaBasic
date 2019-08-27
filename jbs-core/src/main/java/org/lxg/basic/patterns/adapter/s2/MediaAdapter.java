package org.lxg.basic.patterns.adapter.s2;

/**
 * @author xuegangliu
 *  8/10/2018 5:37 PM
 *
 * @version: v1.0
 */
public class MediaAdapter implements MediaPlayer {

    private final String VLC="vlc";
    private final String MP4="mp4";
    AdvancedMediaPlayer advancedMusicPlayer;

    public MediaAdapter(String audioType){
        if(VLC.equals(audioType)){
            advancedMusicPlayer = new VlcPlayer();
        } else if (MP4.equals(audioType)){
            advancedMusicPlayer = new Mp4Player();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if(VLC.equals(audioType)){
            advancedMusicPlayer.playVlc(fileName);
        }else if(MP4.equals(audioType)){
            advancedMusicPlayer.playMp4(fileName);
        }
    }
}
