package bomteng.Collection;

public class LambdaTest {
    public static void main(String[] args) {
        IntegerFunction num = (Integer i) -> i*2;
        System.out.println(num.apply(5));
    }
}
