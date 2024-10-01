package bomteng.thread;
import java.util.concurrent.TimeUnit;

public class InterruptedSignal extends Thread{

    @Override
    public void run() {
        for(int i=0; i<100; i++) {
            System.out.println("i: " +i);

//            if(this.isInterrupted()) {
            if(Thread.interrupted()) {  // 這個方法 會消除中斷訊號
                System.out.println("isInterrupted Get signal");
                // 取得中斷訊號，但不清除
            } else {
                System.out.println("Working");
            }
         }
    }

    public static void main(String[] args) {
        InterruptedSignal t =new InterruptedSignal();
        t.start();

        try{
            TimeUnit.MILLISECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t.interrupt();
    }
}
