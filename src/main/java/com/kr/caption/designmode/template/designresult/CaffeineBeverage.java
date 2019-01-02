package com.kr.caption.designmode.template.designresult;


/**
 * 定义：在一个方法定义了一个算法的骨架，而将一些步骤延迟到子类中，模板方法可以使子类在不改变算法结构的情况下重新定义算法中的某些步骤
 * 思考：创建一个算法的模板，就是一个方法，这个方法将算法定义成一组步骤，其中的任何步骤都可以使抽象的，由子类去负责实现。
 *      这可以保证算法的结构可以保持不变，同时由子类提供部分实现
 *
 *
 * 高层组件调用底层组件。好莱坞原则
 */
public abstract class CaffeineBeverage {


    /**
     * 模板方法 ：定义了一个算法的步骤，并允许子类为一个或多个步骤提供实现
     */
    void prepareRecipe(){

        boilWater();
        brew();
        addCondiments();
        pourInCup();

    }

    public abstract void brew();

    public abstract void addCondiments();



    public void boilWater() {
        System.out.println("Boiling water");

    }


    public void pourInCup() {
        System.out.println(" Pouring into cup ");
    }

    /**
     * 钩子；条件控制；影响抽象类中的算法流程
     * 父类中的抽象方法的多少要折中，太多：子类就要实现很多；  太少：比较没有弹性
     * 算法中的某些步骤是可选的，可以用钩子，而不是都搞成抽象方法，这样就可以让子类抽象类的子类的负荷减轻
     * @return
     */
    boolean customerWantsCondiments(){
        return true;
    }
}
