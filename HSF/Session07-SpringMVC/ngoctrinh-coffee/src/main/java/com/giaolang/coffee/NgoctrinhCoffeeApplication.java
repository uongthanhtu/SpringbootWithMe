package com.giaolang.coffee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//class này là class trung tâm, nơi chứa những khai báo về các loại bean có trong app này: bean là những object depedency đc IoC Container tự new, hay mình tự new và gửi cho Container giữ giúp.
//Dependency object là những class có @Component, @Service, @Repository, @Controller, @RestController
//@SpringBootApplication gộp sẵn 3 @ khác
//@Configuration; @ComponentScan, @EnableAutoConfiguration: khởi động Tomcat, JPA/Hibernate, MVC - điều khiển request/response
//@ComponentScan("")
public class NgoctrinhCoffeeApplication {

    public static void main(String[] args) {
        SpringApplication.run(NgoctrinhCoffeeApplication.class, args);
    }

}
