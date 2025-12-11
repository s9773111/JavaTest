package bomteng.Class;

/**
 * 114/12/11
 * 匿名類別 介紹
 */

public class AnonymousClass {
    public static void main(String[] args) {
        // 基本用法
        Ex1();

        // 產生匿名類別實現某介面或繼承某類別，立即創建實例
        Ex2();

    }

    public static void Ex1() {
        int x = 8;
        new Thread() { // ← 匿名類別，extends Thread
            @Override
            public void run() {
                System.out.println("Print X:" + x);
            }
        }.start();
    }

    public static void Ex2() {
        int a = 1;
        int b = 2;

        // 匿名內部類別
        // 實作 Comparator 這個 interface
        System.out.println("值：" + new Comparator() {
            @Override
            public int accept(int a1, int a2) {
                return a1 - a2;
            }
        }.accept(a, b));
    }

    public interface Comparator {
        int accept(int a1, int a2);
    }
}

