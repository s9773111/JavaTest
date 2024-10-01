package bomteng.thread;

import java.util.concurrent.TimeUnit;

public class SleepThread {
    public static void main(String[] args) {
        Runnable task = () -> {
            try {
//                int secToWait = 1000 * 30;
//                Thread.currentThread().sleep(secToWait);
                TimeUnit.SECONDS.sleep(10); //另一種睡眠時間
                System.out.println("Woke up");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread thread = new Thread(task);
        thread.start();
    }

}
