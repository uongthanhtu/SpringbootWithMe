package com.tusry.spring.ioc.v2bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.tusry.spring.ioc.v2bean")
public class AppConfig {
    @Bean //object được new ở hàm này sẽ được đi vào Container
    //và object này mang tên là helloMessage
    // tên hàm phá quy tắc Verb + Object mà tên đặt như biến
    public HelloMessage tusryHello () {// ram: HelloMessage helloMessage = new HelloMessage();
        return new HelloMessage();
    } // chủ động new object bằng tay như truyền thống
    //nhưng sau đó đẩy các object này cho container quản lí
}

//Có những cách để tạo và dùng Object
//C1: Chủ động new, tự new - version no-IOC dầu giờ
//C2:new tự động qua @COMPONENTSCAN -V1
//ANNOTATION-CONFIGURATION

//C3: CHỦ ĐỘNG NEW, TỰ NEW, NHƯNG THẢY QUA CHO CONTAINER QUẢN LÍ
// JAVA-BASED CONFIG

//C4: NEW TỰ ĐỘNG LUÔN NHƯNG PHẢI CẤU HÌNH KHAI BÁO BEAN, CLASS CẦN TẠO OBJ QUA FILE xml RIÊNG- LEGACY - CÁCH CŨ
//XML PATH/BASED CONFIGURATION