package bomteng.thread;

/**
 * 113/9/28 Daemon
 * 一旦主執行緒（非守護執行緒）結束後，守護執行緒會自動終止
 */
public class DaemonThreadExample {
    public static void main(String[] args) {
        Thread daemonThread = new Thread(() -> {
            System.out.println("建立新的執行緒");
            while (true) {
                try {
                    System.out.println("守護執行緒正在運行...: " + Thread.currentThread().getName());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // 設置為守護執行緒
        daemonThread.setDaemon(true);
        daemonThread.start();

        // 主執行緒運行3秒後結束
        try {
            System.out.println("主執行緒名稱： "+Thread.currentThread().getName());
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("主執行緒結束");
    }
}

