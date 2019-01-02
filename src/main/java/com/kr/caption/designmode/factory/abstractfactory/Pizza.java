package com.kr.caption.designmode.factory.abstractfactory;

import com.kr.caption.designmode.factory.Clams;
import com.kr.caption.designmode.factory.Dough;
import com.kr.caption.designmode.factory.Sauce;

public abstract class Pizza {


    protected String name;
    protected Dough dough;
    protected Sauce sauce;
    protected Clams clams;

    abstract void prepare();

    public void cut(){
        System.out.println(" Cutting ");
    }

    public void box(){
        System.out.println(" Boxing  ");
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
