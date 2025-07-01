package com.tusry.spring.ioc.v4beanduplication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
//không scan do mình chủ động tạo bean-obj
public class AppConfig {
    @Bean("sms")
    public HelloMessage smsMessage() {
        return new HelloMessage("SMS");
    }

    @Bean("mail")
    public HelloMessage mailMessage() {
        return new HelloMessage("Mail");
    }


}
