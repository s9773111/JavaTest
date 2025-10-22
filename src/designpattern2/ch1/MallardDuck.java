package designpattern2.ch1;

import designpattern2.ch1.flybehavior.FlyWithWings;

public class MallardDuck extends Duck{

    // 在建構子中設定鴨子的行為
    // quackBehavior, flyBehavior 實例變數是由 Duck 繼承而來
    public MallardDuck(){
        // 使用 Quack類別來執行自己的叫聲
        // 當呼叫performQuack()，鳴叫工作委託給Quack

        flyBehavior = new FlyWithWings();
    }


    @Override
    public void display() {
        System.out.println("I'm a real Mallard duck");
    }
}
