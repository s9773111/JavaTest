package bomteng.Collection.Sort;

import java.util.Arrays;
import java.util.List;

public class CompareEx {
    public static void main(String[] args) {
        List<String> keyList = Arrays.asList("10,Apple", "2,Banana", "30,Cherry");

        // 依據每個key數值部分進行排序
        // 1.使用 Integer.compare()會按數值大小排序
//        keyList.sort((keys1, keys2) -> {
//            String key1 = keys1.split(",")[0];
//            String key2 = keys2.split(",")[0];
//            return Integer.compare(Integer.parseInt(key1), Integer.parseInt(key2));
//        });

        // 2.使用String.compareTo | 用String的compareTo方法
        // 會按字母大小排序
        keyList.sort((keys1, keys2) -> keys1.split(",")[0].compareTo(keys2.split(",")[0]));


        System.out.println(keyList);
    }
}
