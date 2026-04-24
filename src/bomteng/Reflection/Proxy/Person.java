package bomteng.Reflection.Proxy;

/**
 * Proxy ex2: JDK動態代理示範 - 打招呼
 * 定義介面
 */
public interface Person {
    public void introduce(String name);
    public void sayAge(int age);
    public void sayWhereFrom(String city, String country);
}
