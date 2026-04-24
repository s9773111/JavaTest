package bomteng.Reflection.CGLIB;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * CGLIB Proxy ex1:
 * 大廚代理人 (似JDK InvocationHandler)
 */
public class ChefProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("--- 經紀人：準備食材 ---");

        // 這裡是呼叫 proxy.invokeSuper (非invoke)
        Object result = proxy.invokeSuper(o, args);

        System.out.println("--- 經紀人：清理廚房 ---");

        return result;
    }
}
