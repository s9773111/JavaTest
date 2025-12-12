package bomteng.Lambda.Network;

import java.util.function.Predicate;

/**
 * Predicate (斷言型介面) - 邏輯組合應用
 *  可使用 and(), or(), negate() 建立複雜條件判斷
 * 114/12/12
 */

public class SAMPredicateEx {
    public static void main(String[] args) {
        // 1. 條件A: 數字是否大於 100
        Predicate<Integer> isLarge = n -> n > 100;

        // 2. 條件B: 數字是否為偶數
        Predicate<Integer> isEven = n -> n % 2 == 0;

        // 組合應用：
        // 3. 條件C: 大於100且偶數
        Predicate<Integer> isLargeAndEven = isLarge.and(isEven);
        System.out.println("--- 測試 AND 條件 大於100且偶數 ---");
        System.out.println("測試 102: " + isLargeAndEven.test(102));
        System.out.println("測試 98: " + isLargeAndEven.test(98));

        // 4. 條件D: 大於100 or 為偶數
        Predicate<Integer> isLargeOrEven = isLarge.or(isEven);
        System.out.println("\n--- 測試 OR 條件  大於100 or 為偶數---");
        System.out.println("測試 101: " + isLargeOrEven.test(101));
        System.out.println("測試 99: " + isLargeOrEven.test(99));
        System.out.println("測試 98: " + isLargeOrEven.test(98));

        // 5.條件E: 不大於100 (<=100)
        Predicate<Integer> isNotLarge = isLarge.negate();
        System.out.println("\n--- 測試 NEGATE 條件 不大於100 (<=100)---");
        System.out.println("測試 100: " + isNotLarge.test(100));
        System.out.println("測試 101: " + isNotLarge.test(101));
        System.out.println("測試 90: " + isNotLarge.test(90));
    }
}

