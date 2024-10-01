package bomteng.thread;

/**
 * 113/9/28 龜兔賽跑遊戲
 * 範例2 file:Tortoise, Hare, TortoiseHareRace2
 */
public class Tortoise implements Runnable {

    private int totalStep;
    private int step;

    public Tortoise(int totalStep) {
        this.totalStep = totalStep;
    }

    @Override
    public void run() {
        while(step<totalStep) {
            step++;
            System.out.printf("烏龜跑了 %d 步...%n", step);
        }
    }
}
