package com.tusry.coffee.ngoctrinhcoffee3.controller;

import com.tusry.coffee.ngoctrinhcoffee3.entity.Account;
import com.tusry.coffee.ngoctrinhcoffee3.service.AuthenticationService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthenticationController {
    @Autowired
    AuthenticationService authenticationService;

    @GetMapping({"/", "/login"})
    public String login(Model model) {
        model.addAttribute("account", new Account());
        return "login";
    }

    @PostMapping({"/login"})
    public String doLogin(@Valid @ModelAttribute("account") Account accountLogin ,
                          BindingResult bindingResult, HttpSession httpSession) {
        if(bindingResult.hasErrors()) {
            return "login";
        }
        try{
            Account account = authenticationService.login(accountLogin.getUsername(), accountLogin.getPassword());
            httpSession.setAttribute("account", account);
            return "redirect:/products";
        }catch (Exception e) {
            bindingResult.reject("loginError", "Login failed");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession) {
        httpSession.invalidate();
        return "redirect:/login";
    }
}
