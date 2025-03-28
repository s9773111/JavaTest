package bomteng.Collection.Set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Set
 *
 * 內容不重複的Set
 */
public class WordCount {
    public static void main(String[] args) {
        var console = new Scanner(System.in);
        System.out.print("請輸入英文：");
        var words = tokenSet(console.nextLine());
        System.out.printf("不重複單字有 %d 個：%s%n", words.size(), words);
    }

    static Set tokenSet(String line) {
        var tokens = line.split(" ");
        return new HashSet(Arrays.asList(tokens));
    }
}
