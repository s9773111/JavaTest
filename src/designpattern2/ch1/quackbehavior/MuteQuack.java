package designpattern2.ch1.quackbehavior;

public class MuteQuack implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("(Silence)");
    }
}
