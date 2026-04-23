package bomteng.Reflection;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射 java.lang.Runtime 內建類別
 */
public class RefTest2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // 不使用反射執行本地端命令
        // System.out.println(org.apache.commons.io.IOUtils.toString(Runtime.getRuntime().exec("whoami").getInputStream(), "UTF-8"));

        // 使用反射 ClassNotFountException
        Class runtimeClass1 = Class.forName("java.lang.Runtime");
        // 取得建構子方法 NoSuchMethodException -> 會無法執行
        //Constructor constructor = runtimeClass1.getDeclaredConstructor();
        //constructor.setAccessible(true);
        // 改用獲取靜態方法 getRuntime()
        Method getRuntimeMethod = runtimeClass1.getMethod("getRuntime");

        // 獲取實體
        // 因為是靜態方法，invoke 的第一個參數傳 null
        //Object runtimeInstance = constructor.newInstance();
        // 可以是null, static方法時;
        Object runtimeInstance = getRuntimeMethod.invoke(null);

        // 獲取Runtime的exec(String cmd)方法
        Method runtimeMethod = runtimeClass1.getMethod("exec", String.class);

        // 調用exec方法 = rt.exec(cmd);
        Process process = (Process) runtimeMethod.invoke(runtimeInstance, "whoami");
        InputStream in = process.getInputStream();
        System.out.println(IOUtils.toString(in, "UTF-8"));
    }
}
