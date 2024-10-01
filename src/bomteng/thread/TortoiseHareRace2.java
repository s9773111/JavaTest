package bomteng.thread;

/**
 * 113/9/28 龜兔賽跑遊戲
 * 範例2 file:Tortoise, Hare, TortoiseHareRace2
 */
public class TortoiseHareRace2 {
    public static void main(String[] args) {
        var tortoise = new Tortoise(10);
        var hare = new Hare(10);
        var tortoiseThread = new Thread(tortoise);
        var hareThread = new Thread(hare);
        tortoiseThread.start();
        hareThread.start();
    }
}
