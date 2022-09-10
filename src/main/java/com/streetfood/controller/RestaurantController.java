package com.streetfood.controller;

import com.streetfood.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@ControllerAdvice
@PropertySource("classpath:page.properties")
public class RestaurantController {
    @Autowired
    private ProductService productService;

    @GetMapping("/restaurant")
    public String restaurant(@RequestParam Map<String, String> params, Model model){
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        model.addAttribute("products", this.productService.getProduct(params, page));
        return "restaurant";
    }
}
