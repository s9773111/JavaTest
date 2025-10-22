package bomteng.Lambda.Network;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 認識lambda語法
 *   方法引用，主要有四種引用
 *   參考：https://www.cnblogs.com/qdhxhz/p/9393724.html
 *
 */
public class LambdaTest2 {

    public static void main(String[] args) {
        // 靜態方法引用
//        method1();
        System.out.println();

        // 實例方法引用
//        method2();
        System.out.println();

        // 建構子方法引用
        method3();
        System.out.println();

        // 其他方法函數
        // ChatGPT
//        method4();

    }

    public static void method1() {
        Apple apple1 = new Apple("紅蘋果", "Red", 280);
        Apple apple2 = new Apple("黑蘋果", "Block", 470);
        Apple apple3 = new Apple("黃蘋果", "Yellow", 320);
        Apple apple4 = new Apple("小小", "Green", 300);

        List<Apple> appleList = Arrays.asList(apple1, apple2, apple3, apple4);

        // 1.靜態方法引用(非方法的調用)
        appleList.sort(Apple::compareByWeight);
        appleList.forEach(apple -> System.out.println(apple));
    }

    public static void method2() {
        Apple apple1 = new Apple("紅蘋果", "Red", 280);
        Apple apple2 = new Apple("黑蘋果", "Block", 470);
        Apple apple3 = new Apple("黃蘋果", "Yellow", 320);
        Apple apple4 = new Apple("小小", "Green", 300);

        List<Apple> appleList = Arrays.asList(apple1, apple2, apple3, apple4);

        // 2.實例方法引用, 用 comparator 物件來引用
        AppleComparator comparator = new AppleComparator();
        appleList.sort(comparator::compareByWeight);

        appleList.forEach(apple -> System.out.println(apple));
    }

    public static void method3() {
        // Supplier: 沒有參數，但會回傳一個 T
        ConstructionMethodTest test = new ConstructionMethodTest();

        // lambda表達式
        // Supplier<T> 要傳一個沒有參數、但會回傳T的函式介面 (要傳函式)
        // 是「傳一個能執行 get() 產生值的物件」。
        System.out.println(test.getString(()->{return "Test";}));
        System.out.println(test.getString(()->{return new String();}));
        System.out.println(test.getString(()->"Hello via lambda"));

        // 構造方法引用
        System.out.println(test.getString(String::new));
    }

    public static void method4() {
        /**
         * 不同的目標型別(函式介面) | 依照參數數量可使用不同的型別
         * 0 參數建構子 → 用 Supplier<R>
         * 1 參數建構子 → 用 Function<A,R>
         * 2 參數建構子 → 用 BiFunction<A,B,R>
         * 3+ 參數建構子 → 自己定義介面（例如 TriFunction<A,B,C,R>）
         */

        // 對應 無參數建構子 new String() → s0.get() 產生空字串 ""
        Supplier<String> s0 = String::new;
        System.out.println(s0.get());

        // Function 內建方法 apply
        // 對應 單參數建構子 new String(String) → s1.apply("Hello") 回傳一個新的 String 副本
        Function<String, String> s1 = String::new;
        System.out.println(s1.apply("Hello Function"));

        // 3個參數時
        TriFunction<String,String,Double,Apple> a3 = Apple::new;
        Apple a = a3.apply("藍蘋果","blue",280.0);
        System.out.println(a);


    }

}

class Apple {
    private String name;
    private String color;
    private double weight;

    public Apple(String name, String color, double weight) {
        this.name = name;
        this.color = color;
        this.weight = weight;
    }

    // 可依照蘋果重量排序
    public static int compareByWeight(Apple a1, Apple a2) {
        return Double.compare(a1.getWeight(), a2.getWeight());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}

//實例方法引用
class AppleComparator {
    public int compareByWeight(Apple a1, Apple a2) {
        return Double.compare(a1.getWeight(), a2.getWeight());
    }
}


// 建構子方法引用
// Supplier: 沒有參數，但會回傳一個 T
// 提供/產生一個值，不需要輸入
class ConstructionMethodTest {
    // 要傳給他一個能執行 get()、回傳 String 的 Lambda。
    public String getString(Supplier<String> supplier) {
        return supplier.get();
    }
}

@FunctionalInterface
interface TriFunction<A,B,C,R> {
    R apply(A a, B b, C c);
}