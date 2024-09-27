package bomteng.thread;

// file: Horse, Racing;
// file2: Horse, Racing3;
public class Horse extends Thread {
    // 覆寫 run() 方法
    public void run() {
        Thread thr = Thread.currentThread();
        // thr.setName("H2");
        // 由1跑到5000
        int h = 0;
        for (int i = 0; i<150; i++) {
            h++;
            System.out.println(getName()+":"+h);
        }
        System.out.println(getName() + "end");
    }
}
