package bomteng.Object.Extends.inheritance;

import java.time.LocalDate;

public class Employee {

    private LocalDate hireDay;
    private String name;
    private double salary;


    public Employee(String name, double salary, int year, int month, int day) {
        this.name = name;
        this.salary = salary;
        this.hireDay = LocalDate.of(year, month, day);
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void raiseSalary(double byPercent){
        double raise = salary * byPercent /100;
        salary += raise;
    }
}
