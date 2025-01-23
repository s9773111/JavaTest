package bomteng.Collection.List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        System.out.println("第二個元素是：" + list.get(1));

        System.out.println();

        arrayListTest2();

        arrayListTest3();
    }

    static void arrayListTest2(){
        List<String> list = new ArrayList<>();
        list.add("This is ArrayList 1");
        list.add("This is ArrayList 2");
        list.add("This is ArrayList 3");

        // 使用 list interface 提供的方法 size
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }

        System.out.println();

        // for each
        for (String s : list)
            System.out.println(s);

        System.out.println();

        // iterator
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println();

        // lambda 表達式
        list.forEach(n-> System.out.println("Lambda Number: " + n));
    }

    static void arrayListTest3(){
        List<String> colors = List.of("Red", "Green", "Blue");
        System.out.println("Colors: " + colors);
    }
}
