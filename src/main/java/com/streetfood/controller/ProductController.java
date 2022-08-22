package com.streetfood.controller;

import com.cloudinary.Cloudinary;
import com.streetfood.pojo.Product;
import com.streetfood.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private ProductService productService;


    @GetMapping("/products")
    public String GetAll(Model model) {
        model.addAttribute("products", new Product());
        return "products";
    }

    @PostMapping("/products")
    public String createProduct(Model model, @ModelAttribute(value = "products") @Valid Product product,
                              BindingResult result){
        if (!result.hasErrors()){
            if (this.productService.addProduct(product) == true)
                return "redirect:/products";
            else
                model.addAttribute("errMsg", "Something wrong!!");
        }
        return "products";
    }

}
