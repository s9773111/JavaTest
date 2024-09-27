package bomteng.practicse;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.IntStream;

/**
 * 113/9/26
 * 邏輯題目
 * 1. 9*9 乘法表
 * 2. 成績分類
 * 3. 猜數字
 * 4. 畫出星星
 * 5. 日期轉換
 */
public class Test_1 {
    public static void main(String[] args) {
        System.out.println("Test Day: 113/9/26");

//        System.out.println("Test1: 9*9乘法表");
//        test1();

//        System.out.println("Test2: classification");
//        test2();

//        System.out.println("Test3: Bulls and Cows");
//        test3();

//        System.out.println("Test4: Draw starts");
//        test4();

        System.out.println("Test5: Date adds days");
        test5();
    }

    // Test1: 9*9乘法表
    public static void test1(){
        for (int i=1; i<10; i++) {
            for (int j=1; j<10; j++) {
                System.out.print(i + " * " + j + " = " + (i * j) + "\t");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("使用 String.format() 來格式化輸出");
        for (int i=1; i<10; i++) {
            for (int j=1; j<10; j++) {
                int n = i * j;
                System.out.printf("%d * %d = %-2d\t", i, j, i * j);
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("使用 Stream, forEach ");
        IntStream.range(1,10).forEach(i -> {
            IntStream.range(1,10).forEach(j -> {
                System.out.print(i + " * " + j + " = " + (i * j) + "\t");
            });
            System.out.println();
        });
        System.out.println();
    }

    // Test2: classification
    public static void test2(){
        System.out.println("(test2 start)");
        Random random = new Random();
        int min = 0;
        int max = 100;

        //生成20個隨機數字
        for (int i=0; i<20; i++) {
            // random.nextInt(101) 會生成一個範圍在 0 到 100 的隨機數。
            int randomNumber = random.nextInt(max-min+1)+min;
            System.out.print(randomNumber + "\t");

            // 使用 / 10 方式來將分數對應到不同區間，無條件捨去
            switch (randomNumber/10) {
                case 10:    //100
                case 9:     //90-99
                    System.out.println("90-100: 甲");
                    break;
                case 8:     //80-89
                    System.out.println("80-89: 乙");
                    break;
                case 7:
                    System.out.println("70-79: 丙");
                    break;
                case 6:
                    System.out.println("60-69: 丁");
                    break;
                default :
                    System.out.println("< 60: 戊");
            }
        }
    }

    // Test3: Bulls and Cows
    public static void test3(){
        System.out.println("(test3 start)");

        // 1. 生成4位數 不重複
        String uniqueN = generateUniqueNumber();
        System.out.println("1. 生成4位數: " + uniqueN);

        // 2. 使用者輸入4位數
        Scanner scanner = new Scanner(System.in);
        String input = "";

        while (true) {
            System.out.print("請輸入4位數字");
            input = scanner.nextLine();

            // 檢查是否為4位數字
            if (isValidFourDigitNumber(input)) {
                // 3. 開始比對 計算幾A幾B
                int[] result = calculateAB(uniqueN, input);
                int A = result[0];
                int B = result[1];
                System.out.println("你答對狀態：" + A+"A"+B+"B");
                if (A == 4){
                    System.out.println("恭喜你猜中！答案是：" + uniqueN);
                    break;
                }
            } else {
                System.out.println("輸入無效，請輸入4位不重複的數字！");
            }
        }
    }

    // test3 1.生成4位數
    private static String generateUniqueNumber() {
        Random random = new Random();
        Set<Integer> uniqueDigits = new HashSet<Integer>();
        StringBuilder number = new StringBuilder();

        //持續生成 直到4個不重複數字
        while(uniqueDigits.size() < 4) {
            int nextDigit = random.nextInt(10); //生成0-9間的數字
            if (uniqueDigits.add(nextDigit)) { //確保不重複
                number.append(nextDigit);
            }
        }
        return number.toString();
    }

    // test3 2.檢查輸入數字是否符合
    private static boolean isValidFourDigitNumber(String input){
        // 先判斷長度
        if (input.length() != 4) {
            return false;
        }

        // 檢查每個字符是否都是數字 並且 不重複
        for (int i=0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!Character.isDigit(c)) {
                return false;
            }
            // 確保數字沒有重複
            // indexOf返回字符 c 在字串中第一次出現的位置索引。
            if (input.indexOf(c) != input.lastIndexOf(c)) {
                return false;
            }
        }
        return true;
    }

    // test3 3.計算幾A幾B
    private static int[] calculateAB(String ans, String guess) {
        int A = 0;
        int B = 0;
        boolean[] checkedAns = new boolean[4];  //A類 數字和位置都正確
        boolean[] checkedGuess = new boolean[4];    //B類 數字正確但位置錯誤

        // (1)計算A 位置相同數字相同
        for (int i=0; i<4; i++) {
            if (ans.charAt(i) == guess.charAt(i)) {
                A++;
                checkedAns[i] = true;
                checkedGuess[i] = true;
            }
        }

        // (2)計算B 位置不同數字相同
        for (int i=0; i<4; i++) {
            if (!checkedAns[i]) {   // 檢查還未匹配的答案位 （非屬於A類別)
                for (int j=0; j<4; j++) {
                    // 檢查還未匹配的猜測位，並且確認數字相同但位置不同
                    if (!checkedGuess[j] && ans.charAt(i) == guess.charAt(j)) {
                        B++;
                        checkedGuess[j] = true; //避免重複計算
                        break;
                    }
                }
            }
        }
        return new int[] {A, B};
    }

    // test4 4.畫出星星
    public static void test4() {
        System.out.print("1. 一條線：" + '\n');
        int stars = 9;
        for (int i=0;i<stars;i++) {
            System.out.println("*");
        }
        System.out.println();

        System.out.print("2. 三角型：");
        for (int i=0;i<stars;i++) {
            for (int j=0; j<i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();

        System.out.print("3. 三角型(反向)：");
        for (int i=0;i<stars;i++) {
            // 分兩段：
            // (1)先印空白:
            for (int j=stars; j>i; j--) {
                System.out.print(" ");
            }
            // (2)再印星星
            for (int k=0; k<i; k++){
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();

        System.out.print("4. 倒三角型：" + '\n');
        for (int i=stars; i>0; i--) {
            for (int j=0; j<i; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.print("5. 金字塔型-等腰：");
        for (int i=0; i<stars; i++){
            // (1)先印空格:
            // old:for (int j=0; j<(stars-i); j++) {
            for (int j=i; j<stars; j++) {
                System.out.print(" ");
            }
            // (2)再印星星
            for (int k=0; k<(2*i-1); k++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.print("6. 菱形："+'\n');
        // 輸出上半部分
        for (int i=1; i<=stars; i++) {
            // (1)先印空格:
            // old:for (int j=0; j<(stars-i); j++) {
            for (int j=i; j<stars; j++) {
                System.out.print(" ");
            }

            // (2)再印星星
            for (int k=1; k<= 2*i-1; k++) {
                System.out.print("*");
            }
            // 輸出每行星數
            System.out.print("  星數：" + (2*i-1));

            System.out.println();
        }
        //輸出下半部 (不含中間行)
        for (int i = stars -1 ; i > 0; i--) {
            // 空格
            for (int j=stars; j>i; j--) {
                System.out.print(" ");
            }
            // 輸出星號
            for (int j=1; j<=2*i-1; j++) {
                System.out.print("*");
            }
            // 輸出每行星數
            System.out.print("  星數：" + (2*i-1));
            System.out.println();
        }
    }

    // test5 5.日期轉字串
    public static void test5() {
        Date date = new Date();
        System.out.println(date.toString());

        SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd");
        System.out.println(f.format(date));

        //使用者輸入日期及天數
        Scanner scanner = new Scanner(System.in);
        String inputDate = "";
        int days = 0;

        // 1. 接收使用者輸入的日期和天數
        while (true) {
            System.out.print("請輸入日期（格式為：2020/08/31): ");
            inputDate = scanner.nextLine();

            // 解析日期
            SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
            try {
                // 2.將使用者字串變成日期
                Date userDate = df.parse(inputDate);
                System.out.print("請輸入天數： ");
                days = scanner.nextInt();

                // 3. 計算新日期
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(userDate);
                calendar.add(Calendar.DAY_OF_MONTH, days);

                // 4. 輸出結果
                Date newDate = calendar.getTime();
                System.out.println("新日期為：" + df.format(newDate));

                break;
            } catch (Exception e) {
                System.out.println("日期格式錯誤，請重新輸入。");
            }
        }
    }
}
