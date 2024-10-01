package bomteng.thread;

/**
 * 113/9/30 Thread Priority
 * 使用 yield 讓出執行緒
 */
public class YieldUsage {
    public static void main(String[] args) {
        TestNormal j2 = new TestNormal("Normal");
        TestYield j1 = new TestYield("Yield");
        j1.start();
        j2.start();
    }

    static class TestYield extends Thread {
        TestYield(String name) {
            super(name);
        }

        @Override
        public void run() {
            for (int i=0; i<25; i++) {
                System.out.println(this.getName() + ": " +i);
                if (i==5) {
                    Thread.yield();
                }
            }
        }
    }

    static class TestNormal extends Thread {
        TestNormal(String name) {
            super(name);
        }

        @Override
        public void run() {
            for(int i=0; i<25; i++) {
                System.out.println(this.getName() + ": " +i);
            }
        }
    }
}
