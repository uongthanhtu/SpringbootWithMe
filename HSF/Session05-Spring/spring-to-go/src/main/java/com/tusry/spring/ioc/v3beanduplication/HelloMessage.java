package com.tusry.spring.ioc.v3beanduplication;

public class HelloMessage {

    private String mediumType;

    public HelloMessage(String mediumType){
        this.mediumType = mediumType;
    }

    public void sayHello(String msg) {
        System.out.println("Send from " + mediumType);
        System.out.println("V3: " + msg);
    }
}
