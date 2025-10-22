package bomteng.Consumer;

import java.util.function.Consumer;
import java.util.stream.Stream;


public class TestConsumer {

    public static void main(String[] args) {
        TestConsumer testConsumer = new TestConsumer();
        testConsumer.test_Consumer();
    }

    public void test_Consumer() {
        // 1.使用Consumer 介面實現方法
        // 傳統 匿名類別 : 把「要對每個元素做什麼事」包成一個方法
        Consumer<String> consumer = new Consumer<String>(){
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        Stream<String> stream = Stream.of("aaa", "bbb", "ddd", "ccc", "fff");
        stream.forEach(consumer); // 呼叫accept


        System.out.println("********************");


        // 2.(簡化)使用lambda表達式, forEach方法需要一個Consumer介面
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
}
