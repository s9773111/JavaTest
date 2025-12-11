package bomteng.Lambda.Network;

import java.util.function.Function;

/**
 * Function (函數型介面) - 轉換與組合應用
 *  建立一個資料轉換管線
 * 114/12/11
 */
public class SAMFunctionEx {
    public static void main(String[] args) {
        // 第1個Function, 字串轉換為其長度
        Function<String, Integer> strToLength = String::length;

        // 第2個Function, 數字乘以2
        Function<Integer, Integer> doubler = i -> i * 2;

        // 第3個Function, 數字轉為字串
        Function<Integer, String> intToString = String::valueOf;

        Function<String, String> dataPipeline = strToLength.andThen(doubler).andThen(intToString);

        String input = "Functional";
        String result = dataPipeline.apply(input);

        System.out.println("原始字串： " + input);
        System.out.println("字串長度： " + strToLength.apply(input));
        System.out.println("長度乘以2 結果：" + result);

    }
}
