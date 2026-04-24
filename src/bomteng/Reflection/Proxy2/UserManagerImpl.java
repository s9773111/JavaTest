package bomteng.Reflection.Proxy2;

/**
 * Proxy綜合範例
 * 介面實現類
 */
public class UserManagerImpl implements IUserManager {
    @Override
    public void addUser(String id, String password) {
        System.out.println("--- 呼叫了UserManagerImpl.addUser 方法 ---");
    }
}
