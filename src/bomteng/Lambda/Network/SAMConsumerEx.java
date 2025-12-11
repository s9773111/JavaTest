package bomteng.Lambda.Network;

import java.util.function.Consumer;

/**
 * Consumer (消費型介面) - 組合應用
 * 114/12/11
 */
public class SAMConsumerEx {
    public static void main(String[] args) {
        // 第1個Consumer 將數字字串轉換為大寫並列印
        Consumer<String> upperCasePrinter = s -> {
           String upper = s.toUpperCase();
            System.out.println("步驟1(大寫): " + upper);
        };

        // 第2個Consumer: 計算字串長度並打印
        Consumer<String> lengthPrinter = s -> {
            int length = s.length();
            System.out.println("步驟2(長度): " + length);
        };

        // 使用 andThen 組合兩個操作
        Consumer<String> combinedTask = upperCasePrinter.andThen(lengthPrinter);
        System.out.println("--- 執行組合任務 (輸入: 'hello java') ---");
        combinedTask.accept("hello java");
    }
}
