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
