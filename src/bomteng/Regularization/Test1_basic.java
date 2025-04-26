package bomteng.Regularization;

// 正則化練習1 - basic
public class Test1_basic {
    public static void main(String[] args) {
        // 驗證數字
        String str1 = "123456";
        String str2 = "123abc";
        System.out.println("str1 是否為數字：" + str1.matches("\\d+"));
        System.out.println("str2 是否為數字：" + str2.matches("\\d+"));

        // 驗證email
        String mail1 = "test@example.com";
        boolean isValid = mail1.matches("[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}");
    }
}
