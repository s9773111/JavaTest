package bomteng.thread;

public class DeadLockWeb2 {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();


    public void method1() {
        synchronized(lock1) {
            System.out.println("Thread 1: Holding lock1...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            synchronized (lock2) {
                System.out.println("Thread 1: Holding lock2...");
            }
        }
    }

    public void method2() {
        synchronized(lock2) {
            System.out.println("Thread 2: Holding lock2...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e){
            }

            synchronized (lock1) {
                System.out.println("Thread 2: Holding lock1...");
            }
        }
    }

    public static void main(String[] args) {
        DeadLockWeb2 deadlock = new DeadLockWeb2();
        Thread thread1 = new Thread(deadlock::method1);
        Thread thread2 = new Thread(deadlock::method2);

        thread1.start();
        thread2.start();
    }
}
