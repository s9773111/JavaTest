package bomteng.thread;

import java.util.ArrayList;
import java.util.List;

// file: Racing4, RankHorse
public class Racing4 {
    public static void main(String[] args) {
        List<RankHorse> rank = new ArrayList<>();

        //建立三個執行緒 傳入rank
        RankHorse h1 = new RankHorse("h1", rank);
        RankHorse h2 = new RankHorse("h2", rank);
        RankHorse h3 = new RankHorse("h3", rank);

        //啟動
        h1.start();
        h2.start();
        h3.start();

        // 等待所有馬完成比賽
        try {
            h1.join();
            h2.join();
            h3.join();
        } catch (InterruptedException e) {
            System.out.println("執行緒被中斷");
        }

        // 比賽結束後 列出排名結果
        System.out.println("比賽排名結果：");
        for (int i=0; i < rank.size(); i++) {
            System.out.println("第 " + (i+1) + " 名：" + rank.get(i).getHorseName());
        }
        System.out.println("main 執行緒結束");
    }
}
