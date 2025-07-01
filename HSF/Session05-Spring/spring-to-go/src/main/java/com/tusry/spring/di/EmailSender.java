package com.tusry.spring.di;

import org.springframework.stereotype.Component;

@Component
public class EmailSender {
    // Rất giỏi trong việc gửi mail
    public void sendEmail(){
        // todo: logic code gửi mail
        System.out.println("Sending email:...");
    }
}
