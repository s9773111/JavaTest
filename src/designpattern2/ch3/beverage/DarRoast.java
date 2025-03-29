package designpattern2.ch3.beverage;

import designpattern2.ch3.Beverage;

// 深焙咖啡
public class DarRoast extends Beverage {

    public DarRoast() {
        description = "DarRoast Coffee";
    }
    @Override
    public double cost() {
        return .99;
    }
}
