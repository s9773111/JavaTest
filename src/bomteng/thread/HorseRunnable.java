package bomteng.thread;

// file: HorseRunnable, Racing2;
public class HorseRunnable implements Runnable {
    public void run() {
        int h = 0;
        for (int i=0; i<250; i++) {
            h++;
            System.out.println(h);
        }
    }
}
