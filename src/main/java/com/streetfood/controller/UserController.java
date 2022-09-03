package com.streetfood.controller;

import com.streetfood.pojo.User;
import com.streetfood.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private UserService userDetailsService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String registerView(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register/create")
    public String register(Model model, @ModelAttribute(value = "user") @Valid User user){
        if (user.getPassword().isEmpty() || !user.getPassword().equals(user.getConfirmPassword())){
            model.addAttribute("errMsg", "Mật khẩu không khớp");
        } else {
            if (this
                    .userDetailsService
                    .addUser(user) == true) {
                return "redirect:/login";
            } else {
                model.addAttribute("errMsg", "Có lỗi xảy ra, vui lòng thử lại !");
            }
        }
        return "register";
    }
}
