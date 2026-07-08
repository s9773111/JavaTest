package bomteng.Class;

/**
 * 115/7/8
 * 匿名類別 介紹
 */
public class AnonymousClass2 {
    public static void main(String[] args) {
        Ex1();

        Ex2();
    }

    static void Ex1() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("我是匿名內部類別 執行中...");
            }
        });
        t.start();
    }

    static void Ex2() {
        Dummy d = new Dummy() {
            // 一次性屬性，只有這 new 出的物件才有
            // 那為啥要？
            // A: 1.為了給「匿名內部類別自己內部的方法」當成狀態（State）來使用。
            // 2.暫時存放「初始化」的資料
            int age = 18;
        };

        // 使用 var 接收此變數
        var d2 = new Dummy() {
            int age = 18;
        };
        System.out.println("這是Ex2 : " + d2.age);

    }
}

// 普通類別
class Dummy {

}