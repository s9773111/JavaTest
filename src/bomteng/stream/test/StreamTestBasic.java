package bomteng.stream.test;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamTestBasic {
    public static void main(String[] args) {

        // 基礎
        streamTest1();

        // flatMap 展平
        streamTest2();

        // collect 常見收集器
        streamTest3();
    }

    static void streamTest1() {
        // 基本三件事: map/filter/collect
        List<String> names = List.of("Amy","Bob","Cindy","Ann","Doggy","Isaac");
        List<Integer> lens = names.stream()
                .filter(s -> s.startsWith("A"))
                .map(String::length)
                .sorted()
                .collect(Collectors.toList());
    }

    static void streamTest2() {
        List<List<Integer>> nested = List.of(List.of(1,2), List.of(3,1,2,4,5), List.of(6,7,8,9), List.of(10,11,12));
        List<Integer> flat = nested.stream().flatMap(List::stream).toList();
        System.out.println("未攤平:" + nested);
        System.out.println("攤平:" + flat);
    }

    static void streamTest3() {
        List<String> names = List.of("Amy","Bob","Cindy","Ann","Doggy","Isaac", "Book");

        // 轉Set
        Set<String> set = names.stream().collect(Collectors.toSet());
        //joining
        String csv = names.stream().collect(Collectors.joining(","));
        System.out.println("joining後:" + csv);

        // groupingBy + downstream
        Map<Integer, Long> lengthCount = names.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.counting()));

        System.out.println("動作後:" + lengthCount);
    }
}
