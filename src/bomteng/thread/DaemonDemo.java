package bomteng.thread;

/**
 * 113/9/28 Daemon
 * 一旦主執行緒（非守護執行緒）結束後，守護執行緒會自動終止
 * 由於 thread 被設置為守護執行緒，而 main 方法的主執行緒很快執行完畢，
 * JVM 在主執行緒結束後會自動終止所有的守護執行緒
 */
public class DaemonDemo {
    public static void main(String[] args) {
        System.out.println("main 執行緒開始");

        var thread = new Thread(() -> {
            System.out.println("建立新執行緒：" + Thread.currentThread().getName());
            while (true) {
                System.out.println("Orz");
            }
        });

        thread.setDaemon(true);
        thread.start();

        System.out.println("main 行緒結束");
    }
}
