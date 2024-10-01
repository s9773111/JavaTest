package bomteng.thread;

/**
 * 113/9/30 Thread Priority
 * 練習使用synchronized, 共用變數
 *
 */
public class RaceCondition {

    private int i;

    public synchronized int getAndIncr() {
        return i++;
    }
    public static void main(String[] args) {
        RaceCondition raceCon = new RaceCondition();

        //建立10個執行緒 每個執行緒都會呼叫 getAndIncr()
        for (int j=0; j<10; j++) {
            Thread thread = new Thread(() -> {
                for(int k=0; k<10; k++) {
                    System.out.println(Thread.currentThread().getName() + ": " + raceCon.getAndIncr());
                }
            });
            thread.start();
        }
    }
}
