package bomteng.Reflection.Proxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

/**
 * Proxy ex1:建立一個自動記錄 Log 的經紀人
 * 動態生成代理人並執行
 */
public class ProxyTest0 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        // 1. 第一種
        /*
        Service realService = new RealService();
        Service proxyInstance = (Service) Proxy.newProxyInstance(
                realService.getClass().getClassLoader(), //類別載入器
                realService.getClass().getInterfaces(), //明星有哪些專長(介面)
                new MyProxyHandler(realService) //經紀人邏輯
        );

        // 透過代理人呼叫
        // 當呼叫 proxyInstance.work() 時，
        // Java 內部會自動跳轉去執行 MyProxyHandler 裡的 invoke。

        // 經紀人拿到 method 物件後，它必須透過反射 method.invoke(target, args)
        // 才能把指令傳給後面的明星。
        proxyInstance.work();
        proxyInstance.rest();

         */


        // 2. 第二種 寫上getProperties() 會保留$Proxy0.class

        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
        Class proxyClazz = Proxy.getProxyClass(Service.class.getClassLoader(), Service.class);
        Constructor constructor = proxyClazz.getConstructor(InvocationHandler.class);
        Service service = (Service) constructor.newInstance(new MyProxyHandler(new RealService()));
        service.work();
        service.rest();


    }
}

