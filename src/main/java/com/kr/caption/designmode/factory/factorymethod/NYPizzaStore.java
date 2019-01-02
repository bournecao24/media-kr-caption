package com.kr.caption.designmode.factory.factorymethod;

import com.kr.caption.designmode.factory.CheesePizza;
import com.kr.caption.designmode.factory.ClamPizza;
import com.kr.caption.designmode.factory.Pizza;

/**
 * 工程方法（createPizza） 用来处理对象的创建，并将这样的行为封装到子类中，解耦
 */
public class NYPizzaStore extends PizzaStore {

    @Override
    public Pizza createPizza(String type) {
        Pizza pizza = null;

        if(type.equals("cheese")){
            pizza = new CheesePizza();
        }else if(type.equals("clam")){
            pizza = new ClamPizza();
        }
        return pizza;
    }
}
