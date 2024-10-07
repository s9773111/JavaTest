package bomteng.thread;

import java.util.concurrent.ThreadLocalRandom;

public class LiveLockWeb2 {
    static class Spoon {
        private Diner owner;

        public Spoon(Diner owner) {
            this.owner = owner;
        }

        public Diner getOwner() {
            return owner;
        }

        public synchronized void use() {
            System.out.println(owner.name + " is using the spoon.");
        }

        // 解決livelock 活鎖狀況: 增加此方法
        public synchronized void setOwner(Diner owner) {
            this.owner = owner;
        }
    }

    static class Diner {
        private String name;
        private boolean isHungry;

        public Diner(String name) {
            this.name = name;
            this.isHungry = true;
        }

        public boolean isHungry() {
            return isHungry;
        }

        public String getName () {
            return name;
        }

        // livelock 活鎖狀況
//        public void eatWith(Spoon spoon, Diner spouse) {
//            System.out.println("進入eatWith 餓了嗎？" + isHungry());
//            while (isHungry) {
//                // 不同人 就會 sleep | spoon.getOwner()當前擁有者,
//                // this 就是當前的Diner
//                if (spoon.getOwner() != this ) {
//                    try {
//                        System.out.println("湯匙的持有者不是當前此人並等待 Diner, spoon持有者：" + spoon.getOwner().getName() +", 現在吃晚餐的人是："+this.getName());
//                        Thread.sleep(3000); // wait for the spoon
//                    } catch (InterruptedException e) {
//                    }
//                    continue;
//                }
//
//                if(spouse.isHungry()) {
//                    System.out.println(name + ": You eat first.");
//                    spoon.use();
//                    continue;
//                }
//
//                spoon.use(); //Eat
//                isHungry = false;
//                System.out.println(name + " : I am no longer hungry.");
//            }
//        }

        // 解決 livelock 活鎖狀況
        public void eatWith(Spoon spoon, Diner spouse) {
            System.out.println("進入eatWith 餓了嗎？" + isHungry());
            // 加入 讓步次數限制
            int letPassCount = 0;
            while (isHungry) {
                if (spoon.getOwner() != this ) {
                    try {
                        System.out.println("湯匙的持有者不是當前此人並等待 Diner, spoon持有者：" + spoon.getOwner().getName() +", 現在吃晚餐的人是："+this.getName());

                        Thread.sleep(1000); // wait for the spoon
                    } catch (InterruptedException e) {
                    }
                    continue;
                }

                if(spouse.isHungry() && letPassCount < 3) { //加入讓步次數限制
                    System.out.println(name + ": You eat first. 已經讓步了："+letPassCount + "次。");
                    letPassCount++;
                    try {
                        // 隨機等待時間
                        Thread.sleep(ThreadLocalRandom.current().nextInt(10, 100));
                    }catch(InterruptedException e) {
                    }
                    continue;
                }
                spoon.use(); //Eat
                isHungry = false;
                System.out.println(name + " : I am no longer hungry.");
                spoon.setOwner(spouse);
            }
        }
    }

    public static void main(String[] args) {
        final Diner husband = new Diner("Husband");
        final Diner wife = new Diner("Wife");
        final Spoon spoon = new Spoon(husband);

        new Thread(()-> husband.eatWith(spoon, wife)).start();
        new Thread(()-> wife.eatWith(spoon, husband)).start();
    }
}
