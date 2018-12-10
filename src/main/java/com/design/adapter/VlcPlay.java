package com.design.adapter;

/**
 * Created by peng.zhang
 * Description: 实现 AdvancedMediaPlayer ,播放vlc 的具体类
 * Time: 2018/12/10-17:06.
 */
public class VlcPlay implements AdvancedMediaPlayer{


    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: "+ fileName);
    }

    @Override
    public void playMp4(String fileName) {
        // 什么也不做
    }
}
