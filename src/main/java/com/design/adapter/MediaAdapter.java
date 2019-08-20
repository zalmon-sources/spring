package com.design.adapter;

/**
 * Created by peng.zhang
 * Description: 适配器类,包含了AdvancedMediaPlayer 类,可以使用AdvancedMediaPlayer 中包含的方法
 *              适配器模式（Adapter Pattern）是作为两个不兼容的接口之间的桥梁。这种类型的设计模式属于结构型模式，
 *              它结合了两个独立接口的功能。
 *              这种模式涉及到一个单一的类，该类负责加入独立的或不兼容的接口功能。
 *              举个真实的例子，读卡器是作为内存卡和笔记本之间的适配器。您将内存卡插入读卡器，
 *              再将读卡器插入笔记本，这样就可以通过笔记本来读取内存卡。
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
