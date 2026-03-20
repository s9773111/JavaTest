package bomteng.Generics.Network;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * 來源：https://medium.com/@maskwork77.dev/java-%E6%B3%9B%E5%BD%A2-generics-72ad74e03f90
 */
public class GenericsTest3 {

    public static void main(String[] args) {
        // 泛型類 & 泛型函式
        //Test1();

        // 靜態泛型方法
        //Test2();

        // 通配符1 ?
        //Test3();

        // 通配符2 ? extends T
        //Test4();

        // 通配符3 ? extends T 變數需以上界為主
        // 所有子類都繼承自該類, 可保證所有傳入類型都擁有該父類
        // 編譯器只能保證傳進來的類 需符Number 無法確定 Integer or Double
        Test5();

        // 通配符4 ? super T
        // super 接受某類的所有父類, 所以一定有Object
        // 以 super 宣告的泛型參數無法將該類以泛型宣告的變數以該類型取出
        // 只能以 Object 類型取出
        Test6();
    }

    static void Test1() {
        String[] strArr = {"1a", "2b", "3c", "4d", "5e"};
        Box<String> strBox = new Box<>();

        for (String s : strArr) {
            strBox.Add(s);
        }
        strBox.set("5"); // 可以用 因為此物件包含兩個屬性 item, value

        System.out.println(strBox.getByIndex(1));
        System.out.println(strBox.get());

        //第一種遍歷方式 建立size() + getByIndex -> 傳統for
        System.out.println("遍歷1 strBox item");
        for (int i = 0; i < strBox.size(); i++) {
            System.out.println("strBox item 第 " + i + "個元素是: " + strBox.getByIndex(i));
        }

        //第二種遍歷方式 建立getAllitems() -> 回傳整個清單
        // 遍歷箱子內容物
        for (String s : strBox.getAllItems()) {
            System.out.println("第二種遍歷, 內容物:" + s);
        }

        //第三種遍歷 Lambda
        strBox.getAllItems().forEach(s-> System.out.println("Lambda打印:" + s));
        strBox.getAllItems().forEach(System.out::println);

        //使用共用方法
        System.out.println("使用共用方法：" + Tools.getFirst(strBox.getAllItems()));

    }

    static void Test2() {
        String[] strArr = {"D", "E", "F", "G", "H"};
        Box<String> strBox = new Box<>(strArr);

        Integer[] intArr1 = {1, 2, 3, 4, 5, 6};
        Integer[] intArr2 = {1, 2, 3, 4};
        System.out.println(Box.whoLong(Arrays.asList(intArr1), Arrays.asList(intArr2)));
    }

    static void Test3() {
        // 使用 <T> 限定所有傳入參數都需要相同類型 -> 傳不同類型會報錯
        // 改用 <?> 可接受任何類型
        String[]  strArr = {"a", "b", "c", "d", "e", "f", "g", "h"};
        Box<String> strBox = new Box<>(strArr);

        Integer[] intArr2 = {1, 2, 3, 4, 5, 6};
        System.out.println("不同類型長度比較，較長的是：" + Box.whoLong2(strBox.getAllItems(), Arrays.asList(intArr2)));
    }

    static void Test4() {
        Integer[] intArr = {1, 2, 3, 4, 5, 6};
        Double[] doubleArr = {0.1, 0.2, 0.3, 0.4, 0.5, 0.6};

        // 比較List<Integer>與List<Double>
        System.out.println(NumberBox.whoLong((Arrays.asList(intArr)), Arrays.asList(doubleArr)));
    }

    static void Test5() {
        // 編譯器只能保證傳進來的類 需符合 Number
        // 無法確定是 Integer or Double
        //Box2<Integer> box = new Box2<>(1, 2);
        Box2<Number> box = new Box2<>(1,3.0);
        System.out.println(add(box));

    }

    static Integer add(Box2<? extends Number> b1) {
        Number i = b1.getOne();

        //java: incompatible types: capture#1 of ? extends
        // java.lang.Number cannot be converted to java.lang.Integer
        //Integer j = b1.getTwo();
        // 這段程式碼就變得很「自私」
        // 它只能服務 Box<Integer>
        // 遇到 Box<Double> 就會直接罷工（報錯）。
        //Integer j = (Integer) b1.getTwo();

        // 如果改用Number | 最好就是用最高父類 此就可以。
        Number j = b1.getTwo();

        var result = i.intValue() + j.intValue();

        return result;
    }

    static void Test6() {
        // 練習1. 靜態方法參數使用super
        Box2<Integer> box = new Box2<>(1, 2);
        System.out.println("兩者是否相同：" + compare(box));

        // 練習2.
        setThree(box, 100);
        Integer num = box.getThree();
        System.out.println("數值是: " + num);


    }

    static boolean compare(Box2<? super Integer> b1) {
        // 參數是super 取得類別用Object | 只能保證是Object
        Object i = b1.getOne();
        Object j = b1.getTwo();

        return i.equals(j);
    }

    static void setThree(Box2<? super Integer> b1, int n){
        b1.setThree(n);
    }

}


class Tools {
    // 泛型靜態函式
    public static <T> T getFirst(List<T> o) {
        if (o.get(0) != null){
            return o.get(0);
        }
        return null;
    }
}

// 限制創建為 Number 子類 -> 限制泛型類別只能是 N 的子類
class NumberBox<T extends Number> {
    private ArrayList<T> list =new ArrayList<>();

    public NumberBox(T[] item) {
        list.addAll(Arrays.asList(item));
    }

    public ArrayList<T> getList() {
        return list;
    }

    // 只能接受 Number 子類
    public static <K> List<?> whoLong(List<? extends Number> o1, List<? extends Number> o2) {
        if (o1.size() > o2.size()) {
            return o1;
        } else {
            return o2;
        }
    }
}

class Box2<T> {
    private T one;
    private T two;
    private T three;

    public Box2(T i, T j) {
        this.one = i;
        this.two = j;
    }

    public T getThree() {
        return this.three;
    }
    public void setThree(T t) {
        this.three = t;
    }

    public T getOne() {
        return this.one;
    }

    public T getTwo() {
        return this.two;
    }
}
