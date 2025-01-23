package designpattern.FactoryMethod;

public class SimpleFactory {
    public static void main(String[] args) {
        Product product = SimpleFactory.createProduct("A");
        product.use();
    }

    public static Product createProduct(String type) {
        if ("A".equals(type)) {
            return new ProductA();
        } else if ("B".equals(type)) {
            return new ProductB();
        } else {
            throw new IllegalArgumentException("未知產品類型：" + type);
        }
    }
}
