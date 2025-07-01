package com.tusry.di.v3finalfantasy;

public class SmsSender implements NotiService{

    @Override
    public void sendNoti() {
        System.out.println("Sending noti (-----VIETTEL-----)");
    }
}
