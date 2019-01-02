package com.kr.caption.designmode.factory.abstractfactory;

public class CheesePizza extends Pizza{

    PizzaIngredientFactory pizzaIngredidentFactory;

    public CheesePizza(PizzaIngredientFactory pizzaIngredidentFactory) {
        this.pizzaIngredidentFactory = pizzaIngredidentFactory;
    }

    @Override
    void prepare() {
        System.out.println(" Preparing pizza " + name);

        dough = pizzaIngredidentFactory.createDough();
        sauce = pizzaIngredidentFactory.createSauce();
        clams = pizzaIngredidentFactory.createClams();


    }
}
