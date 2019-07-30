package com.kr.caption.spring;

import org.springframework.beans.factory.annotation.Autowired;

public class Train implements Transport{

    private Water water;

    public Train(Water water) {
        this.water = water;
    }

    public void catchGoods(){
        water.waterSomthing();
    }

    public Water getWater() {
        return water;
    }

    /**
     * 满足方法参数上所声明的依赖， required = false 是避免需要的bean不存在报异常
     * @param water
     */
    @Autowired(required = false)
    public void setWater(Water water) {
        this.water = water;
    }
}
