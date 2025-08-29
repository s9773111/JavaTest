package bomteng.Lambda.Book.A;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 114/8/23 Ch12
 * 12.1 認識Lambda語法 1
 *
 */
public class LambdaDemo {
    public static void main(String[] args) {
        // 使用匿名類別的方式
        oldfunction();
        System.out.println();
        oldfunction2();
        System.out.println();


        lambdatest();  // 使用表達式
        System.out.println();

        lambdatest2(); // 匿名內部類別
        System.out.println();

        lambdatest3();
        System.out.println();

    }



    public static void oldfunction() {
        String[] names = {"Justin", "caterpillar", "Bush", "Alice", "Isaac"};
        Arrays.sort(names, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
        System.out.println(Arrays.toString(names));
    }

    public static void oldfunction2() {
        // 使用匿名類別
        Comparator<String> byLength = new Comparator<String> () {
            public int compare(String n1, String n2){
                return n1.length() - n2.length();
            }
        };

        String[] names = {"Justin", "caterpillar", "Bush", "Alice", "Isaac"};
        Arrays.sort(names, byLength);

        System.out.println(Arrays.toString(names));
    }

    public static void lambdatest() {
        String[] names = {"Justin", "caterpillar", "Bush", "Apple", "Faker", "Isaac"};
        Arrays.sort(names, (n1, n2)->n1.length() - n2.length());
        System.out.println(Arrays.toString(names));
    }

    public static void lambdatest2() {
        // 使用匿名類別
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World, Isaac");
            }
        }).start();

        // 使用lambda 獲得Runnable介面物件
        new Thread( () -> System.out.println("Hello World, Isaac")).start();


        // 使用匿名類別
        Runnable race1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World, Isaac2");

            }
        };
        // 使用 lambda 直接獲取介面物件
        Runnable race2 = () -> System.out.println("Hello World, Isaac2");

        race1.run();
        race2.run();
    }

    public static void lambdatest3() {
        String[] players = {"isaac", "faker", "immortal", "pupil", "venomous", "apple"};
        String[] original = players.clone(); //複製一份原本順序

        // 使用匿名內部類別 依據內建排序
        Arrays.sort(players, new Comparator<String> () {
           @Override
           public int compare(String s1, String s2) {
               return (s1.compareTo(s2));
           }
        });
        System.out.println("使用匿名類別排序後："+ Arrays.toString(players));

        // 還原成原本順序
        System.arraycopy(original, 0, players, 0, players.length);
        System.out.println("還原後："+ Arrays.toString(players));

        // 使用 lambda 排序
        Arrays.sort(players, (String s1, String s2) -> s1.compareTo(s2));
        System.out.println("使用lambda排序後："+ Arrays.toString(players));

        // 還原
        System.arraycopy(original, 0, players, 0, players.length);

        // 使用匿名類別依照最後一個字母排序
        Arrays.sort(players, new Comparator<String> () {
            @Override
            public int compare(String s1, String s2) {
                return (s1.charAt(s1.length() - 1 ) - s2.charAt(s2.length() - 1));
            }
        });
        System.out.println("匿名類別比最後字排序後："+ Arrays.toString(players));

        System.arraycopy(original, 0, players, 0, players.length);
        System.out.println("還原後："+ Arrays.toString(players));

        // 使用 Lambda 一句最後一字排序
        Arrays.sort(players, (String s1, String s2) -> s1.charAt(s1.length() - 1) - s2.charAt(s2.length() - 1));
        System.out.println("使用lambda排序後：" + Arrays.toString(players));
    }
}
