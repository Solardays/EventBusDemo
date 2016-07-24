package com.jc.eventbusdemo.entities;

/**
 * Created by solar on 2016/7/23.
 */
public class MessageEvent {

    private String mMsg;

    public MessageEvent(String mMsg) {
        this.mMsg = mMsg;
    }

    public String getmMsg() {
        return mMsg;
    }

    public void setmMsg(String mMsg) {
        this.mMsg = mMsg;
    }
}
