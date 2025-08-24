package bomteng.Generics.Network;

import java.util.ArrayList;
import java.util.List;

/**
 * 呼應 bomteng.Lambda.Book.A.MethodReferenceDemo
 *
 * 泛型介紹
 * 讓你在類別、介面、方法上，用「型別參數」來寫出可重用、型別安全的程式碼。
 *
 * GPT關鍵字：能介紹一下泛型，以及簡單的範例應用
 *
 */
public class GenericsTest1 {
    public static void main(String[] args) {
        // 基礎用法
        test1();

        //泛型類別
        test2();

        //泛型方法
        test3();

        
    }

    static void test1() {
        List<String> names = new ArrayList<>();
        names.add("Isaac");
        // names.add(123); // 此無法編譯
        String first = names.get(0);
        System.out.println(first);
    }

    static void test2() {
        Box<Integer> bi = new Box<>();
        bi.set(42);
        System.out.println("數值型態：" +bi.get());

        Box<String> bii = new Box<>();
        bii.set("generics");
        System.out.println("數值型態2：" +bii.get());
    }

    static void test3() {
        String s = first(List.of("Apple", "B", "C"));
        Integer n = first(List.of(1,2,3));

        System.out.println(s);
        System.out.println(n);
    }

    static <T> T first(List<T> list) {
        return list.isEmpty() ? null : list.get(0);
    }
}

class Box<T> {
    private T value;
    public void set(T v) { this.value = v; }
    public T get() { return value; }
}
