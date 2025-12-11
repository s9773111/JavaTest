package bomteng.Collection.Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorEx2 {
    public static void main(String[] args) {
        User user1 = new User("Andy", 25, true);
        User user2 = new User("Isaac", 36, true);
        User user3 = new User("Ella", 33, false);
        User user4 = new User("Jay", 21, true);

        List<User> list = new ArrayList<User>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);

        Collections.sort(list, new User()); // 類別滿足Comparator
        System.out.println("自身實現 Comparator: " + list);

        // 改為按照名字排序
        Collections.sort(list, new Comparator<User>() {
           @Override
           public int compare(User o1, User o2) {
               return o1.getName().compareTo(o2.getName());
           }
        });
        System.out.println("匿名內部類別方式： " + list);

        //使用 lambda方式 | 使用 String 內建的 compareTo
        Collections.sort(list,(u1,u2)->{return u1.getName().compareTo(u2.getName());});
        System.out.println("Lambda 表達: " + list);
    }
}

