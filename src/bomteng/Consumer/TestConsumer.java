package bomteng.Consumer;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;


public class TestConsumer {

    public static void main(String[] args) {
        TestConsumer testConsumer = new TestConsumer();
        testConsumer.test_Consumer();

        ex1();
    }

    public void test_Consumer() {
        // 1.使用Consumer 介面實現方法
        // [傳統] 匿名類別 : 把「要對每個元素做什麼事」包成一個方法
        Consumer<String> consumer = new Consumer<String>(){
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        Stream<String> stream = Stream.of("aaa", "bbb", "ddd", "ccc", "fff");
        stream.forEach(consumer); // 呼叫accept

        System.out.println("********************");

        // 2.[簡化] 使用lambda表達式, forEach方法需要一個Consumer介面
        Consumer<String> consumer1 = (s) -> System.out.println(s); //返回是一個consumer介面
        stream = Stream.of("ggg", "kkk", "mmm", "ooo", "qqq");
        stream.forEach(consumer1);
        // 更直接方式
        // stream.forEach((s)-> System.out.println(s));

        System.out.println("********************");

        // 3.使用方法引用，方法引用就是一個consumer
        Consumer consumer2 = System.out::println;
        stream = Stream.of("aaa", "bbb", "ddd", "ccc", "fff");
        stream.forEach(consumer2);
        // 更直接方式
        // stream.forEach(System.out::println);
    }

    // 內建函式範例
    static void ex1() {
        // 1. Predicate<t> test()
        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println("Is 4 even? " + isEven.test(4));
        System.out.println("Is 7 even? " + isEven.test(7));

        // 2. Function<T, R> apply()
        Function<String, Integer> stringLength = s -> s.length();
        System.out.println("Length of 'Hello' : " + stringLength.apply("Hello"));

        // 3. Consumer<T> accept
        Consumer<String> printOut = s -> System.out.println(s);
        printOut.accept("This is a test message");

        // 4. Supplier<T> get()
        Supplier<Double> randomNum = () -> Math.random();
        System.out.println("Random number : " + randomNum.get());
    }

}
