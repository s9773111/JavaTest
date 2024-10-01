package bomteng.thread;

/**
 * 113/9/27
 * 行緒練習
 * 1.取得與修改名稱
 * 2.Racing測試-新增Thread
 * 3. 9/30 新建執行緒 thread4: extends, runnable
 */
public class Thread01 {
    public static void main(String[] args) {
        // thread1 取名稱與修改名稱
        Thread thr = Thread.currentThread();
        System.out.println("目前執行緒名稱：" + thr.getName());
        thr.setName("Isaac");
        System.out.println("修改後執行序名稱：" + thr.getName());

        // thread2 RacingNG
//        thread2();

        // thread3 使用lambda
        thread3();

        // 創建thread
        thread4();
    }

    public static void thread2(){
        int h1=0;
        int h2=0;
        for (int i=0; i<10; i++) {
            h1++;
            h2++;
            System.out.println("H1:" +h1);
            System.out.println("H2:" +h2);
        }
    }

    public static void thread3() {
        System.out.println("進入thread3");
        // 要記得加start()
        new Thread(()-> {
            System.out.println("Hello Thread3()");
        }).start();
    }

    public static void thread4() {
        System.out.println("進入thread4");

        // 使用Runnable 1
        Runnable task = new Runnable() {
            public void run() {
                System.out.println("Hello World! runnable_thread04()");
            }
        };
        Thread thread4_1 = new Thread(task);
        thread4_1.start();

        // 使用Runnable2
        Runnable task2 = () -> {
            System.out.println("Hello World! runnable2_thread04()");
        };
        Thread thread4_2 = new Thread(task2);
        thread4_2.start();
    }
}
