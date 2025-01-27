package designpattern2.ch1;

import designpattern2.ch1.flybehavior.FlyNoWay;
import designpattern2.ch1.quackbehavior.Quack;

public class ModelDuck extends Duck{
    public ModelDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

    public void display() {
        System.out.println("I'm a model duck");
    }
}
