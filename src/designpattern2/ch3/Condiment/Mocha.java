package designpattern2.ch3.Condiment;

import designpattern2.ch3.Beverage;
import designpattern2.ch3.CondimentDecorator;

// Mocha 是裝飾器
public class Mocha extends CondimentDecorator {

    // 此類別繼承了Beverage實例變數，可用它來保存被包裝的飲料
    // 在這裡將被包裝的飲料傳給裝飾器的建構式
    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return beverage.cost() + .20;
    }

    // 也要知道包含裝飾器的那個飲料每一個項目
    // 先委託被裝飾的物件，取得他的描述 然後再加上自己的
    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }
}
