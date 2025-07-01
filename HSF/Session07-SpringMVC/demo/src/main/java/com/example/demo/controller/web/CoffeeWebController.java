package com.example.demo.controller.web;

import com.example.demo.entity.Coffee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
// 1 bean tự new từ đầu bởi Container, chuyên trả lời các http request đén từ url của trình duyệt của user
// có nhiều url khác nhau thì ứng với nhiều hàm và method khác nhau trong class này
// các hàm sẽ trả về html, trang web sẽ nhận được cá trang web
public class CoffeeWebController {

    @GetMapping("/") // user gõ localhost:6969/ nghĩa là nhảy đén hàm này
    public String home(Model model) {

        model.addAttribute("cup1", "Cafe Java đậm đà");
        model.addAttribute("cup2", new Coffee("JC", "Cafe Java mướt mượt hẹ hẹ hẹ hẹ", 29000));
        return "index";// trả về tên trang cho trình duyệt
    }
}
