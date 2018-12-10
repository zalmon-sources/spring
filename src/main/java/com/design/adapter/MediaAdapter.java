package com.design.adapter;

/**
 * Created by peng.zhang
 * Description: 适配器类,包含了AdvancedMediaPlayer 类,可以使用AdvancedMediaPlayer 中包含的方法
 * Time: 2018/12/10-17:17.
 */
public class MediaAdapter implements MediaPlayer{

    AdvancedMediaPlayer mediaPlayer;

    public MediaAdapter(String audioType){
        if (audioType.equalsIgnoreCase("vlc")) {
            mediaPlayer = new VlcPlay();
        } else if (audioType.equalsIgnoreCase("mp4")) {
            mediaPlayer = new Mp4Player();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("vlc")) {
            mediaPlayer.playVlc(fileName);
        } else if (audioType.equalsIgnoreCase("mp4")) {
            mediaPlayer.playMp4(fileName);
        }
    }


}
