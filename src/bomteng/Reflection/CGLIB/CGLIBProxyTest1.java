package bomteng.Reflection.CGLIB;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

/**
 * CGLIB Proxy ex1
 * 動態生成代理人並執行
 */
public class CGLIBProxyTest1 {
    public static void main(String[] args) {

        // 將代理類別class存入本地 查看源碼
        // 多了 5個檔案
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/isaac/Desktop/JavaCode/JavaTest/jdk");

        Enhancer enhancer = new Enhancer();
        // 設定父類
        enhancer.setSuperclass(Chef.class);
        // 設定攔截邏輯
        enhancer.setCallback(new ChefProxy());
        // 產生兒子(代理)
        Chef proxyChef = (Chef) enhancer.create();
        proxyChef.cook();

    }
}
