package bomteng.thread;

import java.util.List;

// file: RankHorse, Racing4
public class RankHorse extends Thread {
    private String horsename;
    private List<RankHorse> rank;

    // 建構子 馬的名字與排名集合傳入
    public RankHorse(String horsename, List<RankHorse> rank) {
        this.horsename = horsename;
        this.rank = rank;
    }

    // 執行馬跑步模擬邏輯
    public void run() {
        try {
            // 模擬馬跑步時間
            double runTime = Math.random();
            System.out.println(horsename + ", 跑步時間：" + runTime);
            Thread.sleep((long) (runTime * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 馬到達終點後，加入到排名集合
        synchronized (rank) {
            rank.add(this);
            System.out.println("rank數量：" + rank.size());
        }
    }

    public String getHorseName() {
        return horsename;
    }
}
