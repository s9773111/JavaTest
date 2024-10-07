package bomteng.thread;

public class VolatileWeb {
    // 增加 volatile 關鍵字：
    private static volatile boolean stopFlag = false;

    public static void main(String[] args) throws InterruptedException {
        Thread taskThread = new Thread(() -> {
            while (!stopFlag) {
                System.out.println("執行中...");
            }
            System.out.println("執行緒終止!");
        });

        taskThread.start();

        Thread.sleep(1000);
        stopFlag = true;
        System.out.println("主執行緒已設置 stopFlag = true");

    }
}
