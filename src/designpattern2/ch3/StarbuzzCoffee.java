package designpattern2.ch3;

import designpattern2.ch3.Condiment.Mocha;
import designpattern2.ch3.Condiment.Soy;
import designpattern2.ch3.Condiment.Whip;
import designpattern2.ch3.beverage.DarRoast;
import designpattern2.ch3.beverage.Espresso;
import designpattern2.ch3.beverage.HouseBlend;

public class StarbuzzCoffee {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        Beverage beverage2 = new DarRoast();
        beverage2 = new Mocha(beverage2);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Whip(beverage2);
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());

        Beverage beverage3 = new HouseBlend();
        beverage3 = new Soy(beverage3);
        beverage3 = new Mocha(beverage3);
        beverage3 = new Whip(beverage3);
        System.out.println(beverage3.getDescription() + " $" + beverage3.cost());


    }
}
