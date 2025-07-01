package com.tusry.coffee.springcoffeev3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // là 1 bean nhưng chuyên được new tự động
//các hàm này dùng để map với 1 url trn trình duyệt
@RequestMapping("/api/coffees") // nếu user gõ localhost://api/coffees sẽ đến class này phục vụ

public class CoffeeApiController {

    @GetMapping("/acup")
    public Coffee getACup (){
        return new Coffee("JC", "Java Cofffee nồng nàn đầm vị" , 5700000);
    }

    @GetMapping
    public String getMessage (){
        return "Uống cafe mới pass môn Java... Uống trà sữa sữa cooked";
    }




}
