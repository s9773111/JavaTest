package bomteng.book.Object;

public class Wrap {
    public static void main(String[] args) {
        // Wrap int -127~128
        Integer a = Integer.valueOf(0);
        Integer b = Integer.valueOf(0);
        b = a; // b與a引用同一個物件
        a = 1; // a指向新的物件
        System.out.println(b);


    }
}
