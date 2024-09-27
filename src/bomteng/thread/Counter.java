package bomteng.thread;

public class Counter {
    private int count = 0;

    // 增加計數器的方法 同步的
    public synchronized void increment() {
        count++;
        System.out.println("執行緒：" + Thread.currentThread().getName() +", count = " + count);
    }

    public int getCount() {
        return count;
    }
}

