package com.tusry.spring.sb;

import com.tusry.spring.sb.entity.ExcepGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
// bao gồm @Configuration
// bao gồm @ComponentScan
// Class này là nơi khai báo các bean - các dependency sẽ đc new, những class có @Component, @Service, @Repo, chính là AppConfig
// Các dependency có thể new theo 2 cách: tự động hoàn toàn và chủ động new với @Bean

// tự động cấu hình Web, Tomcat, CSDL,...
public class SprintToGoApplication {

    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(SprintToGoApplication.class, args);

        //phải viết code gọi bean sau lệnh trên
        ExcepGenerator excepGenerator = (ExcepGenerator) ctx.getBean("excepGenerator");
        excepGenerator.generateFile("Huhuhu");
    }

    // đặt các @Bean chủ động
    @Bean
    public ExcepGenerator excepGenerator() {
        return new ExcepGenerator();
    }


}
