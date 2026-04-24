package bomteng.Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射機制
 */
public class RefTest0 {
    public static void main(String[] args) throws Exception {
        // class類別
        test1();
        System.out.println();

        //獲取所有公共方法、屬性
        test2();
        System.out.println();

        // 創建物件實例
        test3();
        System.out.println();

        // 調用方法
        test4();
        System.out.println();
    }

    public static void test1() throws Exception {
        String str = "Isaac";
        Class<?> cls1 = str.getClass();

        Class<?> cls2 = String.class;

        Class<?> cls3 = Class.forName("java.lang.String");

        // 類別各種資訊
        System.out.println(cls1.getName());
        System.out.println(cls2.getSimpleName());
        System.out.println(cls3.getSuperclass());
        System.out.println(cls1.getInterfaces());
        System.out.println(cls2.getModifiers());
        System.out.println(cls3.getConstructors());
    }

    public static void test2() throws Exception {
        Class<?> cls = Class.forName("java.lang.String");

        // 獲取所有公共方法
        Method[] methods = cls.getMethods();
        for(Method m : methods){
            System.out.println("方法: " + m.getName());
        }

        // 獲取所有公共屬性
        Field[] fileds = cls.getFields();
        for (Field f : fileds) {
            System.out.println("屬性:" + f.getName());
        }
    }

    public static void test3() throws Exception {
        // 建立空白實例
        Class<?> cls = Class.forName("java.lang.String");
        Object obj = cls.getDeclaredConstructor().newInstance();

        // 創建一個String物件
        // 1.找建構子
        Constructor<?> constructor = cls.getDeclaredConstructor(String.class);
        // 2.建立實例
        String stringObj = (String) constructor.newInstance("test");
        System.out.println("反射建立的字串物件:" + stringObj);

    }

    public static void test4() throws Exception {
        String str = "Hello, Reflection!";
        Class<?> cls =  str.getClass();
        Method method = cls.getMethod("length");
        Object result = method.invoke(str);
        System.out.println("字串長度:" + result);
    }
}
