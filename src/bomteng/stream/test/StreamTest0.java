package bomteng.stream.test;

import java.util.*;
import java.util.stream.*;

/**
 * 113/11/9 Stream
 * 基礎練習
 */
public class StreamTest0 {
    public static void main(String[] args) {
        // 生成方法1
        createStream();

        // 生成方法2
        Stream<String> stream2 = Stream.of("1", "1", "2", "3", "5");
        //stream2.forEach(System.out::println);

        System.out.println("--------------------------------------------");

        // 操作
        // filter, map, sorted, distinct, limit, skip,
        // ex1 過濾(保留)
        testFilter1(stream2); // 字母開頭
        testFilter2(); // 字母包含
        testFilter3();

        System.out.println("--------------------------------------------");
        // ex2 轉換 大小寫、取屬性、計算、改變格式、長度、複合轉、轉加條件、轉Map
        testMap1(); // 大小寫
        testMap2(); // 提取
        testMap3(); // 計算-平方
        testMap4(); // 呈現格式
        testMap5(); // 長度
        testMap6(); //複合轉
        testMap7(); //轉加條件
        testMap8(); //物件列表轉Map

        System.out.println("--------------------------------------------");

        // 其他method
        testReduce();
        System.out.println("--------------------------------------------");
        testDistinct();
        System.out.println("--------------------------------------------");
        testLimitSkip();
        System.out.println("--------------------------------------------");
        testMatch();
        System.out.println("--------------------------------------------");
        testPrimitivestream();
        System.out.println("--------------------------------------------");
        // ex3
        testAll();

        // stream.map(String::toUpperCase) => stream.map(s -> s.toUpperCase())
    }

    static void createStream() {
        // 1
        List<String> list = Arrays.asList("a", "b", "c", "d", "e", "abcDe", "f");
        Stream<String> stream = list.stream();
        System.out.println("createStream 1: ");
        stream.forEach(System.out::println);

        System.out.println();

        // 2 產生無限序列
        Stream<Integer> infiniteStream = Stream.iterate(1, n -> n+1).limit(10);
        System.out.println("createStream 2: ");
        // infiniteStream.forEach(System.out::print);

        infiniteStream.forEach(n -> System.out.print(n + "\t"));
        System.out.println();
    }


    static void testFilter1(Stream<String> stream) {
        System.out.println("testFilter1：");
        stream.filter(s -> s.startsWith("1")).forEach(System.out::println);
    }

    static void testFilter2(){
        List<String> fruits = Arrays.asList("apple", "banana", "cherry", "orange", "fig", "grape", "guava", "melons");

        System.out.println("testFilter2 原清單：" + fruits);

        // 只保留包含a的字母
        List<String> filteredFruits = fruits.stream()
                .filter(name -> name.contains("a"))
                .collect(Collectors.toList());
        System.out.println("testFilter2 保留含a字清單：" + filteredFruits);

        //去除掉含有a字母
        List<String> filteredFruits2 = fruits.stream()
                .filter(name->!name.contains("a"))
                .collect(Collectors.toList());
        System.out.println("testFilter2 去除含有a清單：" + filteredFruits2);

    }


    static void testFilter3() {
        // 限定長度
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Isaac");
        List<String> filteredNames = names.stream()
                .filter(name -> name.length() > 3)
                .collect(Collectors.toList());

        System.out.println("testFilter3 長度超過3的名字: " + filteredNames);
    }

