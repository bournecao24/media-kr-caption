package com.kr.caption.spring;

public class Train implements Transport{

    private Water water;

    public Train(Water water) {
        this.water = water;
    }

    public void catchGoods(){
        water.waterSomthing();
    }
}
