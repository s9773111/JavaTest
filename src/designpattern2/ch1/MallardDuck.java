package designpattern2.ch1;

import designpattern2.ch1.flybehavior.FlyWithWings;
import designpattern2.ch1.quackbehavior.Quack;

public class MallardDuck extends Duck{

    // 在建構子中設定鴨子的行為
    public MallardDuck(){
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }


    @Override
    public void display() {
        System.out.println("I'm a real Mallard duck");
    }
}
