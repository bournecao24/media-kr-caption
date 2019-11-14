package com.kr.caption.designmode.observer;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionDisplayPull implements Observer,
        DisplayElement {     //实现Observer接口
    Observable observable;
    private float temp;
    private float humidity;

    public CurrentConditionDisplayPull(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable obs, Object arg) {
        if(obs instanceof WeatherDataPull){     //在这里我们要先确定下对象是否是WeatherDataPull类型的
            WeatherDataPull dataPull = (WeatherDataPull) obs;
            this.humidity = dataPull.getHumidity();
            this.temp = dataPull.getTemp();
            display();
        }
    }

    @Override
    public void display() {
        System.out.println("Current conditions: " + temp + "degree and " + humidity + "% humidity");
    }
}
