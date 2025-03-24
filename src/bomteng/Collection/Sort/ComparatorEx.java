package bomteng.Collection.Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorEx {
    public static void main(String[] args) {
        List<Person2> people = new ArrayList<>();
        people.add(new Person2("Alice", 30) );
        people.add(new Person2("Bob", 22));
        people.add(new Person2("Charlie", 35));
        people.add(new Person2("Frank", 19));

        // 年齡排序
        Comparator<Person2> ageComparator = Comparator.comparingInt(p->p.age);
        Collections.sort(people, ageComparator);
        System.out.println("按年齡排序： " + people);

        // 名字
        Comparator<Person2> nameComparator = Comparator.comparing(p->p.name);
        Collections.sort(people, nameComparator);
        System.out.println("按名字排序： " + people);
    }
}

// Person 類
class Person2 {
    String name;
    int age;

    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}