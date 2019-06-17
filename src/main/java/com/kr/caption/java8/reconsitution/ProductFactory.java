package com.kr.caption.java8.reconsitution;

import com.kr.caption.java8.movingparam.Apple;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;


/**
 * 工厂模式
 */
public class ProductFactory {

    public static Apple createProduct(String name) {
        switch (name) {
            case "loan":
                return new Apple();
            case "stock":
                return new Apple();
            case "bond":
                return new Apple();
            default:
                throw new RuntimeException("No such product " + name);
        }
    }


    final static Map<String, Supplier<Apple>> map = new HashMap<>();

    static {
        map.put("loan", Apple::new);
        map.put("stock", Apple::new);
        map.put("bond", Apple::new);
    }
}
