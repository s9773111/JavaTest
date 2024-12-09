package bomteng.stream.test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 * 113/11/9 Stream
 * 基礎練習 GPT提供
 */
public class StreamTest0 {
    public static void main(String[] args) {
        // 生成方法1
        List<String> list = Arrays.asList("a", "b", "c", "d", "e", "abcDe", "f");
        Stream<String> stream = list.stream();
        // stream.forEach(System.out::println);

        System.out.println();

        // 生成方法2
        Stream<String> stream2 = Stream.of("1", "1", "2", "3", "5");
        //stream2.forEach(System.out::println);

        // 操作
        // filter, map, sorted, distinct, limit, skip,
        // ex1 過濾(保留)
        testFilter1(stream2);
        testFilter2();

        System.out.println("----------------------");
        // ex2 轉換 大小寫、取屬性、計算、改變格式、長度、複合轉、轉加條件、轉Map
        testMap1(stream);
        testMap2();
        testMap3();
        testMap4();
        testMap5();
        testMap6(); //複合轉
        testMap7(); //轉加條件
        testMap8(); //物件列表轉Map

        // ex3
        testAll();

        // stream.map(String::toUpperCase) => stream.map(s -> s.toUpperCase())


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

    static void testMap1(Stream<String> stream) {
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
