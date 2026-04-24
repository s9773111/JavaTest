package bomteng.Reflection.Proxy2;

/**
 * Proxy綜合範例
 * 代理模式 目標對象
 * 要記得加上 VM options
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("--- CGLibProxy ---");
        CGLibProxy cgLibProxy = new CGLibProxy();
        IUserManager userManager = (IUserManager) cgLibProxy.createProxyObject(new UserManagerImpl());
        userManager.addUser("isaac1", "123456");

        System.out.println("--- JDKProxy ---");
        JDKProxy jdkProxy = new JDKProxy();
        IUserManager userManagerJDK = (IUserManager) jdkProxy.newProxy(new UserManagerImpl());
        userManagerJDK.addUser("isaac2", "123456");
    }
}
