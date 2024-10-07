package bomteng.thread;

/**
 * 113/9/30 Thread Priority
 * 使用 join 插入執行緒
 */
public class JoinUsage {
    public static void main(String[] args) {
        TestJoin t1 = new TestJoin("Allen");
        TestJoin t2 = new TestJoin("Kitty");
        TestJoin t3 = new TestJoin("Kyle");
        t1.start();
//        t2.start();
//        t3.start();

        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t2.start();
        t3.start();
    }

    static class TestJoin extends Thread {
        TestJoin(String name) {
            super(name);
        }

        @Override
        public void run() {
            for (int i=0; i<=10; i++) {
                System.out.println(this.getName() + ": " +i);
            }
        }
    }
}
