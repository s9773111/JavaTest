package bomteng.book.Object;

import java.math.BigDecimal;

/**
 * java 標準類別 - 浮點數的精準度
 */
public class ch04DecimalDemo {
    public static void main(String[] args) {
        var a = 0.1;
        var b = 0.2;
        var c = 0.3;
        if ((a+b+c) == 0.6) {
            System.out.println("等於 0.6");
        } else {
            System.out.println("不等於 0.6");
        }

        var operand1 = new BigDecimal("1.4");
        var operand2 = new BigDecimal("0.8");
        var result = operand1.subtract(operand2);
        System.out.println(result);

        var op1 = new BigDecimal("0.1");
        var op2 = new BigDecimal("0.2");
        var op3 = new BigDecimal("0.3");;
        if (op1.add(op2).add(op3).equals(result)) {
            System.out.println("等於 0.6");
        } else {
            System.out.println("不等於 0.6");
        }
    }
}
