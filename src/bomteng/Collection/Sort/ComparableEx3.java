package bomteng.Collection.Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparableEx3 {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("S105", "Banana"));
        students.add(new Student("S102", "Alex"));
        students.add(new Student("S108", "Isaac"));
        students.add(new Student("S103", "Chris"));

        // 使用內建的自然排序 comparable
        System.out.println("使用內建排序,依id");
        Collections.sort(students);
        System.out.println(students);

        // 使用 comparator 自定義
        byselfSort(students);
    }

    static void byselfSort(List<Student> students) {
        System.out.println("排序改為依姓名：");
        Collections.sort(students, Comparator.comparing(s -> s.name));
        for (Student stu : students) {
            System.out.println(stu);
        }
    }
}

class Student implements Comparable<Student> {
    String id;
    String name;

    @Override
    public int compareTo(Student student) {
        return this.id.compareTo(student.id);
    }

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
