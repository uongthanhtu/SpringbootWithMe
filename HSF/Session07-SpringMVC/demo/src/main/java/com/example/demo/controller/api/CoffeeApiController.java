package com.example.demo.controller.api;

import com.example.demo.entity.Coffee;
import org.springframework.web.bind.annotation.*;

@RestController
// map và phuc vụ các url chỉ lấy các data thô, trả về JSON
// Hoặc nận JSON từ trang web gửi lên
// thường thấy thì url api sẽ tách hẳn so với url của web
//https:..../api/v1
@RequestMapping("/api/v1")
public class CoffeeApiController {

    @GetMapping("/cup")
    public Coffee getACup(){
        return new Coffee("JCNT","Cafe JAVA topping lung linh NT", 29999);// lấy từ DB lên qua Service/Repository/JPA-Hibernate/JDBC/TABLE
    }// gọi JACKSON convert từ object thành JSON bên trình duyệt
    //data thôi - WEB API: gọi hàm qua URL trả về JSON


    //em muốn gửi data lên server, JSON gửi lên dùm em, xử lí giúp em
    @PostMapping("/add")
    public Coffee addACup(@RequestBody Coffee coffee){
        //sửa object đã nhận, xong trả về để mng bết mình đã nhận từ client và mình chỉnh lại info
        String oldName = coffee.getName();
        String newName = oldName + " | FPT NEVER GIVE UP | ";
        coffee.setName(newName);
        return coffee;
    }


}
