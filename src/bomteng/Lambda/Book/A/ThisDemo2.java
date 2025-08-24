package bomteng.Lambda.Book.A;

/**
 * 114/8/23 Ch12
 * 12.1 認識Lambda語法 4
 * Lambda 與 this, final
 *
 * 因為Hello類別包圍了 Lambda表示式
 * Lambda表示式參考了類別範疇中的名稱
 * 範例中定義了Hello類別toString()傳回 定義中的字串
 */
public class ThisDemo2 {

    public static void main(String[] args) {
        var hello = new Hello2();
        hello.r1.run();
        hello.r2.run();
    }
}

class Hello2 {
    // 此的this為Hello2實例
    Runnable r1 = () -> System.out.println(this);
    // 等同 Hello2.this.toString()
    Runnable r2 = () -> System.out.println(toString());

    public String toString() {
        return "Hello, world!";
    }
}
