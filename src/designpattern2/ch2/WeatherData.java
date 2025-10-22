package designpattern2.ch2;

import designpattern2.ch2.interf.Observer;
import designpattern2.ch2.interf.Subject;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {
    // 來保存Observes，並在建構式中建立
    private List<Observer> observers;
    private float temperature;
    private float humidity;

    private float pressure;

    public WeatherData() {
        this.observers = new ArrayList<Observer>();
    }

    // 實作Subject介面
    // 有觀察者註冊就加入到清單內
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }
    // 實作Subject介面
    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }
    // 實作Subject介面
    // 把最新的狀態傳給所有觀察者
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
           // observer.update(temperature, humidity, pressure);
            observer.update();
        }
    }

    public void measurementsChanged() {
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}
