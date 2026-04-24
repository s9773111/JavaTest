package bomteng.Reflection.Proxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Proxy綜合範例
 * JDK動態代理實現
 */

public class JDKProxy implements InvocationHandler {

    // 需要代理的目標物件
    private Object targetObject;

    //將目標物件傳入進行代理
    public Object newProxy(Object target) {
        this.targetObject = target;
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),
                targetObject.getClass().getInterfaces(), this);
    }

    // invoke方法
    @Override
    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
        // 模擬檢查權限
        checkPopedom();
        Object ret = null;
        ret = method.invoke(targetObject, args);

        return ret;
    }

    // 模擬檢查權限
    private void checkPopedom() {
        System.out.println("--- 檢查權限 JDK checkPopoedom() ---");
    }
}
