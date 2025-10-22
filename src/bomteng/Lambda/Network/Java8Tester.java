package bomteng.Lambda.Network;

/**
 * 114/8/23 練習Lambda 1
 *
 * 出處：https://blog.csdn.net/yitian_66/article/details/80652656
 * 關鍵字：策略模式、Lambda、SAM
 *
 *
 */
public class Java8Tester {
    public static void main(String args[]) {
        // 這就是 策略模式 (Strategy Pattern) 的味道：
        // operate 方法不管你要做加、減、乘、除，行為 由外部以 Lambda 注入。
        Java8Tester tester = new Java8Tester();

        // MathOperation 本身不是多個函式 是一個SAM
        // 它只是一個介面，規範「需要一個 (int,int)->int 的行為」。

        // 以下四個是不同的「MathOperation」實例 | 「策略物件」
        // 每個 Lambda 其實是建立了一個實作 MathOperation（SAM）的物件
        // (用 Lambda 建立的函式介面實例, 物件)

        // 宣告型態:明確標註型別

        // 宣告了四個 MathOperation 型別的變數 | 四個 Lambda 實作
        // 每個變數都用一個 Lambda 來「實作」這個 SAM 介面 的唯一抽象方法 operation(int,int)。
        // 可以宣告型態 int
        // 就是「MathOperation 的四個不同實例（策略）
        MathOperation addition = (int a, int b) -> a + b;
        // 不宣告型態:可省略型別
        MathOperation subtraction = (a, b) -> a - b;
        // 大括號中的返回內容
        MathOperation multiplication = (int a, int b) -> { return a * b; };
        // 沒有大括號及返回內容
        MathOperation division = (int a, int b) -> a / b;

        // 1.為什麼 tester 物件可以用 operate 方法？
        // 因為 operate 是 Java8Tester 類別的實例方法
        // 你建立了 Java8Tester tester = new Java8Tester();
        // 自然能呼叫 tester.operate(...)。

        // 2.operate(...) 是一個封裝、統一入口，方便未來擴充邏輯
        // 符合策略模式風格
        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
        // 也可以直接呼叫operation
        System.out.println("10 + 5 = " + addition.operation(10, 5));
        System.out.println("10 + 2 = " + tester.operate(10, 2, Integer::sum));


        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));

        System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));

        System.out.println("10 / 5 = " + tester.operate(10, 5, division));

        // 不用括號
        GreetingService greetService1 = message -> System.out.println("Hello " + message);
        // 使用括號
        GreetingService greetService2 = (message) -> System.out.println("Hello " + message);

        greetService1.sayMessage("Isaac");
        greetService2.sayMessage("Google");

    }

    interface GreetingService {
        void sayMessage(String message);
    }

    // SAM 介面(Single Abstract Method)
    // 只有一個抽象方法
    @FunctionalInterface
    interface MathOperation {
        int operation(int a, int b);
    }

    // operate 是 Java8Tester 類別的實例方法 | 實作「策略模式」
    // 第三個參數型態是 函式介面(SAM介面)
    // 能把 Lambda 傳進去是因為 operate 需要一個 函式式介面 MathOperation
    // Lambda 會被視為該介面的實作。
    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }

}
