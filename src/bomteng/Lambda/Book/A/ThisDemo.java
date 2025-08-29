package bomteng.Lambda.Book.A;

/**
 * 114/8/23 Ch12
 * 12.1 認識Lambda語法 4-1
 * Lambda 與 this, final
 *
 * 此匿名類別建立的實例，也是Runnabl實例
 * 因為沒有定義Runnable的toString()，顯示結果是
 * Object 預設的toString()傳回字串
 *
 * this：在匿名類別中指向匿名類別本身；在 Lambda 中指向外層物件。
 */
public class ThisDemo {

    public static void main(String[] args) {
        var hello = new Hello();
        hello.r1.run();
        hello.r2.run();
        hello.r3.run();

    }

}

class Hello {
    Runnable r1 = new Runnable() {
        public void run() {
            // 匿名類別自己的this
            System.out.println(this);
        }
    };

    Runnable r2 = new Runnable() {
        public void run() {
            // 等同 this.toString() 自己的
            System.out.println(toString());
        }
    };

    // 若要拿到外層 this
    Runnable r3 = new Runnable() {
        public void run() {
            System.out.println(Hello.this.toString());
        }
    };


    public String toString() {
        return "Hello, world!";
    }
}