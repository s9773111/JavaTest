package bomteng.Function;

import bomteng.book.Object.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * 115/1/28 Demo Function | apply
 * 源自 https://blog.csdn.net/guyue35/article/details/107536311
 */

public class TestFunction {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        String[] prefix = {"C", "D"};

        for (int i = 1; i <=10; i++)
            employees.add(new Employee(prefix[i%2] + i, i * 1000, 1987, 12,1+i));


        int[] expense = ListToArray(employees, new EmployeeToExpense());
        int[] incomes = ListToArray(employees, new EmployeeToIncome());
        System.out.println("公司稅額=" + (sum(expense) - sum(incomes)) + "元");

    }

    // 公司支出 假設公積金為薪水10%
    static class EmployeeToExpense implements Function<Employee, Integer> {
        @Override
        public Integer apply(Employee employee) {
            return Double.valueOf(employee.getSalary() * (1+0.1)).intValue();
        }
    }

    //員工實際領到薪水
    static class EmployeeToIncome implements Function<Employee, Integer> {
        @Override
        public Integer apply(Employee employee) {
            return Double.valueOf(employee.getSalary() * (1-0.1)).intValue();
        }
    }

    private static int[] ListToArray(List<Employee> list, Function<Employee, Integer> function) {
        int[] ints = new int[list.size()];
        for (int i=0; i < ints.length; i++)
            ints[i] = function.apply(list.get(i));
        return ints;
    }

    private static int sum(int[] salarys) {
        int sum = 0;
        for (int i=0; i < salarys.length; i++)
            sum += salarys[i];
        return sum;
    }

}
