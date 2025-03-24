package bomteng.Collection.Map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Map
 * 1. TreeMap
 * 2. method: values(), get(), putIfAbsent
 *
 */
public class MapTest1 {

    public static void main(String[] args) {
        forEachTreeMap1();
        forEachTreeMap2(); // 按照順序
        forEachTreeMap3(); // 不同的遍歷方法


    }

    static void forEachTreeMap1() {
        TreeMap<String, Map<String, String>> treeMap = new TreeMap<>();

        String key = "A, 100";
        treeMap.putIfAbsent(key, new HashMap<>());
        // HashMap 沒有維持插入順序。
        Map<String, String> value = treeMap.get(key);
        value.put("age1", "100");
        value.put("age2", "200");
        value.put("age3", "300");
        value.put("age4", "400");
        value.put("age5", "500");

        System.out.println("value 的 value");
        // 遍歷
        for (String v : value.values()) {
            System.out.println("value: " + v);
        }

        System.out.println("value 的 key");
        for (String k : value.keySet()) {
            System.out.println("key: " + k);
        }
    }

    static void forEachTreeMap2() {
        TreeMap<String, Map<String, String>> treeMap = new TreeMap<>();

        String key = "A, 100";
        treeMap.putIfAbsent(key, new LinkedHashMap<>());
        // HashMap 沒有維持插入順序。
        Map<String, String> value = treeMap.get(key);
        value.put("age5", "500");
        value.put("age6", "600");
        value.put("age7", "700");
        value.put("age8", "800");
        value.put("age9", "900");

        System.out.println("value 的 value");
        // 遍歷
        for (String v : value.values()) {
            System.out.println("value: " + v);
        }

        System.out.println("value 的 key");
        for (String k : value.keySet()) {
            System.out.println("key: " + k);
        }
    }

    static void forEachTreeMap3() {
        TreeMap<String, Map<String, String>> treeMap = new TreeMap<>();

        String key = "A, 100";
        treeMap.putIfAbsent(key, new HashMap<>());
        // HashMap 沒有維持插入順序。
        Map<String, String> value = treeMap.get(key);
        value.put("age10", "1000");
        value.put("age11", "1100");
        value.put("age12", "1200");
        value.put("age13", "1300");
        value.put("age14", "1400");

        System.out.println("遍歷1:");
        // 遍歷1
        value.forEach((k,v)->System.out.println("Key: " + k + ", Value: " +v));

        System.out.println("遍歷2:");
        // 遍歷2
        for(Map.Entry<String, String> entry : value.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }

}
