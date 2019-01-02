package com.kr.caption.designmode;

import com.kr.caption.designmode.observer.CurrentConditionDisplay;
import com.kr.caption.designmode.observer.WeatherData;

public class ObserverTest {

    public static void main(String[] args) {

        WeatherData weatherData = new WeatherData();
        CurrentConditionDisplay currentBoard = new CurrentConditionDisplay(weatherData);

        weatherData.setMeasurements(34f,46f, 65f);
    }

}
