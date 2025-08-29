package bomteng.Lambda.Network;

import java.util.function.ToDoubleFunction;

/**
 * 認識lambda語法
 *   (parameter list) -> lambda body
 *   ToDoubleFunction<T>：輸入 T，回傳 double
 *
 */
public class LambdaTest1 {

    public static void main(String[] args) {
        MyInterface ref;
        ref = () -> 1.61803;
        System.out.println("Value of Golden Ratio:" + ref.getGoldenValue());

        ToDoubleFunction<String> length = x->x.length();
        System.out.println(length.applyAsDouble("Isaac"));
    }
}

@FunctionalInterface
interface MyInterface {
    double getGoldenValue();
}

