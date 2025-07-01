package com.tusry.spring.ioc.v1scan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainV1 {
    public static void main(String[] args) {
        //báo hiệu cho máy bảo java lôi thư viện Spring và các thư viện con vào cuộc quản lí các object, tạo ra 1 object Trùm cuối tên là ApplicationContext
        //giống việc chơi với DB qua JPA th có trùm cuối EntityManagerFactory

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        //hậu trường: context là 1 vùng RAM GỌI LÀ IoC Container
        //chứa các object được new sẵn (thằng nào có @Component, @Service, @Repo)
        //Tìm những @ cần new có khai báo Trong AppConfig.class

        HelloMessage helloMessage =context.getBean(HelloMessage.class);
        //đã new rồi, giờ xài thôi
        //bean là 1 object được new tự động bởi Spring CONTEXT, CONTAINER
        // TA chỉ get ra dùng, lấy từ chỗ chứa - CONTAINER
        helloMessage.sayHello("HELLO SPRING WORLD!!");
    }
}
