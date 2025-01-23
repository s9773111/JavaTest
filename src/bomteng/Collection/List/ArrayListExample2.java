package bomteng.Collection.List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 修改 list 元素
 * .set, .remove
 *
 * 排序 list
 *
 * 查找與檢查 list
 *
 * Stream 結合
 */
public class ArrayListExample2 {
    public static void main(String[] args) {
        List<String> animals = new ArrayList<>();
        animals.add("Cat");
        animals.add("Dog");
        animals.add("Bird");

        System.out.println("Original list: " + animals);

        //修改第二個元素
        animals.set(1, "Fish");
        System.out.println("Modified list: " + animals);

        // 移除特定元素
        animals.remove("Bird");
        System.out.println("After Removal: " + animals);

        // 移除指定索引
        animals.remove(0);
        System.out.println("After Index Removal: " + animals);

        System.out.println();

        // 排序 Collections.sort(), Collections.reverseOrder()
        arraySort();

        // List 查找與檢查
        arrayFind();

        // Stream
        arrayStream();
    }

    static void arraySort(){
        List<String> names = new ArrayList<>();
        names.add("Isaac");
        names.add("Bob");
        names.add("Dog");

        // 升序排序
        Collections.sort(names);
        System.out.println("Ascending Order: " + names);

        // 降序
        Collections.sort(names, Collections.reverseOrder());
        System.out.println("Descending Order:" + names);
    }

    static void arrayFind() {
        List<String> cities = new ArrayList<>();
        cities.add("New York");
        cities.add("Paris");
        cities.add("Tokyo");

        // 檢查元素是否存在
        boolean hasParis = cities.contains("Paris");
        System.out.println("Contains Paris: " + hasParis);

        // 查詢元素索引
        int index = cities.indexOf("Tokyo");
        System.out.println("Index of Tokyo: " + index);
    }

    static void arrayStream(){
        // stream使用
        List<String> names = List.of("Alice", "Bob", "Charlie", "David", "Isaac");

        // 塞選包含a
        List<String> filtered = names.stream()
                .filter(name -> name.toLowerCase().contains("a"))
                .collect(Collectors.toList());
        System.out.println("Filtered Names: " + filtered);

        // 塞選不包含a
        List<String> filtered2 = names.stream()
                .filter(name -> !name.toLowerCase().contains("a"))
                .collect(Collectors.toList());
        System.out.println("Filtered Names: " + filtered2);

        // 字串轉換大寫
        List<String> upperCaseNames = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Upper Case Names: " + upperCaseNames);

    }
}
