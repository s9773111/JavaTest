package bomteng.optional.test;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 2026/2/5
 * Optional 與 Java 8 四大函數介面(SAM)的對應
 * Gemini | Java Optional: 對應到 Optional 的方法
 */
public class OptionalTest2 {
    public static void main(String[] args) {
        Optional<String> opt = Optional.of("Hello Java 8, I'm Isaac.");
        Optional<String> emptyOpt = Optional.empty();

        System.out.println("=== 1. Predicate(判斷) | filter ===");
        // 定義：輸入 String, 回傳 boolean
        Predicate<String> lengthCheck = s -> s.length() > 5;
        // 應用：過濾長度大於5的字串
        Optional<String> filtered = opt.filter(lengthCheck);
        System.out.println("Filter 結果：" + filtered.orElse("被過濾掉了"));

        System.out.println("\n=== 2. Function (轉換) | map ===");
        // 定義：輸入String, 回傳 Integer (轉換)
        Function<String, Integer> stringLenMapper = s -> s.length();
        // 應用：將字串轉為長度數字
        Optional<Integer> lengthOpt = opt.map(stringLenMapper);
        System.out.println("Map 結果 (長度): " + lengthOpt.orElse(0));

        System.out.println("\n=== 3. Consumer (消費) | ifPresent ===");
        // 定義：輸入 String, 沒有回傳值 (純執行)
        Consumer<String> printer = s -> System.out.println("Consumer 執行中: 抓到了值 -> " + s);
        // 應用：如果有值，就執行printer
        opt.ifPresent(printer);

        System.out.println("\n=== 4. Supplier (供應) | orElseGet ===");
        // 定義：不接受參數，回傳 String (懶載入/產生預設值)
        Supplier<String> defaultGenerator = () -> {
            System.out.println("Supplier 被呼叫了(產生預設值)...");
            return "Default Value";
        };
        // 應用：當 emptyOpt 為空時, 才呼叫 supplier
        String result = emptyOpt.orElseGet(defaultGenerator);
        System.out.println("OrElseGet 結果: " + result);
    }
}
