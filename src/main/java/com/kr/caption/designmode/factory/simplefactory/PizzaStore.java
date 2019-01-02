package com.kr.caption.designmode.factory.simplefactory;

import com.kr.caption.designmode.factory.Pizza;

public class PizzaStore {

    public SimplePizzaFactory simplePizzaFactory;

    public PizzaStore(SimplePizzaFactory simplePizzaFactory) {
        this.simplePizzaFactory = simplePizzaFactory;
    }

    public Pizza orderPizza(String type){

        Pizza pizza = simplePizzaFactory.createPizza(type);

        pizza.prepare();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}
