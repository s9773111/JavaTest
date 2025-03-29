package designpattern2.ch3.beverage;

import designpattern2.ch3.Beverage;

// 低咖啡因
public class Decaf extends Beverage {

    public Decaf() {
        description = "Decaf Coffee";
    }
    @Override
    public double cost() {
        return 1.05;
    }
}
