package bomteng.optional.test;

/**
 * 2026/2/3
 * 為何需要Optional
 * 參:https://jyi.tw/itironman2024/d10-java-optional-usage-and-best-practices/
 */
public class OptionalTest0NullPointer {
    public static void main(String[] args) {
        // 1. 訪問空對象
        String str = null;
        //System.out.println(str.length());

        // 2. 訪問空陣列
        int[] arr = null;
        //System.out.println(arr[0]);

        // 3. 呼叫空對象方法
        OptionalTest0NullPointer demo = null;
        //demo.someMethod();

        // 4. 拆箱時遇到 null
        Integer num = null;
        int value = num;

    }

    public void someMethod() {
        System.out.println("This is some method");
    }
}
