package bomteng.Generics.Network;

import java.util.ArrayList;
import java.util.Arrays;
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

// 能接受泛型的類
class Box<T> {
    // 本來是 ArrayList <T> , 但就只限定ArrayList
    private List <T> item = new ArrayList<>();

    private T value;

    public Box(T[] list) {
        item.addAll(Arrays.asList(list));
    }
    public Box() {

    };

    //接受泛型的函式
    public void Add(T i) {
        this.item.add(i);
    }
    public T getByIndex(int i) {
        return this.item.get(i);
    }
    // 第1種遍歷方式
    public int size() {
        return this.item.size();
    }
    // 第2種遍歷方式
    public List<T> getAllItems() {
        return this.item;
    }

    //靜態泛型方法
    // 此泛型參數與該建立物件的泛型參數沒有關係 | 建立用String, 呼叫此方法傳Integer
    public static <K> List<K> whoLong(List<K> o1, List<K> o2){
        if (o1.size() > o2.size()) {
            return o1;
        } else {
            return o2;
        }
    }

    // 可以接受不同類型的參數
    public static <K> List<?> whoLong2(List<?> o1, List<?> o2) {
        if (o1.size() > o2.size()) {
            return o1;
        } else {
            return o2;
        }
    }

    public void set(T v) {
        this.value = v;
    }
    public T get() {
        return value;
    }
}
