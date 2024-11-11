package bomteng.Object.Extends.inheritance;

/**
 * 113/11/9
 * 練習：繼承1
 * file: Employee, Manager
 * 類別與物件
 */
public class ManagerTest {
    public static void main(String[] args) {
        var boss = new Manager("Tonny" , 80000, 1987, 12,15);

        var staff = new Employee[3];

        staff[0] = boss;
        staff[1] = new Employee("Harry Potter", 50000, 1994, 10, 1);
        staff[2] = new Employee("Andy Tsia", 60000, 1998, 1, 11);

        for (Employee e:staff) {
            System.out.println("name:" + e.getName() + ", Salary:" + e.getSalary());
        }
    }
}
