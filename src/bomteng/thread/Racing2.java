package bomteng.thread;

// file: HorseRunnable, Racing2;
public class Racing2 {
    public static void main(String[] args) {
        int h1 = 0;

        // 產生物件, 啟動執行緒
        HorseRunnable h2 = new HorseRunnable();
        Thread thr = new Thread(h2);
        thr.start();

        for (int i=0; i<250; i++){
            h1++;
            System.out.println("HorseRunnable_H1:" +h1);
        }

    }
}
