package designpattern2.ch1;

import designpattern2.ch1.flybehavior.FlyRocketPowered;

public class MiniDuckSimulator {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        // 會呼叫繼承而來的方法，這個方法會將工作委託給物件的QuackBehavior
        // (呼叫鴨子繼承來的quackBehavior所參考的quack())
        System.out.println("第一隻鴨子：");
        mallard.display();
        mallard.performQuack();
        mallard.performFly();

        System.out.println();

        Duck model = new ModelDuck();
        System.out.println("第二隻鴨子：");
        model.display();
        model.performQuack();
        model.performFly();

        System.out.println();

        // 這邊是動態設定行為
        Duck model2 = new ModelDuck();
        System.out.println("第三隻鴨子：");
        model2.display();
        model2.performFly(); // 原本建構式內設定的飛行
        model2.setFlyBehavior(new FlyRocketPowered());
        model2.performQuack();
        model2.performFly();
    }
}
