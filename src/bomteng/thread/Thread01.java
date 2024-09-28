package bomteng.thread;

/**
 * 113/9/27
 * 行緒練習
 * 1.取得與修改名稱
 * 2.Racing測試-新增Thread
 *
 */
public class Thread01 {
    public static void main(String[] args) {
        // thread1 取名稱與修改名稱
        Thread thr = Thread.currentThread();
        System.out.println("目前執行緒名稱：" + thr.getName());
        thr.setName("Isaac");
        System.out.println("修改後執行序名稱：" + thr.getName());

        // thread2 RacingNG
        thread2();
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
}
