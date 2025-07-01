package com.tusry.di.v3finalfantasy;

public class EmailSender implements NotiService {

    @Override
    public void sendNoti() {
        System.out.println("Sending email (!!!GMAIL!!!)");
    }
}
