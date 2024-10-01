package bomteng.thread;

/**
 * 113/9/30 Thread Priority
 * 優先權設定
 */
public class PriorityThread extends Thread{

    @Override
    public void run() {
        for (int i=0; i<5; i++) {
            System.out.println(Thread.currentThread().getName()+": " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        PriorityThread t1 = new PriorityThread();
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.setName("T1");

        PriorityThread t2 = new PriorityThread();
        t2.setPriority(Thread.MIN_PRIORITY);
        t2.setName("T2");

        t1.start();
        t2.start();

        Thread.sleep(300);
    }
}
