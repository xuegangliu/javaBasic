package org.lxg.basic.patterns.adapter.s2;

/**
 * @author: xuegangliu
 * @date: 8/10/2018 5:38 PM
 * @DES:
 * @version: v1.0
 */
public class AudioPlayer implements MediaPlayer {

    MediaAdapter mediaAdapter;
    private final static String MP3="mp3";
    private final static String VLC="vlc";
    private final static String MP4="mp4";

    @Override
    public void play(String audioType, String fileName) {
        //播放 mp3 音乐文件的内置支持
        if(MP3.equals(audioType)){
            System.out.println("AudioPlayer play: Playing mp3 file. Name: "+ fileName);
        }
        //mediaAdapter 提供了播放其他文件格式的支持
        else if(VLC.equals(audioType)
                || MP4.equals(audioType)){
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        }
        else{
            System.out.println("Invalid media. "+
                    audioType + " format not supported");
        }
    }
}
