package designpattern.StrategyPattern;

public class StrategyMain {
    public static void main(String[] args) {
        Context context = new Context(new ConcreteStrategyA());
        context.executeStrategy(); //輸出： 執行策略A

        context.setStrategy(new ConcreteStrategyB());
        context.executeStrategy();
    }
}
