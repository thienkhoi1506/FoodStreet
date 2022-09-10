package com.streetfood.controller;

import com.streetfood.Utils.Util;
import com.streetfood.pojo.Cart;
import com.streetfood.service.interfaces.CategoryService;
import com.streetfood.service.interfaces.ProductService;
import com.streetfood.service.interfaces.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
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
    private RestaurantService restaurantService;

    @Autowired
    private Environment env;

    @ModelAttribute
    public void commonAttr(Model model, HttpSession session){
        model.addAttribute("categories", this.categoryService.getCategories());
        model.addAttribute("cartCouter", Util.countCart((Map<Integer, Cart>) session.getAttribute("cart")));
        model.addAttribute("currentUser", session.getAttribute("currentUser"));
    }

    @RequestMapping("/")
    public String index(Model model,
                        @RequestParam Map<String, String> params){
        int page = Integer.parseInt(params.getOrDefault("page","1"));
//        model.addAttribute("restaurant", this.restaurantService.getRestaurant(params, page));
//        model.addAttribute("restaurantCounter", this.restaurantService.countRestaurant());
        model.addAttribute("products", this.productService.getProduct(params, page));
        model.addAttribute("productCounter", this.productService.countProduct());
        model.addAttribute("pageSize", Integer.parseInt(env.getProperty("page.size")));

        return "home";
    }
}
