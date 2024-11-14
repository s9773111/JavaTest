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

        // 映射 map, flatMap
        // map
        // flatMap
        example5();

        // reduce 縮減,把流縮減成一個值,能進階運算與操作
        example6();

        // collect
        // 依賴 java.util.stream.Collectors
        example7();

        // sorted
        example8();

        // 提取, 組合

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

        List<Person> personList = genPerson();

        List<String> filterList = personList.stream().filter(x->x.getSalary()>8000).map(Person::getName)
                        .collect(Collectors.toList());
        System.out.println("高於8000的員工姓名：" + filterList);
        System.out.println("-----------------------------------");
    }

    private static List<Person> genPerson() {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23, "male", "Taiwan"));
        personList.add(new Person("Jack", 7000, 25, "male", "New York"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 24, "female", "New York"));
        personList.add(new Person("Owen", 9500, 25, "male", "New York"));
        personList.add(new Person("Alisa", 7900, 26, "female", "New York"));
        return personList;
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

        List<Person> personList = genPerson();

        Optional<Person> maxSalary = personList.stream().max(Comparator.comparingInt(Person::getSalary));
        System.out.println("最大工資：" + maxSalary.get().getSalary());

        long count = listNum.stream().filter(x->x>6).count();
        System.out.println("list中大於6的元素個數：" + count);

        System.out.println("-----------------------------------");
    }

    static void example5() {
        System.out.println("--------------example5--------------");
        // 英文字串 改大寫 整數數組元素 +3
        String[] strArr = {"abcd", "bcdd", "defde", "fTrl", "isaacChang"};
        List<String> strList = Arrays.stream(strArr).map(String::toUpperCase).collect(Collectors.toList());

        List<Integer> intList = Arrays.asList(1,3,5,7,9,11,15);
        List<Integer> intListNew = intList.stream().map(x->x+3).collect(Collectors.toList());

        System.out.println("每個元素變大寫：" +strList);
        System.out.println("每個元素+3：" +intListNew);

        // 將員工薪資增加2000
        // 1 不改變原本集合方式
        List<Person> personList = genPerson();
        List<Person> personListNew = personList.stream().map(person->{
            Person personNew = new Person(person.getName(), 0,0,null,null);
            personNew.setSalary(person.getSalary() + 2000);
            return personNew;
        }).collect(Collectors.toList());
        System.out.println("薪資+1000 第一次改前：" + personList.get(0).getName() + "-->" + personList.get(0).getSalary());
        System.out.println("薪資+1000 第一次改後：" + personListNew.get(0).getName() + "-->" + personListNew.get(0).getSalary());

        // 2改變原來員工集合
        List<Person> personListNew2 = personList.stream().map(person -> {
            person.setSalary(person.getSalary() + 10000);
            return person;
        }).collect(Collectors.toList());
        System.out.println("薪資+1000 第二次改前：" + personList.get(0).getName() + "-->" + personList.get(0).getSalary());
        System.out.println("薪資+1000 第二次改後：" + personListNew2.get(0).getName() + "-->" + personListNew2.get(0).getSalary());

        // 兩個字串組 合併成一個字串組
        List<String> list = Arrays.asList("m,k,l,a", "1,3,5,7");
        List<String> listNew = list.stream().flatMap(s-> {
            //將每個元素轉成一個stream
            String[] split = s.split(",");
            Stream<String> s2 = Arrays.stream(split);
            return s2;
        }).collect(Collectors.toList());

        System.out.println("處理前的集合：" + list);
        System.out.println("處理後的集合：" + listNew);

        System.out.println("-----------------------------------");
    }

    static void example6() {
        System.out.println("--------------example6--------------");

        // 求Integer集合元素和、乘積和最大值
        List<Integer> list = Arrays.asList(1,3,2,7,8,11,5,15);
        Optional<Integer> sum = list.stream().reduce((x,y)->x+y);
        Optional<Integer> sum2 = list.stream().reduce(Integer::sum);
        Integer sum3 = list.stream().reduce(0, Integer::sum); // 0 代表的是「初始值」，也稱為「累加器的起始值」。

        // 算乘積
        Optional<Integer> product = list.stream().reduce((x,y)->x*y);
        // 算最大值1
        Optional<Integer> max = list.stream().reduce((x,y)->x>y ? x:y);
        // 算最大值2
        Integer max2 = list.stream().reduce(1, Integer::max);
        System.out.println("list求和:" + sum.get() + ", " + sum2.get() + ", " + sum3);
        System.out.println("list求積:" + product.get());
        System.out.println("list最大值:" + max.get() + "," + max2);


        // 求工資之和
        Optional<Integer> sumSalary = genPerson().stream().map(Person::getSalary).reduce(Integer::sum);
        Integer sumSalary2 = genPerson().stream().reduce(0, (sum4,p) -> sum4 += p.getSalary(), Integer::sum);

        // 求工資最高
        Integer maxSalary = genPerson().stream().reduce(0, (max3,p) -> max3 > p.getSalary() ? max3:p.getSalary(), Integer::max);
        System.out.println("工資之和：" + sumSalary.get() + "," + sumSalary2 );
        System.out.println("最高工資：" + maxSalary);

        System.out.println("-----------------------------------");
    }

    static void example7() {
        System.out.println("--------------example7--------------");
        // toList, toSet
        List<Integer> list = Arrays.asList(1,6,9,6,4,3,5,7,8,12,20,1,5,20);
        List<Integer> listNew = list.stream().filter(x-> x%2 == 0).collect(Collectors.toList());
        Set<Integer> set = list.stream().filter(x->x%2==0).collect(Collectors.toSet());
        System.out.println("toList:" + listNew);
        System.out.println("toSet:" + set);

        List<Person> personList = genPerson();
        Map<?, Person> map = personList.stream().filter(p->p.getSalary() > 8000)
                        .collect(Collectors.toMap(Person::getName, p->p));
        System.out.println("toMap:" + map);


        System.out.println("-----------------------------------");
    }


    static void example8() {
        System.out.println("--------------example8--------------");

        // 工資升序
        List<String> newList = genPerson()
                .stream()
                .sorted(Comparator.comparing(Person::getSalary))
                .map(Person::getName)
                .collect(Collectors.toList());
        System.out.println("按工資升序排序：" + newList);
        // 按工資倒序
        List<String> newList2 = genPerson()
                .stream()
                .sorted(Comparator.comparing(Person::getSalary).reversed())
                .map(Person::getName).collect(Collectors.toList());
        System.out.println("按工資倒序排序：" + newList2);

        // 先按工資再按年齡
        List<String> newList3 = genPerson()
                .stream()
                .sorted(Comparator.comparing(Person::getSalary).thenComparing(Person::getAge))
                .map(Person::getName).collect(Collectors.toList());
        System.out.println("按工資再按年齡升序排列：" + newList3);



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
