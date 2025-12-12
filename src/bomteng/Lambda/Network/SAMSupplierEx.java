package bomteng.Lambda.Network;

import java.util.function.Supplier;

/**
 * Supplier (供給型介面) - 延遲計算應用
 *  封裝耗時的操作，直到真正需要時才執行
 * 114/12/12
 */
public class SAMSupplierEx {
    public static void main(String[] args) {
        // 情境1: 立即執行
        System.out.println("-- 情境1：立即執行 --");
        long start = System.currentTimeMillis(); //開始時間
        String result1 = expensiveDataCalculation();
        long end = System.currentTimeMillis(); //結束時間
        System.out.println("結果 1:" + result1);
        System.out.println("總耗時:" + (end - start) + "ms");

        System.out.println();

        // 情境2: 使用Supplier 延遲計算
        System.out.println("-- 情境2：使用 Supplier 延遲計算 --");
        // 僅定義如何獲取資料，尚未執行方法
        Supplier<String> lazyDataSupplier = SAMSupplierEx::expensiveDataCalculation;
        System.out.println("[APP] Supplier 已定義，但尚未調用 get()。");

        // 真正需要資料時
        System.out.println("[APP] 現在需要資料，調用 get() ...");
        String result2 = lazyDataSupplier.get();
        System.out.println("結果 2:" + result2);
    }

    // 模擬一個耗時資料計算 或 物件建立方法
    private static String expensiveDataCalculation() {
        System.out.println("[INFO] 正在執行耗時的計算...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
        return "Complex Result (Time: " + System.currentTimeMillis() + ")";
    }
}

