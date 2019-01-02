package com.kr.caption.designmode.factory;

import java.util.ArrayList;
import java.util.List;

public abstract class Pizza {

    protected String name;
    protected String dough;
    protected String sauce;
    protected List topping = new ArrayList();


    public void prepare(){

        System.out.println(" preparing pizza :"+ name);
        System.out.println(" Tossing dough");
        System.out.println(" Adding sauce");
        System.out.println(" Adding toppings ");
        System.out.println(" preparing pizza :"+ name);

        for(Object o:topping){
            System.out.println(o);
        }

    }

    public void cut(){
        System.out.println(" Cutting ");
    }

    public void box(){
        System.out.println(" Boxing  ");
    }

    public String getName(){
        return name;
    }
}
