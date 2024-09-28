package bomteng.thread;

// file: Horse, Racing3;
public class Racing3 {
    public static void main(String[] args) {
        // 用此方法 main會第一個印出
//        threadTest1();

        // Q: 如何讓main執行緒等待三匹馬結束後，才繼續往後執行
        // 使用 join() + try catch
        threadTest2();

    }

    public static void threadTest1(){
        Horse h1 = new Horse();
        Horse h2 = new Horse();
        Horse h3 = new Horse();

        h1.setName("h1");
        h2.setName("h2");
        h3.setName("h3");

        h1.start();
        h2.start();
        h3.start();
        System.out.println("main執行緒結束");
    }

    public static void threadTest2(){
        Horse h1 = new Horse();
        Horse h2 = new Horse();
        Horse h3 = new Horse();

        h1.setName("h1");
        h2.setName("h2");
        h3.setName("h3");

        h1.start();
        h2.start();
        h3.start();

        try {
            h1.join();
            h2.join();
            h3.join();
        } catch (InterruptedException e) {
            System.out.println("執行緒被中斷");
        }
        System.out.println("main執行緒結束");
    }
}
