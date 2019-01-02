package com.kr.caption.designmode.factory.factorymethod;

import com.kr.caption.designmode.factory.Pizza;

public class NYStyleCheesePizza extends Pizza {

    public NYStyleCheesePizza() {
        name = "NY Style Sauce and cheese Pizza";
        dough = "Dough ";
        sauce = " sauce";

        topping.add(" Grated Cheese");

    }
}
