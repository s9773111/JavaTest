package bomteng.thread;

/**
 * 113/10/7 Thread RaceCondition
 * 使用 共用變數 發生RaceCondition
 * 解法：看RaceConditionWeb2
 */
public class RaceConditionWeb {

    public static int value = 0;

    public static void main(String[] args) {
        Runnable task = () -> {
            for (int i = 0; i<10000; i++) {
                int oldValue = value;
                int newValue = ++value;
                if (oldValue + 1 != newValue) {
                    throw new IllegalStateException(oldValue + "+ 1 =" + newValue);
                }
            }
            System.out.println("完成最後加總：" + value);
        };
        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();
    }
}
