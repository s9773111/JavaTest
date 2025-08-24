package bomteng.Lambda.Book.A;

import java.util.Arrays;

/**
 * 114/8/23 Ch12
 * 12.1 認識Lambda語法 3
 *
 */
public class StringOrderDemo {
    public static void main(String[] args) {
        String[] names = {"Justin", "caterpillar", "Bush", "Apple", "Faker", "Isaac"};
        // 使用方法參考 ::
        Arrays.sort(names, StringOrder::byLength);
        System.out.println(Arrays.toString(names));
    }
}
