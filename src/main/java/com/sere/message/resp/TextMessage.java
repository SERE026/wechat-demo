package com.sere.message.resp;

import com.sere.message.BaseMessage;

/**
 * ClassName: TextMessage
 * @Description: �ı���Ϣ��Ϣ��
 */
public class TextMessage extends BaseMessage {  
    // �ظ�����Ϣ����   
    private String Content;  

    public String getContent() {  
        return Content;  
    }  

    public void setContent(String content) {  
        Content = content;  
    }  
}