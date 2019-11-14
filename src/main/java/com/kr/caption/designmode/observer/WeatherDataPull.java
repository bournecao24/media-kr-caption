package com.kr.caption.designmode.observer;

import java.util.Observable;

/**
 * author:java技术情报局
 */
public class WeatherDataPull extends Observable {
    private float temp;
    private float  humidity;
    private float  pressure;
    //现在我们不需要管理注册和删除，也不需要记住观察者，父类已经帮我们做了
    public WeatherDataPull() {
    }

    public void measurementsChanged(){
        setChanged();      //在调用notifyObservers之前我们要先调用这个方法来指示状态已经改变
        notifyObservers();
    }

    public void setMeasurements(float temp, float humidity, float pressure){//获取观测数据
        this.temp=temp;
        this.humidity = humidity;
        this.pressure=pressure;
        measurementsChanged();
    }

    public float getTemp() {
        return temp;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}
