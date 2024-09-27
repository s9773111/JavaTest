package bomteng.thread;

public class Syn {

    public static void main(String[] args) throws InterruptedException {
        //銀行同步練習
//        bankMoney();

        //計時器同步練習
        counterSyn();

    }

    public static void bankMoney(){
        BankAccount account = new BankAccount();

        //創建兩個執行緒同時存取和提款
        Thread t1 = new Thread(() -> account.deposit(500));
        Thread t2 = new Thread(() -> account.withdraw(200));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("執行緒被中斷");
        }
        System.out.println("最後餘額：" + account.getBalance());
    }

    public static void counterSyn() throws InterruptedException {
        Counter counter = new Counter();

        // 建立執行緒增加計數器
        Thread t1 = new Thread(() -> {
            for (int i=0; i<1000; i++) {
                counter.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        //輸出最終的計數器
        System.out.println("Final count:" + counter.getCount());
    }
}

