package com.sere.message.resp;

import com.sere.message.BaseMessage;

/**
 * ClassName: MusicMessage
 * @Description: ������Ϣ
 */
public class MusicMessage extends BaseMessage {  
    // ����   
    private Music Music;  

    public Music getMusic() {  
        return Music;  
    }  

    public void setMusic(Music music) {  
        Music = music;  
    }  
}