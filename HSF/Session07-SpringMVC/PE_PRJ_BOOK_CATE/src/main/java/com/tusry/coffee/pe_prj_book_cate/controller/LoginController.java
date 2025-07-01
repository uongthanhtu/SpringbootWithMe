package com.tusry.coffee.pe_prj_book_cate.controller;

import com.tusry.coffee.pe_prj_book_cate.entity.User;
import com.tusry.coffee.pe_prj_book_cate.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @GetMapping({"/", "/login"})
    public String login() {
        return "login";
    }

    @PostMapping("/doLogin")
    public String doLogin(@RequestParam("user") String username, @RequestParam("pass") String password, RedirectAttributes redirectAttributes, Model model, HttpSession session) {
        User user = userService.login(username, password);
        if(user == null) {
            return "login";
        }
        session.setAttribute("user", user);
        return "redirect:/books";
    }

}
