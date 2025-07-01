package com.tusry.spring.ioc.v2bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainV2 {
    public static void main(String[] args) {
        //GỌI TRÙM CUỐI ĐỂ QUẢN LÍ OBJECT
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        HelloMessage helloMessage = (HelloMessage) context.getBean("tusryHello");

        //@Bean bên kia, lấy cái tên hàm ra. Ép kiểu
        helloMessage.sayHello("HELLO SPRING WORLD MANUAL CREATED BEAN!!");
        HelloMessage helloMessage2 = context.getBean(HelloMessage.class);

        helloMessage2.sayHello("HELLO2 SPRING WORLD MANUAL CREATED BEAN!!");
    }
}
