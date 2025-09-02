package bomteng.stream.test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.partitioningBy;

/**
 * 因查看 Lambda | LambdaTest4.java
 *  基本三件：map. filter, collect
 *  flatMap 展平
 *
 *
 *  GPT關鍵字：Stream 基本三件事：map / filter / collect
 */
public class StreamTestBasic {
    public static void main(String[] args) {

        // 基礎
        streamTest1();

        // flatMap 展平
        streamTest2();

        // collect 常見收集器
        streamTest3();

        // Arrays / Files 與 Stream
        streamTest4();

    }

    static void streamTest1() {
        // 基本三件事: map/filter/collect
        List<String> names = List.of("Amy","Bob","Cindy","Ann","Doggy","Isaac");
        List<Integer> lens = names.stream()
                .filter(s -> s.startsWith("A"))     //保留A開頭
                .map(String::length)                    //轉長度數
                .sorted()                                //排序
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
        System.out.println("Set後:" + set);
        // joining
        String csv = names.stream().collect(Collectors.joining(","));
        System.out.println("joining後:" + csv);
        // 判斷型別
        System.out.println(set.getClass().getName()); //java.util.HashSet
        System.out.println(csv.getClass().getName()); //java.lang.String

        System.out.println("set是否為 java.util.Set:" + (set instanceof java.util.Set));
        System.out.println("csv是否為 String:" + (csv instanceof String));

        // groupingBy + downstream
        Map<Integer, Long> lengthCount = names.stream()
                .collect(Collectors.groupingBy(String::length, counting()));

        System.out.println("動作後:" + lengthCount);

        // partitioningBy 二分法
        // {false=[Cindy, Doggy, Isaac, Book], true=[Amy, Bob, Ann]}
        Map<Boolean, List<String>> parts = names.stream()
                .collect(partitioningBy(s -> s.length() <=3));
        System.out.println(parts);
    }

    public static void streamTest4() {
        int sum = Arrays.stream(new int[]{1,2,3}).sum();
        System.out.println(sum);

        try (var lines = java.nio.file.Files.lines(java.nio.file.Path.of("data.txt"))) {
            var stats = lines.collect(partitioningBy(String::isBlank, counting()));
            long blank = stats.getOrDefault(true, 0L);
            long nonBlank = stats.getOrDefault(false, 0L);

//            long cnt = lines.filter(l -> !l.isBlank()).count();
//            long cnt2 = lines.filter(l -> l.isBlank()).count();
            System.out.println("有字的行數:" + nonBlank);
            System.out.println("無字的行數:" + blank);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
