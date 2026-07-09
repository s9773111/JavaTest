package bomteng.Lambda.Network;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Lambda 練習
 */
public class LambdaTest0 {
    public static void main(String[] args) {
        ex1();

        ex2();
    }

    static void ex1() {
        Calculator plus = (a, b) -> a + b;
        Calculator multi = (a, b) -> a * b;

        System.out.println("lambda 5,3 加法: " + plus.compute(5,3));
        System.out.println("lambda 2,8 乘法: " + multi.compute(2,8));
    }

    static void ex2() {
        // 1. Using Runnable interface
        Runnable task = () -> System.out.println("Executing task");
        new Thread(task).start();
        // 舊有寫法1
        Runnable task1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Executing task1");
            }
        };
        new Thread(task1).start();

        // 舊有寫法2
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Executing task2");
            }
        }).start();


        // 2. Using Comparator for sorting
        List<String> names = Arrays.asList("Isaac", "Quanqiu", "Japan", "cat");
        Collections.sort(names, (a, b) -> a.length() - b.length());
        System.out.println("Sorted names: " + names);
        // 舊有寫法
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.length() - b.length();
            }
        });

        // 3.Using Predicate for filtering
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
        numbers.stream().filter(n -> n % 2 == 0).forEach(System.out::println);
    }
}

@FunctionalInterface
interface Calculator {
    int compute(int a, int b);
}