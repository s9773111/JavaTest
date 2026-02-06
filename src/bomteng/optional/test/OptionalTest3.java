package bomteng.optional.test;


import java.util.Optional;

/**
 * 2026/2/6
 * Optional orElseThrow
 * Gemini | 用來處理絕對不能是空值的情境，會直接拋出異常 | Supplier
 */
public class OptionalTest3 {
    public static void main(String[] args) {
        Optional<String> userOpt = findUserById("999");

        System.out.println("準備查詢使用者...");

        // 1. 標準寫法：使用 Lambda 提供Exception
        // 只有當 userOpt 為 empty 時，才會執行 -> new IllegalArgumentException
        try {
            String user = userOpt.orElseThrow(() -> new IllegalArgumentException("找不到該使用者!"));
            System.out.println("找到使用者: " + user); // 此行不會執行到
        } catch (Exception e) {
            System.out.println(">> 捕獲異常 1: " + e.getMessage());
        }

        System.out.println("----------------------");

        // 2.簡潔寫法：方法參考(Method Reference)
        // 適合用在 Exception 建構子不需要參數時
        try {
            String user = userOpt.orElseThrow(UserNotFoundException::new);
        } catch (Exception e) {
            System.out.println(">> 捕獲異常 2: " + e.getClass().getSimpleName());
        }

        System.out.println("----------------------");

        // 3. java 10版本：不傳參數
        // 預設會拋出 java.util.NoSuchElementException
        try {
            String user = userOpt.orElseThrow();
        } catch (Exception e) {
            System.out.println(">> 捕獲異常 3: " + e);
        }
    }

    // 模擬資料庫查詢
    static Optional<String> findUserById(String id) {
        return Optional.empty(); // 模擬找不到資料
    }

    // 自定義異常
    static class UserNotFoundException extends RuntimeException {
        public UserNotFoundException() {
            super("User Not Found Custom Error");
        }
    }
}
