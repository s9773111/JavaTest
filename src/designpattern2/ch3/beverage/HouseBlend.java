package designpattern2.ch3.beverage;

import designpattern2.ch3.Beverage;

// 綜合咖啡
public class HouseBlend extends Beverage {

    public HouseBlend() {
        description = "House Blend Coffee";
    }

    @Override
    public double cost() {
        return .89;
    }
}
