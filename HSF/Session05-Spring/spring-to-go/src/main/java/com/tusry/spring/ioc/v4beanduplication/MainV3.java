package com.tusry.spring.ioc.v4beanduplication;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainV3 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        HelloMessage mail = context.getBean("mail", HelloMessage.class);
        mail.sayHello("Spring hoc vui vl");
    }
}
