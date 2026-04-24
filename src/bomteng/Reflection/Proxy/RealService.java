package bomteng.Reflection.Proxy;

/**
 * Proxy ex1:建立一個自動記錄 Log 的經紀人
 * 定義明星
 */
public class RealService implements Service {
    @Override
    public void work() {
        System.out.println("正在表演中....");
    }

    @Override
    public void rest() {
        System.out.println("開始休息...");
    }
}
