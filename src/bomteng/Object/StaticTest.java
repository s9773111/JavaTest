package bomteng.Object;

/**
 * 113/11/9
 * 練習：類別中的static
 */
public class StaticTest {
    public static void main(String[] args) {
        // fill the satff array with three Employee objects
        var staff = new Employee[3];
        staff[0] = new Employee("Tom", 40000);
        staff[1] = new Employee("Isaac", 55000);
        staff[2] = new Employee("Andy", 66000);

        for (Employee e: staff) {
            e.setId();
            System.out.println("name =" + e.getName() + ",id=" +e.getId() + ",salary=" +e.getSalary());
        }

        int n = Employee.getNextId(); //calls static method
        System.out.println("Next available id = " +n);
    }


}

class Employee {
    private static int nextId = 1;
    private int id;
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.id = 0;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId() {
        this.id = nextId;
        nextId++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public static int getNextId() {
        return nextId;
    }

    // unit test
    public static void main(String[] args) {
        var e = new Employee("Harry", 5000);
        System.out.println(e.getName() + " " + e.getSalary());
    }

}
