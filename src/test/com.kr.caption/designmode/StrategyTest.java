package com.kr.caption.designmode;

import com.kr.caption.designmode.strategy.FlyRocketPower;
import com.kr.caption.designmode.strategy.MallardDuck;
import com.kr.caption.designmode.strategy.ModelDuck;

public class StrategyTest {

    public static void main(String[] args) {
        MallardDuck mallardDuck = new MallardDuck();
        mallardDuck.performFly();
        mallardDuck.performQuack();

        ModelDuck modelDuck = new ModelDuck();
        modelDuck.setFlyBehavior(new FlyRocketPower());
        modelDuck.performFly();
    }
}
