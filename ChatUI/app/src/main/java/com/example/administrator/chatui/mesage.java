package com.example.administrator.chatui;

public class mesage {
    public static final int Type_Send = 1;
    public static final int Type_Received = 0;
    private String text ;
    private int msgType;

    public mesage(String text,int msgType){
        this.msgType = msgType;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public int getMsgType() {
        return msgType;
    }
}
