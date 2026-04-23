package bomteng.Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * ex反射練習1
 */

public class RefTest1 {
    public static void main(String[] args) throws Exception {
        level1();
        System.out.println();
        level2();
        System.out.println();
        level3();
        System.out.println();
        level4();
    }

    public static void level1() throws Exception  {
        System.out.println("進入level1()");

        // 取得Class的三種方式、建立類別物件
        Class<?> clazz1 = Hero.class;
        Class<?> clazz2 = new Hero().getClass();
        Class<?> clazz3 = Class.forName("bomteng.Reflection.Hero"); //要加上例外, 路徑完整
        System.out.println("[取得名稱1]");
        System.out.println("類別名稱a：" + clazz1.getName());
        System.out.println("類別名稱b：" + clazz2.getName());
        System.out.println("類別名稱c：" + clazz3.getName());

        System.out.println("[取得名稱2]");
        System.out.println("class name Canonical:" + clazz1.getCanonicalName());
        System.out.println("class name Simple:" + clazz2.getSimpleName());

        System.out.println("[取得類別所有方法]");
        // 取得類別所有方法名稱
        Method[] methods = clazz3.getDeclaredMethods();
        for(int i = 0; i < methods.length; i++) {
            System.out.println("method " + i + ":" + methods[i].getName());
        }

        System.out.println("[取得類別所有屬性]");
        // 取得類別所有屬性名稱
        Field[] fields = clazz3.getDeclaredFields();
        for(int i = 0; i < fields.length; i++) {
            System.out.println("filed" + i + ":" + fields[i].getName());
        }

    }

    public static void level2() throws Exception  {
        System.out.println("進入level2()");
        Class<?> clazz = Hero.class;

        // 呼叫 public 無參數建構子
        Hero h1 = (Hero) clazz.getDeclaredConstructor().newInstance();
        System.out.println("英雄預設名稱：" + h1.getName());

        // 呼叫 私有參數建構子
        Constructor<?> constructor = clazz.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);
        Hero h2 = (Hero) constructor.newInstance("五條悟");
        h2.attack("無量空處");
    }

    public static void level3() throws Exception  {
        System.out.println("進入level3()");

        Hero myHero = new Hero();
        Class<?> clazz = myHero.getClass();

        System.out.println("修改前的英雄名稱:" + myHero.getName());

        //取得私有屬性
        Field f = clazz.getDeclaredField("name");


        f.setAccessible(true);

        f.set(myHero, "美國隊長");

        System.out.println("修改後的英雄名稱:" + f.get(myHero));
    }
    // 獲取指定方法
    public static void level4() throws Exception  {
        System.out.println("進入level4()");

        Class<?> targetClass = Hero.class;
        Hero targetObject = (Hero) targetClass.newInstance();

        // 取得public方法
        Method publicMethod = targetClass.getDeclaredMethod("attack", String.class);
        publicMethod.invoke(targetObject, "生死意境");

        // 調用private
        Method privateMethod = targetClass.getDeclaredMethod("secret");
        privateMethod.setAccessible(true);
        privateMethod.invoke(targetObject);

    }
}
