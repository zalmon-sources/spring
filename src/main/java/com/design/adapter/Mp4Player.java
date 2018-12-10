package com.design.adapter;

/**
 * Created by peng.zhang
 * Description: 实现 AdvancedMediaPlayer ,播放mp4 的具体类
 * Time: 2018/12/10-17:07.
 */
public class Mp4Player implements AdvancedMediaPlayer{


    @Override
    public void playVlc(String fileName) {
        // 什么也不做
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: "+ fileName);
    }
}
