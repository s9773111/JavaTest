package bomteng.thread;

/**
 * 113/9/28 龜兔賽跑遊戲
 * 範例1
 */
public class TortoiseHareRace {
    public static void main(String[] args) {
        boolean[] flags = {true, false};
        var totalStep = 10;
        var tortoiseStep = 0;
        var hareStep = 0;

        System.out.println("龜兔賽跑開始...");
        while (tortoiseStep < totalStep && hareStep < totalStep) {
            tortoiseStep++;
            System.out.printf("烏龜跑了 %d 步...%n", tortoiseStep);
            // 隨機產生 0或1
            var isHareSleep = flags[((int) (Math.random() * 10)) % 2];
            if (isHareSleep) {
                System.out.println("兔子睡著了 zzzz");
            } else {
                hareStep += 2;
                System.out.printf("兔子跑了 %d 步...%n", hareStep);
            }
        }
    }
}
