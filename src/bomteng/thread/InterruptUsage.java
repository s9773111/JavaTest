package bomteng.thread;

import java.util.concurrent.TimeUnit;
public class InterruptUsage {

    public static void main(String[] args) throws InterruptedException {
        // 使用TimeUnit.SECONDS
//        interrupt1();

        // 使用while
        interrupt2();
    }

    public static void interrupt1() {
        Runnable task = () -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
            System.out.println("interrupt1 thread end");
        };
        Thread thread = new Thread(task);
        thread.start();
        thread.interrupt();
        System.out.println("interrupt1 main end");
    }


    public static void interrupt2() throws InterruptedException {
        Runnable task = () -> {
            // 紀錄開始時間（毫秒為單位）
            long startTime = System.currentTimeMillis();

            while(!Thread.currentThread().isInterrupted()) {
                // 計算已經過的時間
                long elapsedTime = System.currentTimeMillis() - startTime;
                long elapsedSeconds = elapsedTime / 1000;
                System.out.println("經過了 " + elapsedSeconds + " 秒，未中斷！");

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    System.out.println("中斷了");
                    // 重設中斷狀態，讓迴圈可以正確退出
                    Thread.currentThread().interrupt();
                }

            }
            System.out.println("Finished");
        };
        Thread thread = new Thread(task);
        thread.start();
        thread.sleep(5000);
        thread.interrupt();
    }

//    public static void main(String[] args)  {
//        Runnable task = () -> {
//            try {
//                while(!Thread.currentThread().isInterrupted()) {
//                    System.out.println("執行中...");
//                    Thread.sleep(100);
//                }
//            } catch (InterruptedException e) {
//                System.out.println("被中斷了！");
//                Thread.currentThread().interrupt();  //可選：恢復中斷狀態
//            }
//            System.out.println("Finished");
//        };
//
//        Thread thread = new Thread(task);
//        thread.start();
//
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        thread.interrupt(); //中斷執行緒
//
//    }


//    public static void main(String []args) {
//        Runnable task = () -> {
//            while(!Thread.currentThread().isInterrupted()) {
//                // Do some work
//                System.out.println("測到中斷！");
//            }
//            System.out.println("Finished");
//        };
//        Thread thread = new Thread(task);
//        thread.start();
//        thread.interrupt();
}
