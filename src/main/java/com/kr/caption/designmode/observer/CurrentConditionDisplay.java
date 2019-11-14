package com.kr.caption.designmode.observer;

public class CurrentConditionDisplay implements Observer, DisplayElement {

    private float temp;
    private float humidity;
    private Subject weatherData;

    public CurrentConditionDisplay(Subject weatherData) { //构造器需要主题对象，来注册
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        display();
    }

    @Override
    public void display() {
        System.out.println("Current conditions: " + temp + "degree and " + humidity + "% humidity");
    }
}
