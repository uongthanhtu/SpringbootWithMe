package com.tusry.spring.sb.config;
//MUỐN CLASS NÀY SẼ TỰ CHẠY KHI SPRINGBOOT BẮT ĐẦU RUN, BẤT ĐẦU TẠO CONTAINER, BẮT ĐẦU NEW CÁC BEAN
// TỰ CHẠY MẢNG: NÓ TẠO TABLE, CHÈN DATA, INSERT VÀO TABLE ĐỂ CÓ SĂN DATA NÓ
// ví dụ APP CHẠY -> ADMIN ACCOUNT TRONG TABLE
// DANH MỤC TỈNH THÀNH PHẢI CSO TRƯỚC , TA LÀM CODE FIRST

import com.tusry.spring.sb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired // lười làm constructor, dungf field injection
    private UserService userService;

    //hàm này sẽ đợc springboot tự gọi 1 lần khi new bean
    @Override
    public void run(String... args) throws Exception {
        //đúng chuẩn là gọi service và service gọi repo

        userService.createUser();

    }
}
