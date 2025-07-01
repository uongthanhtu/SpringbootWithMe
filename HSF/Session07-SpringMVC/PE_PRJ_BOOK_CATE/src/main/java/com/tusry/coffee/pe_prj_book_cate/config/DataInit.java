package com.tusry.coffee.pe_prj_book_cate.config;

import com.tusry.coffee.pe_prj_book_cate.entity.User;
import com.tusry.coffee.pe_prj_book_cate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements CommandLineRunner {
    @Autowired
    UserService userService;

    @Override
    public void run(String... args) throws Exception {
        userService.createUser(new User("admin", "admin", 1));
        userService.createUser(new User("user", "user", 2));
    }



}
