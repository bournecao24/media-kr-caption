package com.kr.caption.designmode.factory.abstractfactory;



public class NYPizzaStore extends PizzaStore{

    @Override
    public Pizza createPizza(String type) {
        Pizza pizza=null;
        PizzaIngredientFactory pizzaIngredientFactory = new NYPizzaIngredientFactory();

        if( type.equals("cheese")){

            pizza.setName(" NYCheesePizza");
            pizza = new CheesePizza(pizzaIngredientFactory);
        }

        pizza.prepare();
        pizza.cut();
        pizza.box();
        return pizza;
    }


}
