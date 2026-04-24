package bomteng.Reflection.Proxy;

import java.lang.reflect.Proxy;

/**
 * Proxy ex2
 * 動態生成代理人並執行
 */
public class ProxyTest1 {
    public static void main(String[] args) {
        // 建立原始物件
        Man isaac = new Man("Isaac", 36, "Taipei", "Taiwan");

        // 取得 the class loader
        ClassLoader isaacClassLoader = isaac.getClass().getClassLoader();
        Class[] interfaces = isaac.getClass().getInterfaces();

        // 建立 proxy 代理物件
        Person proxyIsaac = (Person) Proxy.newProxyInstance(isaacClassLoader, interfaces, new PersonInvocationHandler(isaac));

        proxyIsaac.introduce(isaac.getName());
        proxyIsaac.sayAge(isaac.getAge());
    }
}
