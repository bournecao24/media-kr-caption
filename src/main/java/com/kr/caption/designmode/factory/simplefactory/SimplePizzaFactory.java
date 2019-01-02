package com.kr.caption.designmode.factory.simplefactory;

import com.kr.caption.designmode.factory.CheesePizza;
import com.kr.caption.designmode.factory.ClamPizza;
import com.kr.caption.designmode.factory.Pizza;


/**
 * 简单工厂
 * 实现一个接口并不一定是写一个类，用implement 关键字实现某个java接口，泛指实现某个超类型
 */
public class SimplePizzaFactory {

    public Pizza createPizza(String type){

        Pizza pizza = null;

        if(type.equals("cheese")){
            pizza = new CheesePizza();
        }else if(type.equals("clam")){
            pizza = new ClamPizza();
        }
        return pizza;
    }
}
