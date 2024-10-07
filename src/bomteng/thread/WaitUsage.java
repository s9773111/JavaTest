package bomteng.thread;

/**
 * 113/10/4 Thread Priority
 * 使用 Wait, notify(), notifyAll()
 *
 * 說明：main使用任務物件建立一個新thread，啟動它，然後等待3秒。
 * 使得新thread可能能在該執行緒main前取得鎖，並進入監視器佇列。
 *
 * 之後，執行(main)緒本身進入物件(lock)的同步區塊並使用監視器執行執行緒通知。
 * 發送通知後，執行main緒釋放lock物件的監視器，而先前等待lock物件監視器釋放的新執行緒環境執行。
 *
 */
public class WaitUsage {

    public static void main(String[] args) throws InterruptedException {
        // Object 鎖
        Object lock = new  Object();
        Runnable task = () -> {
            //
            System.out.println("執行 Thread");
            synchronized (lock) {
                try {
                    lock.wait();
                } catch(InterruptedException e) {
                    System.out.println("Interrupted");
                }
            }
            // After notified, we will wait until we can acquire the lock
            System.out.println("Thread end");
        };

        Thread taskThread = new Thread(task);
        taskThread.start();

        // we sleep. Then we acquire the lock, notify, and release the lock
        Thread.sleep(3000);
        System.out.println("main");
        synchronized(lock){
            lock.notify();
        }
    }
}
