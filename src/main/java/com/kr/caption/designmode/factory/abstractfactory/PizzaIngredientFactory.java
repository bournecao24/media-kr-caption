package com.kr.caption.designmode.factory.abstractfactory;

import com.kr.caption.designmode.factory.Clams;
import com.kr.caption.designmode.factory.Dough;
import com.kr.caption.designmode.factory.Sauce;

/**
 * 引入抽象工厂，原料工厂
 *
 * 提供一个接口，用于创建相关或依赖对象的家族，而不需要明确指出具体类
 *
 * 抽象工厂的方法经常以工厂方法的模式来实现
 */
public interface PizzaIngredientFactory {

    public Dough createDough();
    public Sauce createSauce();
    public Clams createClams();


}
