package designpattern2.ch2.display;

import designpattern2.ch2.WeatherData;
import designpattern2.ch2.interf.DisplayElement;
import designpattern2.ch2.interf.Observer;

/**
 * 目前天氣狀況
 * 實作 Observer 介面, 可以從WeatherData物件收到變更
 *
 */

public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private WeatherData weatherData;

    // 將WeatherData(Subject)傳給建構式
    // 並使用這個物件來將畫面註冊為觀察者
    // 使用建構子來組合
    public CurrentConditionsDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        // 註冊成為訂閱者 | 觀察者們
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
    }

    // 當 update() 被呼叫，就儲存氣溫和濕度
    // 並呼叫 display()
    @Override
    public void update() {
//        this.temperature = temperature;
//        this.humidity = humidity;
        this.temperature = weatherData.getTemperature();
        this.humidity = weatherData.getHumidity();
        display();
    }
}
