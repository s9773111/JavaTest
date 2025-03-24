package bomteng.Collection.Sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Sort3 {
    public static void main(String[] args) {
        var words = Arrays.asList("B", "X", "A", "M", "F", "W", "O");

        // 第一種
//        Collections.sort(words, new StringComparator());
//        System.out.println(words);
//        Collections.sort(words);
//        System.out.println(words);

        // 第二種
        Collections.sort(words, (s1,s2) -> s1.compareTo(s2));
        System.out.println(words);

        // 第三種
        words.sort((s1, s2) -> s1.compareTo(s2));

    }

}

// 第一種的
class StringComparator implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
        return -s1.compareTo(s2);
    }
}
