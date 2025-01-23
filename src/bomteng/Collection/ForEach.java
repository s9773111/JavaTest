package bomteng.Collection;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;

/**
 *
 * Iterable & Iterator
 * 增強式for迴圈
 */
public class ForEach {
    public static void main(String[] args) {
        // 返回固定大小 不可添加或刪除元素
        // 若需要可變動的：
        // var names = new ArrayList<>(Arrays.asList("Justin", "Monica", "Irene"));
        var names = Arrays.asList("Justin", "Monica", "Irene");
        forEach(names);
        forEach(new HashSet(names));
        forEach(new ArrayDeque(names));
    }

    static void forEach(Iterable iterable) {
        for(var obj : iterable) {
            System.out.println(obj);
        }
        System.out.println();
    }
}
