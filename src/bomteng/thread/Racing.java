package bomteng.thread;

// file: Horse, Racing;
public class Racing {
    public static void main(String[] args) {
        int h1 = 0;
        //產生Horse物件並啟動執行緒
        Horse h2 = new Horse();
        h2.start();

        for (int i=0; i<250; i++) {
            h1++;
            System.out.println("H1:" +h1);
        }
        System.out.println("Horse1 end");
    }
}
