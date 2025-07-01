package com.tusry.spring.ioc.v4beanduplication;

public class HelloMessage {

    private String mediumType;

    public HelloMessage(String mediumType){
        this.mediumType = mediumType;
    }

    public void sayHello(String msg) {
        System.out.println("Send from " + mediumType);
        System.out.println("V4: " + msg);
    }
}
