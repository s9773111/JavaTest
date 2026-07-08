package bomteng.Lambda.Network;

/**
 * Lambda 練習
 */
public class LambdaTest0 {
    public static void main(String[] args) {
        Calculator plus = (a, b) -> a + b;
        Calculator multi = (a, b) -> a * b;

        System.out.println("lambda 5,3 加法: " + plus.compute(5,3));
        System.out.println("lambda 2,8 乘法: " + multi.compute(2,8));
    }
}

@FunctionalInterface
interface Calculator {
    int compute(int a, int b);
}