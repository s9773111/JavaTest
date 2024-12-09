package bomteng.stream.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamPractice {
    List<Transaction> transactions = null;


    // beforeEach = before
    @BeforeEach
    public void before() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Japan");
        Trader brian = new Trader("Brian", "Taipei");
        Trader isaac = new Trader("Isaac", "Africa");

        transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950),
                new Transaction(isaac, 2011, 650)
        );
    }

    List<Cust> custs = Arrays.asList(
        new Cust(101, "梅西", 30, 33000000L),
        new Cust(102, "伊布", 35, 23000000L),
        new Cust(103, "哈維", 34, 20000000L),
        new Cust(104, "伊列斯塔", 33, 18000000L),
        new Cust(105, "小羅", 37, 15000000L),
        new Cust(106, "內馬爾", 27, 32000000L),
        new Cust(106, "內馬爾", 27, 32000000L),
        new Cust(106, "姆巴佩", 23, 30500000L)
    );

    @Test
    public void test0() {
        // 返回每個數的平方
        List<Integer> l1 = Arrays.asList(1,2,3,4).stream().map(x->x*x).collect(Collectors.toList());
        System.out.println(l1);
        System.out.println("###########################");

        // 計算有多少Cust物件
        /**
         *  用Map和Reduce計算
         */
        Integer ic1 = custs.stream().map(Cust::getAge).reduce(0, (x,y) -> x+1);
        System.out.println("個數算法1 ：" +ic1);
        Integer ic2 = custs.stream().map(e->1).reduce(0, Integer::sum);
        System.out.println("個數算法2 reduce(0, Integer::sum) ：" +ic2);
        long ic3 = custs.stream().count();
        System.out.println("個數算法3 count：" +ic3);

        // 年齡計算加總
        Integer ageSum = custs.stream().map(Cust::getAge).reduce(0, Integer::sum);
        System.out.println("年齡加總：" + ageSum);

    }
    // 1. 找出2011年發生的所有交易 並按交易額排序(低到高)
    @Test
    public void test1() {
        transactions.stream().filter(x->x.getYear()==2011).sorted((x,y) -> {
            if(x.getValue()>y.getValue()){
                return 1;
            } else if(x.getValue() < y.getValue()) {
                return -1;
            } else {
                return 0;
            }
        }).forEach(System.out::println);
    }

    // 2. 交易員都在城市
    @Test
    public void test2(){
        transactions.stream().map(Transaction::getTrader).map(Trader::getCity).distinct().forEach(System.out::println);
    }
}
