package bomteng.Collection.Map;

import java.util.*;

public class MapTest2 {
    public static void main(String[] args) {
        // TreeMap是：有序 Map，根據 Key 排序
//        TreeMapTest();
//        TreeMapTest2();
        // LinkedHashMap（維持插入順序）
//        LinkedHashMapTest();
        // 遍歷 map
//        forEachMap();
        // Map 形體
//        MapStructure();
        // TreeMap 排序
//        TreeMapSort();

        // TreeMap 遍歷
//        TreeMapforEach();

        // computeIfAbsent
        commonMethod();
    }

    // 114/8/29 常用方法
    static void commonMethod() {
        // 方法: computeIfAbsent
        HashMap<String, Integer> prices = new HashMap<>();

        prices.put("Shoes", 200);
        prices.put("Bag", 300);
        prices.put("Pant", 150);
        System.out.println("HashMap: " + prices);

        int shirtPrice = prices.computeIfAbsent("Shirt", key -> 280);
        System.out.println("Price of Shirt: " + shirtPrice);

        System.out.println("Updated HashMap: " + prices);

        // 針對已經在裡面了
        // 因為已經存在了，就不會計算
        int shoePrice = prices.computeIfAbsent("Shoes", (key) -> 280);
        System.out.println("Price of Shoes: " + shoePrice);

        // 输出更新后的 HashMap
        System.out.println("Updated HashMap: " + prices);
    }

    static void TreeMapTest() {
        Map<String, Integer> map = new TreeMap<>();
        map.put("Banana", 20);
        map.put("Apple", 10);
        map.put("Cherry", 30);

        System.out.println("TreeMap (sorted by key): " + map);
    }

    static void TreeMapTest2() {
        TreeMap<String, Map<String, String>> treeMap = new TreeMap<>();

        Map<String, String> subMap1 = Map.of("name", "Alice", "age", "24");
        Map<String, String> subMap2 = Map.of("name", "Isaac", "age", "34");
        Map<String, String> subMap3 = Map.of("name", "Jax", "age", "33");

        treeMap.put("Apple", subMap1);
        treeMap.put("Cranberry", subMap3);
        treeMap.put("Banana", subMap2);
        // 取出 TreeMap 的 keySet 轉成 List<String>
        Set<String> keyList = new HashSet<>(treeMap.keySet());
        //List<String> keyList = new ArrayList<>(treeMap.keySet());
        System.out.println("Keys: " + keyList);
    }

    static void LinkedHashMapTest() {
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("Banana", 20);
        map.put("Apple", 10);
        map.put("Cherry", 30);

        System.out.println("LinkedHashMap (insertion order): " + map);
    }

    static void forEachMap() {
        Map<String, Object> data = new HashMap<>();
        data.put("name", "Justin");
        data.put("age", 30);
        data.put("height", 175.5);
        data.put("isMember", true);

        // 遍歷1
        data.forEach((k, v) -> System.out.println(k + ": " + v));
        System.out.println();
        // 遍歷2
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    static void MapStructure() {
        // 形體1
        Map<String, List<String>> fileMap = new HashMap<>();
        fileMap.put("Documents", Arrays.asList("file1.txt", "file2.pdf", "file3.ods"));
        fileMap.put("Images", Arrays.asList("image1.jpg", "image2.jpg", "image3.jpg"));
        fileMap.put("Music", Arrays.asList("song1.mp3", "song2.mp3", "song3.wav"));
        System.out.println("Documents: " + fileMap.get("Documents"));
        System.out.println("Images: " + fileMap.get("Images"));

        System.out.println();

        // 多層次結構
        Map<String, HashMap<Integer, TreeMap<String, String>>> rootMap = new HashMap<>();
        // 新增部門
        rootMap.put("Engineering", new HashMap<>());

        // 部門內新增員工 ID 1001
        rootMap.get("Engineering").put(1001, new TreeMap<>());
        rootMap.get("Engineering").get(1001).put("name", "Alice");
        rootMap.get("Engineering").get(1001).put("position", "Software Engineer");
        rootMap.get("Engineering").get(1001).put("hireDate", "2023-05-15");

        // 在 Engineering 部門新增員工 ID 1002
        rootMap.get("Engineering").put(1002, new TreeMap<>());
        rootMap.get("Engineering").get(1002).put("name", "Bob");
        rootMap.get("Engineering").get(1002).put("position", "DevOps Engineer");
        rootMap.get("Engineering").get(1002).put("hireDate", "2022-08-20");

        // 讀取資料
        System.out.println(rootMap.get("Engineering").get(1001));
        System.out.println(rootMap.get("Engineering").get(1002));
    }

    static void TreeMapSort() {
        System.out.println(" 進入 TreeMapSort() ");
        // Integer 按照樹大小
        var map = new TreeMap<Integer, String>();
        map.put(3, "Apple");
        map.put(1, "Banana");
        map.put(2, "Cherry");
        map.put(4, "Orange");
        map.put(6, "Strawberry");
        map.put(5, "Pineapple");

        map.keySet().forEach(System.out::println);

        // String 按字符Unicode值比較
        var map2 = new TreeMap<String, String>();
        map2.put("three", "Apple");
        map2.put("one", "Banana");
        map2.put("two", "Cherry");
        map2.put("four", "Orange");
        map2.put("six", "Strawberry");
        map2.put("five", "Pineapple");

        map2.keySet().forEach(System.out::println);
        printUniqueUnicode(map2);

    }

    static void printUniqueUnicode(Map<String, String> map) {
        // Set 存不重複的字母
        Set<Character> uniqueChars = new HashSet<>();

        // 解析所有 key 提取字母
        for (String key : map.keySet()) {
            for (char c : key.toCharArray()) {
                uniqueChars.add(c);
            }
        }

        // 按 Unicode 排序
        List<Character> sortedChars = new ArrayList<>(uniqueChars);
        sortedChars.sort(Comparator.comparingInt(c -> (int) c));
        System.out.println("字母對應 Unicode 值：");
        for (char c: sortedChars) {
            System.out.println(c + ": " + (int) c);
        }
    }

    static void TreeMapforEach() {
        TreeMap<String, Map<String, String>> map1 = new TreeMap<>();
        map1.put("A", Map.of("key1", "value1", "key2", "value2"));
        map1.put("B", Map.of("key3", "value3"));
        map1.put("C", Map.of("key4", "value4", "key5", "value5"));

        List<String> keyList = new ArrayList<>(map1.keySet());

        // 遍歷1: 使用 keySet
        for (String key : keyList) {
            System.out.println("key: " + key);
            System.out.println("Value: " + map1.get(key));
        }

        // 遍歷2: 使用stream
        keyList.forEach(key -> {
                System.out.println("Key: " + key);
                System.out.println("Value:" + map1.get(key));
        });

    }
}
