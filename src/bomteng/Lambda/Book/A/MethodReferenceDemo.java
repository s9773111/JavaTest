package bomteng.Lambda.Book.A;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * 114/8/24 Ch12
 * 12.1 認識Lambda語法 5
 *
 * 建構式參考(constructor references)
 * 只要靜態方法的方法簽署中
 * 參數與傳回值定義相同 也可使用靜態方法來定義函式介面實作
 *
 * 觀念：
 *  1.static : 靜態方法，不需要建立物件就能呼叫(ClassName.map(...))
 *
 *  2.<P, R> : 泛型型別參數，P為輸入, R為輸出
 *    可參泛型(bomteng.Generics.Network.GenericsTest1)
 *
 *  3.map(List<P> list, Function<P, R> mapper): 2個參數
 *   (1)List<P> list：要被轉換的清單，元素型別是 P
 *   (2)Function<P, R> mapper : java8函式式介面，有參、有回傳
 *
 *  4.回傳型別：List<R> , 主要是看到 <P, R> List<R>
 *
 *  測試參數：Justin caterpillar Bush Isaac
 *
 */

record Person(String name) {}

public class MethodReferenceDemo {

    // 把list的每個P 交給mapper算出R
    // 存入新清單 最後回傳此新清單
    static <P, R> List<R> map(List<P> list, Function<P, R> mapper) {
        var mapped = new ArrayList<R>(); // 建一個空的 ArrayList 來裝結果（元素型別 R）。
        for(var i=0; i<list.size();i++) { //遍歷每個索引
            // list.get(i) 取出一個P
            // mapper.apply 把P轉成R
            // 放進結果清單 mapped.add
            mapped.add(mapper.apply(list.get(i)));
        }
        return mapped;
    }

    public static void main(String[] args) {
        var names = List.of(args);

        // 把字串清單變成物件清單
        var persons = map(names, Person::new);
        System.out.println("印出人名：");
        persons.forEach(System.out::println);

        System.out.println();

        // 把字串清單映射成長度
        List<Integer> lengths = map(names, s -> s.length());
        System.out.println("印出長度1：");
        lengths.forEach(System.out::println);

        System.out.println();

        // 方法參考
        List<Integer> lengths2 = map(names, String::length);
        System.out.println("印出長度2：");
        lengths2.forEach(System.out::println);

        System.out.println();

        //轉大寫
        List<String> upper = map(names, String::toUpperCase);
        upper.forEach(System.out::println);
        System.out.println();
    }
}
