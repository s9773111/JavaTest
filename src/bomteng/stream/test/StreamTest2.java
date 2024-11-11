package bomteng.stream.test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 113/11/11
 * stream
 * 參 https://blog.csdn.net/weixin_42039228/article/details/123734269
 */
public class StreamTest2 {

    public static void main(String[] args) {
        // 元素遍歷與匹配 foreach/find/match
        example1();

        // filter 篩選 集合中大於7的元素
        example2();
        // 篩選出工資高於8000的員工姓名，形成新的集合
        example3();

        // 聚合 Max, Min, Count
        example4();

    }

    // 格式方法
    static void example_format() {
        System.out.println("--------------exampleX--------------");

        System.out.println("-----------------------------------");
    }

    static void example1() {
        System.out.println("--------------example1--------------");
        List<Integer> list = Arrays.asList(7,10,6,9,3,8,2,1,4,5);

        // 遍歷輸出 符合條件的元素
        System.out.println("list 原值:" +list);
        // list.forEach(a-> System.out.print(a+"\t"));
        System.out.println("輸出超過6的值");
        list.stream().filter(x->x>6).forEach(System.out::println);

        // 匹配第一個
        Optional<Integer> findFirst = list.stream().filter(x->x>3).findFirst();
        // 匹配任意值 適用parallelStream()
        Optional<Integer> findAny = list.parallelStream().filter(x->x>3).findAny();
        // 判斷是否包含特定元素
        boolean anyMatch = list.stream().anyMatch(x->x>6);
        System.out.println("匹配第一個值:" + findFirst.get());
        System.out.println("匹配任意一值:" + findFirst.get());
        System.out.println("是否存在大於6的值:" + anyMatch);

        System.out.println("-----------------------------------");
    }

    static void example2() {
        System.out.println("--------------example2--------------");

        List<Integer> list = Arrays.asList(6,7,5,8,1,9,4,3,10);
        System.out.println("原值：" + list);
        Stream<Integer> stream = list.stream();
        stream.filter(x->x>7).forEach(System.out::println);

        System.out.println("-----------------------------------");
    }

    static void example3() {
        System.out.println("--------------example3--------------");

        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23, "male", "Taiwan"));
        personList.add(new Person("Jack", 7000, 25, "male", "New York"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 24, "female", "New York"));
        personList.add(new Person("Owen", 9500, 25, "male", "New York"));
        personList.add(new Person("Alisa", 7900, 26, "female", "New York"));

        List<String> filterList = personList.stream().filter(x->x.getSalary()>8000).map(Person::getName)
                        .collect(Collectors.toList());
        System.out.println("高於8000的員工姓名：" + filterList);
        System.out.println("-----------------------------------");
    }

    static void example4() {
        System.out.println("--------------example4--------------");

        List<String> list = Arrays.asList("adm", "admmt", "pot", "xbangd", "weougjgsd", "isaacchang");
        Optional<String> max = list.stream().max(Comparator.comparing(String::length));
        System.out.println("最長的字串：" + max.get());

        // 獲取大的數字
        List<Integer> listNum = Arrays.asList(6,7,5,8,1,9,4,3,10);
        // 自然排序 | Comparator.naturalOrder()
        Optional<Integer> maxNum = listNum.stream().max(Integer::compareTo);
        // 自定義排序
        Optional<Integer> maxNum2 = listNum.stream().max(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println("自然排序最大值：" + maxNum.get());
        System.out.println("自定排序最大值：" + maxNum2.get());

        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23, "male", "Taiwan"));
        personList.add(new Person("Jack", 7000, 25, "male", "New York"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 24, "female", "New York"));
        personList.add(new Person("Owen", 9500, 25, "male", "New York"));
        personList.add(new Person("Alisa", 7900, 26, "female", "New York"));

        Optional<Person> maxSalary = personList.stream().max(Comparator.comparingInt(Person::getSalary));
        System.out.println("最大工資：" + maxSalary.get().getSalary());

        long count = listNum.stream().filter(x->x>6).count();
        System.out.println("list中大於6的元素個數：" + count);

        System.out.println("-----------------------------------");
    }



    static class Person{
        private String name;
        private int salary;
        private int age;
        private String sex;
        private String area;

        public Person(String name, int salary, int age, String sex, String area) {
            this.name = name;
            this.salary = salary;
            this.age = age;
            this.sex = sex;
            this.area = area;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getSalary() {
            return salary;
        }

        public void setSalary(int salary) {
            this.salary = salary;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }
    }
}
