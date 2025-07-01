package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//bao: @Configuration
//      @ComponentScan() scan ngay những class trong .coffee folder/package
//      mà có chứa @Component, @Service, @Repository, @RestController, @Controller
//      new những đứa này, chích/ tiêm chúng vào class tương ứng
//      @EnableAutoConfiguration: tự new, tự cấu hình: JPA/Hibernate, Tomcat, MVC,...
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    //@Bean ở đây để ch động new riêng những dependency, new xong gửi chi IoC Container quản lí giúp

}
