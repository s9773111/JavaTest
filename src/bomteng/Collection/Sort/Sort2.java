package bomteng.Collection.Sort;


import java.util.Arrays;
import java.util.Collections;

record Customer2(String id, String name, int age) implements Comparable<Customer2> {
    @Override
    public int compareTo(Customer2 other) {
        return this.age - other.age;
    }
}

public class Sort2 {
    public static void main(String[] args) {
        var accounts = Arrays.asList(
                new Customer2("X1234", "Justin", 46),
                new Customer2("X5678", "Justin", 22),
                new Customer2("X2468", "Justin", 34),
                new Customer2("X1357", "Justin", 47)
        );
        System.out.println("原排序：" + accounts);
        Collections.sort(accounts);
        System.out.println("排序後:" + accounts);
    }
}
