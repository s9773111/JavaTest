package bomteng.Reflection.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Proxy ex2: 調用處理器, 添加額外的行為
 * 實作經紀人邏輯: 最重要處，所有請求都會經過invoke
 */
public class PersonInvocationHandler implements InvocationHandler {
    private Person person;

    public PersonInvocationHandler(Person person) {
        this.person = person;
    }


    @Override
    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
        System.out.println("Hi My lord");

        // $Proxy0的invoke：從「代理物件」傳給「處理器（Handler）」。
        // 這裡的invoke是反射回去，處理器->真實物件
        return method.invoke(person, args);
    }
}
