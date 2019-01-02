package com.kr.caption.designmode;

import com.kr.caption.designmode.factory.Pizza;
import com.kr.caption.designmode.factory.factorymethod.NYPizzaStore;

public class FactoryMethodTest {

    public static void main(String[] args) {
        NYPizzaStore nyPizzaStore = new NYPizzaStore();
        Pizza cheese = nyPizzaStore.createPizza("cheese");
    }
}
