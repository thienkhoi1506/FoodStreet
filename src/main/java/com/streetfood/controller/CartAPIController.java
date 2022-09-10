package com.streetfood.controller;

import com.streetfood.Utils.Utils;
import com.streetfood.pojo.Cart;
import com.streetfood.service.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
public class    CartAPIController  {
    @Autowired
    private OrderService orderService;
    @PostMapping("/api/cart")
    public int addToCart(@RequestBody Cart params, HttpSession session){
        Map<Integer,Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");
        if(cart ==null)
            cart = new HashMap<>();
        int productId=params.getProductId();
        if(cart.containsKey(productId)==true){
            Cart c= cart.get(productId);
            c.setCount(c.getCount()+1);
        }
        else{
            cart.put(productId,params);
        }
        session.setAttribute("cart",cart);
        return Utils.countCart(cart);
    }
    @PutMapping("/api/cart")
    public ResponseEntity<Map<String,String>> updateCart(@RequestBody Cart params, HttpSession session){
        Map<Integer,Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");
        if(cart ==null)
            cart = new HashMap<>();
        int productId=params.getProductId();
        if(cart.containsKey(productId)==true){
            Cart c= cart.get(productId);
            c.setCount(params.getCount());
        }
        session.setAttribute("cart",cart);
        return new ResponseEntity<>(Utils.cartStats(cart),HttpStatus.OK);
    }
    @DeleteMapping("/api/cart/{productId}")
    public ResponseEntity<Map<String,String>> deleteCart(@PathVariable(value = "productId") int productId, HttpSession session){
        Map<Integer,Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");
        if(cart!=null && cart.containsKey(productId)){
            cart.remove(productId);
            session.setAttribute("cart",cart);
        }
        return new ResponseEntity<>(Utils.cartStats(cart),HttpStatus.OK);    //Muốn xuất utils phải ép kiểu về reponse
    }
    @PostMapping("/api/pay")
    public HttpStatus pay(HttpSession sesion){
        if(this.orderService.addBill((Map<Integer, Cart>) sesion.getAttribute("cart"))== true){
            sesion.removeAttribute("cart");
            return HttpStatus.OK;
        }
        else
            return HttpStatus.BAD_REQUEST;
    }
}
