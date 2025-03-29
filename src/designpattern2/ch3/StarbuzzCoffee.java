package designpattern2.ch3;

import designpattern2.ch3.Condiment.Mocha;
import designpattern2.ch3.Condiment.Soy;
import designpattern2.ch3.Condiment.Whip;
import designpattern2.ch3.beverage.DarRoast;
import designpattern2.ch3.beverage.Espresso;
import designpattern2.ch3.beverage.HouseBlend;

// 實作供應咖啡
public class StarbuzzCoffee {
    public static void main(String[] args) {
        // 訂購 espresso、無調味品
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        // 製作 DarkRoast 物件
        Beverage beverage2 = new DarRoast();
        beverage2 = new Mocha(beverage2);   // 用 Mocha 包裝
        beverage2 = new Mocha(beverage2);   // 用 第二個 Mocha 包裝
        beverage2 = new Whip(beverage2);
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());

        Beverage beverage3 = new HouseBlend();
        beverage3 = new Soy(beverage3); // .15 豆漿
        beverage3 = new Mocha(beverage3);   // .2
        beverage3 = new Whip(beverage3);    // .1
        System.out.println(beverage3.getDescription() + " $" + beverage3.cost());


    }
}
