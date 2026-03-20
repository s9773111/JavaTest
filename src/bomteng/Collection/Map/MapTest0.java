package bomteng.Collection.Map;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode HashMap | 350
 *
 * 常見方法:  put, getOrDefault(), containsKey, remove, size()
 *
 * 「撕下一張貼紙（一個 Entry）」
 */
public class MapTest0 {
    public static void main(String[] args) {
        // 經營水果店，來記錄 水果庫存
        // 建立 HashMap | key:水果名, value:剩餘數量
        Map<String, Integer> inventory = new HashMap<>();

        // 紀錄水果數量
        inventory.put("apple", 10);
        inventory.put("banana", 20);

        System.out.println("目前水果有:");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + ",剩餘:" + entry.getValue());
        }

        // 進貨
        System.out.println("進貨後:");

        inventory.put("apple", 30);
        inventory.put("banana", 40);

        System.out.println("進貨後水果:");
        inventory.forEach((fruit, count) -> {
            System.out.println(fruit + ",剩餘:" + count);
        });

        // getOrDefault(key, 預設值)
        int bananaC = inventory.getOrDefault("banana", 0);
        int watermelonC = inventory.getOrDefault("watermelon", 0);
        System.out.println("香蕉數量:" + bananaC);
        System.out.println("西瓜數量:" + watermelonC);

        // 檢查庫存是否存在 containsKey
        if (inventory.containsKey("apple")) {
            System.out.println("我們有賣蘋果唷!");
        }

        inventory.remove("banana");

        System.out.println("目前水果種類只剩下 " + inventory.size() + " 種");

    }


}
