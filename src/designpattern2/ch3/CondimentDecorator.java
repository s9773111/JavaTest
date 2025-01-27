package designpattern2.ch3;

// basic class

public abstract class CondimentDecorator extends Beverage{
    // 各個Decorator將要包裝的Beverage
    // 使用Beverage 超型態來引用 Beverage，好讓Decorator 可以包裝任何一種飲料
    protected Beverage beverage;

    public abstract String getDescription();
}
