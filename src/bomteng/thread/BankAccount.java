package bomteng.thread;

// file:BankAccount, Syn.java
public class BankAccount {
    private int balance = 1000;

    //同步存款操作 確保只有一個thread 可修改 balance
    public synchronized void deposit(int amount) {
        System.out.println("存款：" + amount);
        balance += amount;
    }

    //同步提款操作
    public synchronized void withdraw(int amount) {
        System.out.println("提款： " + amount);
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }
}
