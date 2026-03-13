package bomteng.Arrays;

import java.util.Arrays;

public class ArraysTest0 {
    public static void main(String[] args) {
        int[] arr1 = new int[10];

        // for迴圈打印
        System.out.println(arr1.length);
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i]+"\t");
        }

        System.out.println();
        // Enhanced for-loop
        for (int element : arr1) {
            System.out.print(element+"\t");
        }

        System.out.println();
        // Arrays.toString 標準工具
        System.out.println(Arrays.toString(arr1));

        // 使用 Stream
        Arrays.stream(arr1).forEach(n -> System.out.print(n+" "));

    }
}
