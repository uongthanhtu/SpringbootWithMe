package com.tusry.spring.ioc.v3beanduplication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
//không scan do mình chủ động tạo bean-obj
public class AppConfig {
    @Bean
    @Primary
    public HelloMessage smsMessage() {
        return new HelloMessage("SMS");
    }

    @Bean
    public HelloMessage mailMessage() {
        return new HelloMessage("Mail");
    }


}
