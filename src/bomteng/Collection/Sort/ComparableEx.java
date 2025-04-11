package bomteng.Collection.Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Comparable 練習1
 */
public class ComparableEx {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 30));
        people.add(new Person("Bob", 25));
        people.add(new Person("Isaac", 34));
        people.add(new Person("Bob", 22));
        System.out.println("排序前：");
        System.out.println(people);
        // 直接排序
        Collections.sort(people);
        System.out.println("排序後：");
        System.out.println(people);
    }
}

// Person
class Person implements Comparable<Person> {

    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 自然排序：依照年齡
    @Override
    public int compareTo(Person other) {
        // 相等回傳0
        // 比較1
        //return Integer.compare(this.age, other.age);
        // 比較2 年齡相同 就比較姓
        int ageCompare = Integer.compare(this.age, other.age);
        return ageCompare != 0 ? ageCompare : this.name.compareTo(other.name);

    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
