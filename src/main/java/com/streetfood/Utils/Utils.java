package com.streetfood.Utils;

import com.streetfood.pojo.Cart;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Utils {

    public static int countCart(Map<Integer, Cart> cart){
        int c=0;
        if(cart != null)
            for (Cart ca: cart.values())
                c += ca.getCount();
        return c;
    }
    public static Map<String,String> cartStats(Map<Integer, Cart> cart){
        BigDecimal s  = BigDecimal.ZERO;
        BigDecimal countBigDecimal  = BigDecimal.ZERO;
        int c=0;
        if(cart != null)
            for (Cart ca: cart.values()) {
                c += ca.getCount();
                countBigDecimal = BigDecimal.valueOf(ca.getCount());
                s= s.add(countBigDecimal.multiply(ca.getPrice()));
            }
        Map<String,String> kq= new HashMap<>();
        kq.put("counter",String.valueOf(c));
        kq.put("amount",String.valueOf(s));
        return kq;
    }


}
