package com.tusry.spring.ioc.v1scan;

import org.springframework.stereotype.Component;

@Component// hoặc @Service, @Repository
public class HelloMessage {
    public void sayHello(String msg) {
        System.out.println("The message is below come from HelloMessage object IoC Contrainer: " + msg);
    }
}
