package designpattern.FactoryMethod;

/**
 *
 * 模擬計算機程式
 *
 */
public class example1 {
    public static void main(String[] args) {
        try (java.util.Scanner scanner = new java.util.Scanner(System.in)) {
            System.out.print("輸入數字A：");
            double numberA = Double.parseDouble(scanner.nextLine());

            System.out.print("選擇運算符號：(+ - * / sqr):");
            String operate = scanner.nextLine();

            System.out.println("輸入數字B：");
            double numberB = Double.parseDouble(scanner.nextLine());

            Operation operation = OperationFactory.createOperate(operate);
            operation.setNumberA(numberA);
            operation.setNumberB(numberB);

            double result = operation.getResult();
            System.out.println("結果是：" + result);


        } catch (Exception ex) {
            System.out.println("輸入有錯:" + ex.getMessage());
        }
    }
}

