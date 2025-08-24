package bomteng.Lambda.Book.A;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 114/8/23 Ch12
 * 12.1 認識Lambda語法 1
 *
 */
public class LambdaDemo {
    public static void main(String[] args) {
        // 使用匿名類別的方式
        oldfunction();
        oldfunction2();

        lambdatest();
    }



    public static void oldfunction() {
        String[] names = {"Justin", "caterpillar", "Bush", "Alice", "Isaac"};
        Arrays.sort(names, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
        System.out.println(Arrays.toString(names));
    }

    public static void oldfunction2() {
        // 使用匿名類別
        Comparator<String> byLength = new Comparator<String> () {
            public int compare(String n1, String n2){
                return n1.length() - n2.length();
            }
        };

        String[] names = {"Justin", "caterpillar", "Bush", "Alice", "Isaac"};
        Arrays.sort(names, byLength);

        System.out.println(Arrays.toString(names));
    }

    public static void lambdatest() {
        String[] names = {"Justin", "caterpillar", "Bush", "Apple", "Faker", "Isaac"};
        Arrays.sort(names, (n1, n2)->n1.length() - n2.length());
        System.out.println(Arrays.toString(names));
    }
}
