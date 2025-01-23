package bomteng.Collection.List;

import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("apple");
        list.add("banan");
        list.add("cherry");

        System.out.println("原來list: "+list);

        list.addFirst("Orange");
        list.removeLast();
        list.addFirst("Lemon");

        System.out.println("調整後list: "+list);

    }
}
