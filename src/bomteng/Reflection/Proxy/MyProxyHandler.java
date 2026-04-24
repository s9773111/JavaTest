package bomteng.Reflection.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Proxy ex1:建立一個自動記錄 Log 的經紀人
 * 實作經紀人邏輯: 最重要處，所有請求都會經過invoke
 */
public class MyProxyHandler implements InvocationHandler {
    private Object target; // 被代理的物件

    public MyProxyHandler(Object target) {
        this.target = target;
    }


    @Override
    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
        System.out.println("--- 經紀人接洽, 準備演出前置作業 ---");

        Object result = method.invoke(target, args);

        System.out.println("--- 經紀人結算, 演出結束收尾工作 ---");

        return result;
    }
}
