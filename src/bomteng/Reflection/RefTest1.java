package bomteng.Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class RefTest1 {
    public static void main(String[] args) throws Exception {
        level1();

        level2();

        level3();
    }

    public static void level1() throws Exception  {
        // 取得Class的三種方式
        Class<?> clazz1 = Hero.class;
        Class<?> clazz2 = new Hero().getClass();
        Class<?> clazz3 = Class.forName("bomteng.Reflection.Hero"); //要加上例外, 路徑完整

        System.out.println("類別名稱1：" + clazz1.getName());
        System.out.println("類別名稱2：" + clazz2.getName());
        System.out.println("類別名稱3：" + clazz3.getName());
    }

    public static void level2() throws Exception  {
        Class<?> clazz = Hero.class;

        // 呼叫 public 無參數建構子
        Hero h1 = (Hero) clazz.getDeclaredConstructor().newInstance();

        // 呼叫 私有參數建構子
        Constructor<?> constructor = clazz.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);
        Hero h2 = (Hero) constructor.newInstance("五條悟");
        h2.attack("無量空處");
    }

    public static void level3() throws Exception  {
        Hero myHero = new Hero();
        Class<?> clazz = myHero.getClass();

        System.out.println("修改前的英雄名稱:" + myHero.getName());

        //取得私有屬性
        Field f = clazz.getDeclaredField("name");


        f.setAccessible(true);

        f.set(myHero, "美國隊長");

        System.out.println("修改後的英雄名稱:" + f.get(myHero));
    }
}
