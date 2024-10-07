package bomteng.thread;

import com.sun.tools.javac.Main;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 113/10/7 Thread RaceCondition
 * 避免產生資源共享發生問題
 * 解法-synchronized, AtomicInteger
 */
public class RaceConditionWeb2 {

    //方法1 使用synchronized
//    public static int value = 0;
//    public static synchronized void incrementValue() {
//        value++;
//    }
//
//    public static void main(String[] args) {
//        Runnable task = () -> {
//            for (int i=0; i<10000; i++) {
//                int oldValue, newValue;
//                // 確保只有一個執行緒能進行 value 的更新
//                synchronized(Main.class) {
//                    oldValue = value;
//                    newValue = ++value;
//                }
//                if (oldValue +1 != newValue) {
//                    throw new IllegalStateException(oldValue + "+1 = " + newValue);
//                }
//            }
//            System.out.println("完成最後加總:"+value+ ", thread name:" + Thread.currentThread().getName());
//        };
//
//        new Thread(task).start();
//        new Thread(task).start();
//        new Thread(task).start();
//    }


    //方法2 AtomicInteger
    public static AtomicInteger value = new AtomicInteger(0);

    public static void main(String[] args) {
        Runnable task = () -> {
            for (int i=0; i<10000; i++) {
                int newValue = value.incrementAndGet(); //增加value
            }
            System.out.println("完成最後加總:"+value+ ", thread name:" + Thread.currentThread().getName());
        };

        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();
    }
}
