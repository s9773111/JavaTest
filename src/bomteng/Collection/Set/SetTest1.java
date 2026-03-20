package bomteng.Collection.Set;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 遇見HashSet | 2215
 */
public class SetTest1 {
    public static void main(String[] args) {
        test1();
    }

    static  void test1() {
        // 1. 建立
        Set<Integer> bag = new HashSet<>();
        System.out.println(bag);

        // 2. 新增數字
        bag.add(1);
        bag.add(2);
        bag.add(3);
        bag.add(1);
        System.out.println("新增後：" + bag);

        // 3. 檢查數字使否存在
        boolean hasNum = bag.contains(2);
        boolean hasNum2 = bag.contains(3);
        System.out.println("bag內有2數值嗎？" + hasNum +", bag內有3數值嗎?" + hasNum2);

        // 4. 取得裡面數量
        System.out.println("bag裝有" + bag.size() + "個數值");
    }
}
