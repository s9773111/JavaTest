package bomteng.Generics.Network;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  認識共變性(Covariance), 通配符(wildcard)
 *
 *  來源:Gemini
 */

public class GenericsTest2 {
    public static void main(String[] args) {
        // 型別安全, 泛型不能隨便繼承
        // 物件都是用 引用Reference | 共用記憶體位置 淺拷貝
        //Test1();

        // 認識共變性(Covariance)
        //Test2();

        // 泛型限制
        Test3();
    }

    static void Test1(){
        List<Integer> appleBox = new ArrayList<>();
        appleBox.add(10);

        // java: incompatible types
        // List<Number> fruitBox = appleBox; // 基本上編譯不為過
        // fruitBox.add(3.14);
        // Integer firstAppleBox = appleBox.get(0);
    }

    static void Test2() {
        // 整數清單
        List<Integer> intList = Arrays.asList(1,2,3);

        // 浮點數
        List<Double> doubleList = Arrays.asList(1.1, 2.2, 3.3);

        // 長整數
        List<Long> longList = Arrays.asList(100L, 200L);

        System.out.println("處理 Integer");
        printAndSum(intList);

        System.out.println("\n 處理 Double");
        printAndSum(doubleList);

        System.out.println("\n 處理 Long");
        printAndSum(longList);
    }

    // 通配符 ? extends Number 接收任何數字型態 List
    // 可讀取 | 資料來源 Producer
    // 編譯器保證 List<? extends Number> 其來源一定是 Number 或其子類。
    // List<?> 無界通配符，裡面一定是Object
    public static void printAndSum(List<? extends Number> list) {
        double sum = 0;
        for (Number n : list) {
            System.out.println(n + " ");
            // 統一轉為double 進行運算
            sum += n.doubleValue();
        }
        System.out.println("\n 總和為:" + sum);
    }

    static void Test3() {
        List<String> strList = new ArrayList<>();
        List<Integer> intList = new ArrayList<>();
        System.out.println(strList.getClass() == intList.getClass());
    }
}
