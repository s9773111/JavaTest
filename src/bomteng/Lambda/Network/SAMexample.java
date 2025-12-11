package bomteng.Lambda.Network;

import bomteng.Collection.Sort.User;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * 2025/12/11
 *
 * 練習java8內建四大SAM 1 :
 *  Consumer    -> accept
 *  Functional  -> apply
 *  Supplier    -> get
 *  Predicate   -> test
 */

public class SAMexample {
    public static void main(String[] args) {
        // 1.Consumer: 接受一個輸入、不回傳結果 accept
        // ex: 集合中的forEach
        // Consumer<String> printer = s -> System.out.println(s);
        // ConsumerEx();

        // 2.Function: 接收T -> 回傳R(轉換函數) apply
        // ex: stream的map
        // Function<String, Integer> length = s -> s.length();
        // FunctionEx();

        // 3.Supplier: 無輸入 -> 回傳(提供資料) get
        // 常用來包裝「無參數建構子」或工廠方法 | ex: stream的 collect(), stream的generate
        // Supplier<Double> random = () -> Math.random();
        // SupplierEx();

        // 4.Predicate: 回傳boolean, 判斷條件
        // Predicate<Integer> isEven = n -> n % 2 == 0;
        PredicateEx();


    }

    public static void ConsumerEx() {
        System.out.println("Consumer example:");

        //ex1
        //forEach可負責將集合中每個元素傳給 Consumer，並執行accept()方法內邏輯。
        List<String> list = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H");
        list.forEach(s -> System.out.print("Item:" + s +'\t'));

        System.out.println();

        //ex2
        //串接Consumer: andThen
        Consumer<String> toUpper = s -> System.out.print(s.toUpperCase() + '\t');
        Consumer<String> toLower = s -> System.out.print(s.toLowerCase() + '\t');
        Consumer<String> exclaim = s -> System.out.print(s + "!!!");

        Consumer<String> combined = toUpper.andThen(toLower).andThen(exclaim);
        combined.accept("Hello World");

        System.out.println();

        //ex3
        //累積錯誤訊息
        StringBuilder sb = new StringBuilder();
        Consumer<String> err = msg -> sb.append(msg).append("\t\t");
        err.accept("Wrong format");
        err.accept("Missing value");
        System.out.println(sb);

        System.out.println();
    }
    public static void FunctionEx() {
        System.out.println("Function example:");

        //ex1
        //字串轉Integer
        Function<String, Integer> parse = Integer::parseInt;
        System.out.println(parse.apply("1234"));

        //ex2 轉換物件
        Function<User, String> getName = user -> user.getName();
        System.out.println(getName.apply(new User("Andy", 25, true)));

        //ex3 兩個function串接
        Function<String, String> trim = s -> s.trim();
        Function<String, String> upper = s -> s.toUpperCase();

        String result = trim.andThen(upper).apply("Hi Isaac");
        System.out.println(result);
    }
    public static void SupplierEx() {
        System.out.println("Supplier example:");

        //ex1 每次取得新的物件(如new Date)
        Supplier<Date> now = () -> new Date();
        System.out.println(now.get());

        //ex2 lazy loading/延遲初始化
        Supplier<List<String>> createList = ArrayList::new;
        // 不能後面加add(), 因為他是回傳boolean值
        List<String> list = createList.get(); // 建立 取得新的 ArrayList()
        list.add("A");
        list.add("B");
        System.out.println(list);

        System.out.println();

        //ex3 Stream.generate(...)
        Stream<Double> randomStream = Stream.generate(Math::random);
        randomStream.limit(10).forEach(System.out::println);

        //ex4 Optional.orElseGet()
        // orElseGet(Supplier) 只有真正需要預設值才會執行Supplier
        // orElseGet(是屬於 lazy evaluation, 除非 Optional是空的 否則不會執行Supplier.get()
        String name = null;
        String result = Optional.ofNullable(name)
                .orElseGet(() -> "Default Name: Isaac");
        System.out.println(result);

        // orElse 會呼叫方法並取得return值
        // 但是：回傳值會被丟掉，如果Optional內原本有值
        String name2 = "Banana Pie";
        String result2 = Optional.ofNullable(name2)
                .orElse(loadDefaultName());

        System.out.println(result2);

    }
    public static void PredicateEx() {
        System.out.println("Predicate example:");

        // ex1 判斷字串是否為空
        Predicate<String> isEmpty = s ->  s == null || s.isEmpty();
        System.out.println(isEmpty.test("")); //true

        // ex2 Predicate（and / or / negate）
        Predicate<Integer> isPositive = n -> n > 0;
        Predicate<Integer> isEven = n -> n%2 == 0;
        Predicate<Integer> isPositiveEven = isPositive.and(isEven);
        System.out.println(isPositive.test(1));  //true
        System.out.println(isPositive.test(4));  //true
        System.out.println(isPositive.test(-4)); //false

        // 不區分大小寫
        Predicate<String> starts = s -> s.toUpperCase().startsWith("A");
        Predicate<String> ends = s -> s.toUpperCase().endsWith("X");
        Predicate<String> startsOrEnds = starts.or(ends);

        System.out.println(startsOrEnds.test("Apple"));
        System.out.println(startsOrEnds.test("Banana Pie"));
        System.out.println(startsOrEnds.test("Box"));

        // ex3:過濾stream
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6);
        Predicate<Integer> isOdd = n -> n % 2 == 1;

        nums.stream()
                .filter(isOdd)
                .forEach(System.out::println);
    }

    public static String loadDefaultName() {
        System.out.println("loadDefaultName() 被執行！！");
        return "Default Name: Apple Pie";
    }
}

