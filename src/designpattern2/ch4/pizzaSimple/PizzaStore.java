package designpattern2.ch4.pizzaSimple;

public class PizzaStore {
	SimplePizzaFactory factory;

	// 建構子中接收傳來的工廠
	public PizzaStore(SimplePizzaFactory factory) { 
		this.factory = factory;
	}
 
	public Pizza orderPizza(String type) {
		Pizza pizza;

		// 將訂單的種類傳給工廠，來建立pizza
		// 這邊將new運算子換成 factory 物件
		pizza = factory.createPizza(type);
 
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();

		return pizza;
	}

}
