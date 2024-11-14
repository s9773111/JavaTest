package bomteng.stream.test;

public class Cust {
    private int year;
    private String name;
    private int age;
    private long money;

    public Cust() {
    }

    public Cust(int year, String name, int age, long money) {
        this.year = year;
        this.name = name;
        this.age = age;
        this.money = money;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }
}

