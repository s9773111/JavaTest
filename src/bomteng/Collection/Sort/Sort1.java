package bomteng.Collection.Sort;

import java.util.Arrays;

record Customer(String id, String name, int age) {}

public class Sort1 {
    public static void main(String[] args) {
        var accounts = Arrays.asList(
                new Customer("X1234", "Justin", 46),
                new Customer("X5678", "Justin", 22),
                new Customer("X2468", "Justin", 34),
                new Customer("X1357", "Justin", 47)
        );
//        Collections.sort(accounts);
        System.out.println(accounts);
    }
}
