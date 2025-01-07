package bomteng.Consumer;

import java.util.function.Consumer;

public class TestConsumer2 {
    public static void main(String[] args) {
        // 常用方法：
        // 1. accpet()
        // 定義一個consumer
        Consumer<String> printConsumer = s -> System.out.println(s);
        printConsumer.accept("Hello, Java 8 Consumer!");
        printConsumer.accept("Isaac");
        printConsumer.accept("113/12/17");

        System.out.println();

        // 2. andThen(Consumer<? super T> after)
        method2();

        System.out.println();

        // 3. Consumer 與 Stream 應用
        methodStream();

        System.out.println();

        // 4. 物件類型操作
        method3();

    }

    public static void method2() {
        Consumer<String> printUpperCase = s -> System.out.println(s.toUpperCase());
        Consumer<String> printLowerCase = s -> System.out.println(s.toLowerCase());

        //串接兩個Consumer
        Consumer<String> combinedConsumer = printUpperCase.andThen(printLowerCase);
        combinedConsumer.accept("Java8 Consumer Example");
    }

    public static void method3(){
        Consumer<Citizen> electionConsumer = c -> {
          if (c.getAge() < 18) {
              System.out.println(c.getName() + " is not eligible to vote.");
          } else {
              System.out.println(c.getName() + " can vote.");
          }
        };
        electionConsumer.accept(new Citizen("Ritesh", 15));
        electionConsumer.accept(new Citizen("Shreya", 20));
    }

    public static void methodStream(){

    }
}

class Citizen {
    private String name;
    private int age;

    public Citizen(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
