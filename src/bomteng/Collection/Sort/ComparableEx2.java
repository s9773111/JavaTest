package bomteng.Collection.Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparableEx2 {
    public static void main(String[] args) {
        // 使用 自然排序
        List<Product> products = new ArrayList<>();
        products.add(new Product("C102", 19.99));
        products.add(new Product("A305", 29.99));
        products.add(new Product("B210", 15.30));
        products.add(new Product("D001", 30.15));
        System.out.println("products 排序前:" + products);

        Collections.sort(products);
        System.out.println("products 排序後:" + products);

        // 使用 自訂義排序
        byselfSort(products);

    }

    static void byselfSort(List<Product> products) {
        System.out.println("開始自定義: ");
        // 自訂義排序-按照價格
        Comparator<Product> byPrice = Comparator.comparingDouble(Product::getPrice);
        products.sort(byPrice);
        for (Product product : products) {
            System.out.println(product);
        }
    }
}


class Product implements Comparable<Product> {
    private String id;

    private double price;

    public Product(String id, double price) {
        this.id = id;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public int compareTo(Product product) {
        return this.id.compareTo(product.id);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", price=" + price +
                '}';
    }
}
