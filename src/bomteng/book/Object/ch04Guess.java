package bomteng.book.Object;

import java.util.Scanner;

/**
 * java 標準類別 - 猜數字 Scanner
 */
public class ch04Guess {
    public static void main(String[] args) {
        var console = new Scanner(System.in);
        var number = (int) (Math.random()*10);
        var guess = -1;

        do {
            System.out.println("猜數字(0~9)");
            guess = console.nextInt(); // 取得數字；nextLine() 是取得整行
        } while(guess!=number);
    }
}
