package com.kr.caption.designmode.template;


/**
 * 和 Tea那个类有好多的公用代码
 * 第一版的设计：抽象出一个基类，基类里面有两者公用的方法 boilWater 和 pourInCup 放在基类里
 *            prepareRecipe 在每个类中都不一样，定义为抽象方法
 * 思考：另外的两个方法没有被抽取出来，但他们是一样的，只是应用在不同的饮料上
 * 第二版的设计：抽象 prepareRecipe 方法
 */
public class Coffee {

    public void prepareRecipe() {
        boilWater();
        brewCoffeeGrinds();
        pourInCup();
        addSugarAndMilk();
    }

    public void boilWater() {
        System.out.println("Boiling water");

    }

    public void brewCoffeeGrinds() {
        System.out.println(" Drop coffee through filter ");

    }

    public void pourInCup() {
        System.out.println(" Pouring into cup ");
    }

    public void addSugarAndMilk() {
        System.out.println(" Adding sugar and milk ");
    }
}
