package com.kr.caption.designmode.observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {

    private List<Observer> observers;   //记录观察者
    private float temp;
    private float  humidity;
    private float  pressure;

    public WeatherData() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) { //注册观察者，直接放到集合中
        observers.add(observer);

    }

    @Override
    public void removeObserver(Observer observer) { //取消注册
        if(observers.indexOf(observer) >0){
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObserver() {   //因为所有的观察者都实现了update方法，所以通知所有的观察者
        if(observers != null && observers.size() >0){
            for(Observer observer:observers){
                observer.update(temp, humidity, pressure);
            }
        }
    }


    public void measurementsChanged(){
        notifyObserver();
    }

    public void setMeasurements(float temp, float humidity, float pressure){//获取观测数据
        this.temp=temp;
        this.humidity = humidity;
        this.pressure=pressure;
        measurementsChanged();
    }
}
