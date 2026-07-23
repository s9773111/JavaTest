package bomteng.Lambda.Network;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 115/7/23
 * :: 的 4 大適用類型與範例導覽
 */
public class MethodReferenceDemo {
    public static void main(String[] args) {
        // 類型1: 靜態方法引用
        // 介面 Function<String, Integer> -> 接收String, 回傳Integer
        Function<String, Integer> parseLambda = s -> Integer.parseInt(s);
        Function<String, Integer> parseRef = Integer::parseInt;
        System.out.println("ex1-1:" + parseLambda.apply("3"));
        System.out.println("ex1-1:" + parseRef.apply("2"));

        // 類型2: 特定物件的實體方法引用
        // 介面：Function<String, String>
        String prefix = "Hello, ";
        Function<String, String> concatRef = prefix::concat;
        System.out.println("ex2:" + concatRef.apply("Isaac, Good Morning!!"));

        // 類型3: 任意物件的實體方法引用
        // 介面: Function<String, Integer> -> 第一個參數會當成呼叫者
        Function<String, Integer> lengthRef = String::length;
        System.out.println("ex3:" + lengthRef.apply("Hello, World!!!"));

        // 類型4: 建構子引用
        // 介面 Supplier<StringBuilder> -> 無參數, 回傳新物件
        Supplier<StringBuilder> sbRef = StringBuilder::new;
        StringBuilder sb = sbRef.get().append("123test");
        System.out.println("ex4:" + sb.toString());


    }
}
