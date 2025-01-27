package designpattern2.ch1;

import designpattern2.ch1.flybehavior.FlyBehavior;
import designpattern2.ch1.quackbehavior.QuackBehavior;

// ch1
// 超抽象類別
public abstract class Duck {
    FlyBehavior flyBehavior;

    QuackBehavior quackBehavior;
    public Duck() {

    }

    public abstract void display();

    // 委托給行為類別

    public void performFly() {
        flyBehavior.fly();
    }
    public void performQuack() {
        quackBehavior.quack();
    }

    public void swim() {
        System.out.println("All ducks float, even decoys!");
    }

    // 動態改變鴨子的行為
    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
}
