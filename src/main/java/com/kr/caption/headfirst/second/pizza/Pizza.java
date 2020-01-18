package com.kr.caption.headfirst.second.pizza;

// Builder pattern for class hierarchies

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

import static com.kr.caption.headfirst.second.pizza.NyPizza.Size.SMALL;
import static com.kr.caption.headfirst.second.pizza.Pizza.Topping.*;

public abstract class Pizza {
    public enum Topping {HAM, MUSHROOM, ONION, PEPPER, SAUSAGE}

    final Set<Topping> toppings;

    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract Pizza build();

        // Subclasses must override this method to return "this"
        protected abstract T self();
    }

    //一个带有递归类型参数( recursive type parameter)(详见第 30 条)的泛型类型。
    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone(); // See Item 50
    }

    public static void main(String[] args) {
        NyPizza pizza = new NyPizza.Builder(SMALL)
                .addTopping(SAUSAGE).addTopping(ONION).build();
        Calzone calzone = new Calzone.Builder()
                .addTopping(HAM).sauceInside().build();
    }
}
