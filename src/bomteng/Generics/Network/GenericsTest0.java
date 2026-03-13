package bomteng.Generics.Network;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 4個階段的泛型
 *
 * 來源: Gemini | 最基礎的容器到最進階的 PECS 邏輯
 */
public class GenericsTest0 {
    public static void main(String[] args) {
        // 第一階段 基礎泛型類別
        // stage1();

        // 第二階段 泛型方法(Generic Method)
        // 類別本身不是泛型的 方法也可獨立使用泛型
        //stage2();

        // 第三階段 限定型別
        // 限制泛型只能是某些特定類別子類
        // 此方式可以安全呼叫父類方法(doubleValue)
        // stage3();

        // 第四階段 進階 PECS 原則
        // Extends (Producer)：用來讀取，接受所有子類。
        // Super (Consumer)： 用來寫入，接受所有父類。
        stage4();

        // 泛型方法
        stage5();

    }

    static void stage1() {
        Box<String> nameBox = new Box<>();
        nameBox.set("程式夥伴");
        String name = nameBox.get();
        System.out.println("stage1 打印:" + name);
    }

    static void stage2() {
        Integer[] nums = {1, 2, 3, 4, 5};
        String[] strs = {"6", "5", "4", "3", "2", "1"};
        System.out.println("交換前：");
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(strs));

        System.out.println("交換後：");
        swapFirstAndLast(nums);
        swapFirstAndLast(strs);
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(strs));

    }

    // 泛型方法：將陣列第一個與最後一個元素交換
    static <T> void swapFirstAndLast(T[] array) {
        if (array == null || array.length < 2) return;

        T temp = array[0];
        array[0] = array[array.length - 1];
        array[array.length - 1] = temp;
    }

    static void stage3() {
        Calculator<Integer> intCalc = new Calculator<>(10);
        System.out.println("Integer:" + intCalc.square());

        Calculator<Double> douCalc = new Calculator<>(1.5222);
        System.out.println("Double:" + douCalc.square());

        Calculator<Long> longCalc = new Calculator<>(Long.MAX_VALUE/8);
        System.out.println("Long:"  + longCalc.square());
    }

    static void stage4() {
        List<Integer> intList = List.of(1, 2, 3, 4, 5);
        List<Number> numList = new ArrayList<>();
        System.out.println("移動前的資料內容:" + numList);
        copy(intList, numList);
        System.out.println("移動後的資料內容:" + numList);
    }

    /**
     * PECS 範例：從源頭(src)複製資料到目的地(dest)
     * src  參數用: ? extends T, 只要能從裡面讀出 T 即可 (Producer)
     * dest 參數用: ? super T, 只要這箱子能裝下 T 即可。
     *
     */
    public static <T> void copy(List<? extends T> src, List<? super T> dest) {
        for (T item : src) {
            dest.add(item);
        }
    }

    static void stage5() {
        String max = findMax("apple", "banana");
        System.out.println("最長單字：" + max);
    }

    public static <T extends Comparable<T>> T findMax(T a, T b) {
        return a.compareTo(b) > 0 ? a : b;
    }
}



