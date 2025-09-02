package bomteng.Lambda.Network;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 認識lambda語法
 *   Lambda與Collection關係
 *   也順便了解 Collection x Lambda/Stream 相互關係
 *
 *   forEach, removeIf, replaceAll, sort, distinct
 *   computeIfAbsent, merge, toMap
 *
 *   關鍵字：「集合 × Lambda/Stream」的日常功夫包
 *   有關 Stream 請看 StreamTestBasic.java
 */
public class LambdaTest4 {
    public static void main(String[] args) {
        // List/Set常用
        listDemo();

        // Map
        mapDemo();

        // 練習
        testDemo();

    }

    public static void listDemo() {
        // 遍歷
        // forEach 是 Iterable 內的方法
        List<String> names = List.of("Amy", "Bob", "Cindy");
        names.forEach(System.out::println);

        // 條件移除
        List<String> xs = new ArrayList<>(List.of("A", "BBB", "CCC"));
        System.out.println("移除前樣子：" + xs);
        xs.removeIf(s -> s.length() == 1);
        System.out.println("移除後剩下：" + xs);

        // 元素轉換 replaceAll
        List<String> xs2 = new ArrayList<>(List.of("a", "isaac", "city"));
        System.out.println("轉換前：" + xs2);
        xs2.replaceAll(String::toUpperCase);
        System.out.println("轉換後：" + xs2);

        // sort(搭配Comparator)
        // Comparator.comparingInt .thenComparing
        List<String> xs3 = new ArrayList<>(List.of("Ant","Robert","Cindey","Bob","Isaac" ));
        System.out.println("排序前: " + xs3);
        xs3.sort(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()));
        System.out.println("排序後: " + xs3);

        // distinct 去除重複
        List<Integer> ys = List.of(1,2,2,3,4,5,6,5,4,7,8,2,1,9,2);
        List<Integer> dedup = ys.stream().distinct().toList();
        System.out.println("原本List:" + ys);
        System.out.println("刪除重複:" + dedup);
    }

    public static void mapDemo() {
        // forEach
        Map<String, Integer> m = Map.of("a",1, "b",2, "c",3);
        m.forEach((k,v) -> System.out.println(k + " -> " + v));

        // computeIfAbsent 若不存在就建立新的, 存在就忽視
        // 可參 https://www.runoob.com/java/java-hashmap-computeifabsent.html
        // MapTest2.java
        Map<String, List<Integer>> buckets = new HashMap<>();
        System.out.println("本來 even內容：" + buckets.get("even"));
        System.out.println("本來 odd 內容：" + buckets.get("odd"));
        // 加入方式1
        buckets.computeIfAbsent("even", k -> new ArrayList<>()).add(1);
        // 加入方式2
        buckets.computeIfAbsent("even", k -> new ArrayList<>()).addAll(Arrays.asList(3,3,5,7));
        // 加入方式3 先取出再加入
        var odd = buckets.computeIfAbsent("odd", k -> new ArrayList<Integer>());
        odd.add(2);
        odd.addAll(List.of(2,4,8,10,4));

        System.out.println("後續 even內容：" + buckets.get("even"));
        System.out.println("後續 odd 內容：" + buckets.get("odd"));


        // merge 累加/合併
        Map<String, Integer> freq = new HashMap<>();
        Stream.of("a", "b", "c", "a").forEach(s -> freq.merge(s, 1, Integer::sum));
        System.out.println(freq);

        // replaceAll
        Map<String, Integer> scores = new HashMap<>(Map.of("Isaac", 83,"Bob", 90, "Cindy", 95, "Kevin", 80));
        System.out.println("加分前：" + scores);
        scores.replaceAll((k,v)->v+5); //全部加分
        System.out.println("加分後：" + scores);

        // toMap (key重複要給合併規則?)
        List<String> words = List.of("apple", "ant", "Banana", "Isaac", "Candy");
        // 重複取前者
        Map<Character, String> firstToWord = words.stream()
                .collect(Collectors.toMap(s -> s.charAt(0), s -> s, (a,b) -> a));
        firstToWord.forEach((k,v) -> System.out.println(k + " -> " + v));
    }

    public static void testDemo() {
        //1. List練習
        // 刪掉長度 < 3 的字（removeIf）
        // 所有字轉大寫（replaceAll）
        // 按字母序排序（sort）


        // 會噴錯，因為Arrays固定大小的 List，不能改變內容
        //List<String> words = Arrays.asList("apple", "car", "pharaoh", "bias", "Egypt", "rage");
        List<String> words = new ArrayList<>(Arrays.asList("apple", "car", "pharaoh", "bias", "Egypt", "rage"));
        words.removeIf( s -> s.length() < 4);
        System.out.println(words);

        words.replaceAll(String::toUpperCase);
        System.out.println(words);

        // Comparator.naturalOrder()
        words.sort(Comparator.naturalOrder());
        System.out.println(words);


        //2. Map 練習 | 要先建立一個Map結構變數
        // 看輸出是什麼
        // Map.merge(K key, V value, BiFunction<V,V,V> remappingFunction)
        //  1：要併入的值（這裡用 1 表示出現一次）
        //  Integer::sum：合併函式（當 key 已存在時，舊值 old 和這次的 1 相加）
        Map<String, Integer> mapTest = new HashMap<>();
        Stream.of("a", "b", "a", "c", "b", "a").forEach(s -> mapTest.merge(s, 1, Integer::sum));
        System.out.println(mapTest);

    }

}