    static void testMap1() {
        List<String> list = Arrays.asList("a", "b", "c", "d", "e", "abcDe", "f");
        Stream<String> stream = list.stream();
        // 轉大寫
        System.out.print("testMap1 轉大寫：");
        stream.map(String::toUpperCase).forEach(element -> System.out.print(element + "\t"));
        System.out.println();
        // 轉小寫
        List<String> names = Arrays.asList("Isaac", "Andy", "Jessica", "Candy");
        List<String> lowerCaseNames = names.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());
        System.out.println("轉小寫:" + lowerCaseNames);


    }

    static void testMap2(){
        List<Person> people = Arrays.asList(new Person("Alice", 25), new Person("Bob",33), new Person("Isaac", 34));

        List<String> names = people.stream()
                .map(Person::getName)
                .collect(Collectors.toList());
        System.out.println("testMap2 提取姓名：" + names);
    }

    static void testMap3() {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
        List<Integer> squares = numbers.stream()
                .map(n->n*n)
                .collect(Collectors.toList());

        System.out.println("testMap3 平方：" + squares);
    }

    static void testMap4() {
        List<Double> prices = Arrays.asList(12.99, 8.99, 15.22);

        List<String> priceStrings = prices.stream()
                .map(price -> "$" + price)
                .collect(Collectors.toList());
        System.out.println("testMap4 格式：" + priceStrings);
    }

    static void testMap5() {
        List<String> words = Arrays.asList("apple", "banna", "isaacTestJava", "cherry");
        List<Integer> lengths = words.stream()
                .map(String::length)
                .collect(Collectors.toList());

        System.out.println("testMap5 長度：" +lengths);
    }

    static void testMap6() {
        // 複合轉：先轉大寫、再取前兩位字
        List<String> names = Arrays.asList("apple", "banana", "cherry", "isaac");
        List<String> shortNames = names.stream()
                .map(String::toUpperCase)
                .map(name->name.substring(0,2))
                .collect(Collectors.toList());
        System.out.println("testMap6 複合轉(大+取2)：" + shortNames);
    }

    static void testMap7() {
        // 轉並加上條件，過濾掉長度小於五的字串，再轉大寫
        List<String> words = Arrays.asList("apple", "kiwi", "banana", "fig", "isaacChang", "isaac");
        System.out.println("testMap7 本來：" + words);

        List<String> result = words.stream()
                .filter(word->word.length() > 5)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("testMap7 過濾長度超過5並轉大 轉後：" + result);
    }

    static void testMap8() {
        List<Person> people = Arrays.asList(new Person("Alice", 25), new Person("Bob",33), new Person("Isaac", 34));

        Map<String, Integer> nameToAgeMap = people.stream()
                .collect(Collectors.toMap(Person::getName, Person::getAge));

        System.out.println("testMap8 變Map key.value："+ nameToAgeMap);
    }

    static void testReduce() {
        List<Integer> nums = Arrays.asList(1,2,3,8,4,5,6);

        // 計算總和
        int sum = nums.stream()
                .reduce(0, Integer::sum);
        System.out.println("testReduce 1 計算總和: " + sum);

        // 計算最大值1
        Optional<Integer> max = nums.stream().reduce(Integer::max);
        System.out.print("testReduce 2 找最大值reduce : ");
        max.ifPresent(System.out::println);

        // 計算最大值2 直接用
        Optional<Integer> max2 = nums.stream().max(Integer::compareTo);
        System.out.print("testReduce 2 找最大值max : ");
        max2.ifPresent(System.out::println);

        List<String> list = Arrays.asList("1","2","3","8","4","5","6");
        Optional<String> min = list.stream().min(Comparator.naturalOrder());
        System.out.println("testReduce 3 找最小值min : " + min);
        Optional<String> max3 = list.stream().max(Comparator.naturalOrder());
        System.out.println("testReduce 4 找最大值max : " + max3);
        long count = list.stream().count();
        System.out.println("testReduce 5 計數 : " + count);


    }

    static void testDistinct() {
        List<String> distinctList = Arrays.asList("a", "b", "a", "c", "d", "c").stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.print("testDistinct : ");
        System.out.println(distinctList);
    }

    static void testLimitSkip() {
        List<String> list = Arrays.asList("a", "b", "c", "d", "e", "f", "g");

        List<String> limited = list.stream()
                .limit(2).collect(Collectors.toList()); // 只取前2個
        System.out.print("testLimitSKip 1 : " + limited);

        System.out.println();

        List<String> skipped = list.stream()
                                   .skip(2) // 避開前兩個
                                   .collect(Collectors.toList());
        System.out.println("testLimitSKip 2 : " + skipped);

    }

    static void testMatch() {
//        List<String> words = Arrays.asList("apple", "kiwi", "banana", "fig", "isaacChang", "isaac", "andy", "pokemon");
        List<String> words = Arrays.asList("apple", "akiwi", "abanana", "afig", "aisaacChang", "aisaac", "andy", "apokemon");
        boolean anyStartsWithA = words.stream().anyMatch(s -> s.startsWith("a"));
        boolean allStartsWithA = words.stream().allMatch(s -> s.startsWith("a"));
        boolean noneStartsWithA = words.stream().noneMatch(s -> s.startsWith("a"));
        System.out.println("testMatch 原集合：" + words);
        System.out.println("testMatch 1 是否有任一個是a開頭：" + anyStartsWithA);
        System.out.println("testMatch 2 是否全部是a開頭：" + allStartsWithA);
        System.out.println("testMatch 3 是否都不是a開頭：" + noneStartsWithA);
    }

    static void testPrimitivestream() {
        IntStream intStream = IntStream.range(1, 8);
        LongStream longStream = LongStream.rangeClosed(1,10);
        DoubleStream doubleStream = DoubleStream.of(1.0, 2.0, 3.0);

        System.out.println("testPrimitivestream intstream : " + intStream);
        intStream.forEach(System.out::println); // 打印每個元素

        System.out.println("testPrimitivestream longStream : " + longStream);
        longStream.forEach(System.out::println);

        System.out.println("testPrimitivestream doubleStream : " + doubleStream);
        doubleStream.forEach(System.out::println);

        // 常用操作 stream 只能用一次
        // 使用多個統計
        IntSummaryStatistics stats = IntStream.range(1,8).summaryStatistics();
        int sum = IntStream.range(1, 8).sum();
        OptionalDouble avg =IntStream.range(1, 8).average();
        OptionalInt max = IntStream.range(1, 8).max();
        System.out.println("testPrimitivestream sum : " + sum);
        System.out.println("testPrimitivestream avg : " + avg);
        System.out.println("testPrimitivestream max : " + max);
        System.out.println("testPrimitivestream stats.getMin : " + stats.getMin());
        System.out.println("testPrimitivestream stats.getCount : " + stats.getCount());

    }

    static void testAll() {
        List<String> names = Arrays.asList("12345", "123", "12345");
        int totalLength = names.stream()
                .mapToInt(String::length)
                .sum();
        System.out.println("testAll：" + totalLength);
    }

    static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

}
