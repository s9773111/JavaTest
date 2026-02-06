package bomteng.Consumer;

import bomteng.book.Object.Employee;

import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * 115/1/28 Demo Consumer | accept
 * 源自 https://blog.csdn.net/guyue35/article/details/107536311
 */
public class TestConumser3 {

    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        String[] prefix = {"A", "B"};

        for (int i = 1; i <=10; i++)
            employees.add(new Employee(prefix[i%2] + i, i * 1000, 1987, 12,1+i));

        employees.forEach(new SalaryConsumer());
        employees.forEach(new NameConsumer());
    }

    //輸出需要繳稅的員工
    static class SalaryConsumer implements Consumer<Employee> {
        @Override
        public void accept(Employee employee) {
            if (employee.getSalary() > 5000) {
                System.out.println(employee.getName() + " 要繳稅了！");
            }
        }
    }

    //輸出名字開頭為A的員工
    static class NameConsumer implements Consumer<Employee> {

        @Override
        public void accept(Employee employee) {
            if (employee.getName().startsWith("A")) {
                System.out.println(employee.getName() + " salary is " + employee.getSalary());
            }
        }
    }
}
