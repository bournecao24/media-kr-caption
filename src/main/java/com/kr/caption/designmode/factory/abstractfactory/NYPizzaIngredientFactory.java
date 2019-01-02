package com.kr.caption.designmode.factory.abstractfactory;

import com.kr.caption.designmode.factory.Clams;
import com.kr.caption.designmode.factory.Dough;
import com.kr.caption.designmode.factory.Sauce;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {

    @Override
    public Dough createDough() {
        return new Dough();
    }

    @Override
    public Sauce createSauce() {
        return new Sauce();
    }

    @Override
    public Clams createClams() {
        return new Clams();
    }
}
