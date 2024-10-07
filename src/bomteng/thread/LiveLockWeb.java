package bomteng.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;


/**
 * 113/10/4 Thread livelock
 * 若 Thread1 先執行會得到活鎖狀況
 * 兩個執行緒都會嘗試鎖定 first 和 second
 */
public class LiveLockWeb {
    // 設定字串文字顏色
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    // text參數是用來調整顏色
    public static void log(String text) {
        String name = Thread.currentThread().getName();
        String color = ANSI_BLUE;

        int val = Integer.valueOf(name.substring(name.lastIndexOf("-") + 1)) +1;
        if (val != 0) {
            color = ANSI_PURPLE;
        }

        System.out.println(color + name + ": " + text + color);

        try {
            System.out.println(color + name + ": wait for " + val + " sec" + color);
            // 這裡決定了 thread1 會有較長的延遲。
            // 延遲機制導致 Thread-1 的執行速度比 Thread-0 慢一些。
            // 這也是為什麼你看到 Thread-0 先完成操作，因為它只延遲了 1 秒，
            // 而 Thread-1 則延遲了 2 秒
            Thread.currentThread().sleep(val * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // 這兩個鎖是由執行緒來競爭的資源
        Lock first = new ReentrantLock();
        Lock second = new ReentrantLock();

        Runnable locker = () -> {
            // 兩個變數 用來追蹤是否成功鎖住first, second
            boolean firstLocked = false;
            boolean secondLocked = false;

            try {
                // 若兩個變數都被鎖住 true 就不執行
                // 當Thread-0獲取兩個鎖時，它跳出迴圈並在執行unlock()後結束
                while (!firstLocked || !secondLocked ) {
                    // tryLock 嘗試鎖住資源，若鎖住失敗會等待100毫秒
                    firstLocked = first.tryLock(100, TimeUnit.MILLISECONDS);
                    log("First locked: " + firstLocked);
                    secondLocked = second.tryLock(100, TimeUnit.MILLISECONDS);
                    log("Second Locked: " + secondLocked);
                }
                System.out.println(Thread.currentThread().getName() + " 跳出迴圈");
                // 解鎖
                first.unlock();
                second.unlock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        new Thread(locker).start();
        new Thread(locker).start();

    }
}
