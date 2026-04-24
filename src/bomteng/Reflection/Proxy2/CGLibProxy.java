package bomteng.Reflection.Proxy2;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Proxy綜合範例
 * CGLIB動態代理實現
 */

public class CGLibProxy implements MethodInterceptor {

    private Object targetObject;

    public Object createProxyObject(Object obj) {
        this.targetObject = obj;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(obj.getClass());
        enhancer.setCallback(this);
        Object proxyObj = enhancer.create();

        return proxyObj;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        Object obj = null;

        if ("addUser".equals(method.getName())) {
            checkPopedom();
        }
        obj = method.invoke(targetObject, args);
        return obj;
    }

    private void checkPopedom() {
        System.out.println("--- 檢查權限 CGLIB checkPopoedom() ---");
    }
}
