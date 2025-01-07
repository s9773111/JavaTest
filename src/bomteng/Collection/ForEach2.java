package bomteng.Collection;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;

public class ForEach2 {
    public static void main(String[] args) {
        var names = Arrays.asList("Justin", "Monica", "Irene");
        names.forEach(name -> System.out.println(name));
        System.out.println();
        new HashSet(names).forEach(name -> System.out.println(name));
        System.out.println();
        new ArrayDeque(names).forEach(name -> System.out.println(name));
    }
}
