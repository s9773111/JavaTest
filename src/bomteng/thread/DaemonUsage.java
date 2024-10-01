package bomteng.thread;

/**
 * 113/9/30 Thread Priority
 * .setDaemon | 變成守護者
 */
public class DaemonUsage {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + "--- start");

        TestDaemon d = new TestDaemon();

        // 開啟true, 前景（MainThread）結束，背景就會結束
        d.setDaemon(true);
        d.start();

        System.out.println(Thread.currentThread().getName() + "--- finish");

    }

    static class TestDaemon extends Thread {
        @Override
        public void run() {
            for (int i=0; i<10; i++) {
                System.out.println(this.getName() +": " + i);
            }
        }
    }
}
