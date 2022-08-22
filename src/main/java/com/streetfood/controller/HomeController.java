package com.streetfood.controller;

import com.streetfood.service.interfaces.CategoryService;
import com.streetfood.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@ControllerAdvice
@PropertySource("classpath:page.properties")
public class HomeController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private Environment env;

    @ModelAttribute
    public void commonAttr(Model model){
        model.addAttribute("categories", this.categoryService.getCategories());
    }
//    @RequestMapping("/")
//    public ModelAndView index(@RequestParam Map<String, String> params, Model model) {
//        ModelAndView  modelAndView = new ModelAndView("home");
//        return modelAndView;
//    }
    @RequestMapping("/")
    public String index(Model model,
                        @RequestParam Map<String, String> params){
        int page = Integer.parseInt(params.getOrDefault("page","1"));
        model.addAttribute("products", this.productService.getProduct(params, page));
        model.addAttribute("productCounter", this.productService.countProduct());
        model.addAttribute("pageSize", Integer.parseInt(env.getProperty("page.size")));

        return "home";
    }
}
