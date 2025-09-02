package bomteng.Lambda.Network;

/**
 * 認識lambda語法
 *  「Lambda vs 匿名類別的 this 差異」 -> 產生編譯檔案名稱差異
 *   1.Lambda 不建立新的 this；this 來自外層 | 產生編譯檔案會是類別名稱
 *   2.匿名內部類別會有自己的 this  | 會產生獨立 .class
 *      如果是內部(Inner)的非匿名類別，
 *      則會以$為分隔字元，表示類別在哪層類別之下，
 *      作為.class檔案的檔名
 */
public class LambdaTest3 {
    public static void main(String[] args) {
        new LambdaTest3().demo();

    }

    //實體方法
    void demo(){
        Runnable r1 = () -> System.out.println("r1: " + this.getClass());

        Runnable r2 = new Runnable(){
            public void run(){
                System.out.println("r2: " + this.getClass());
            }
        };

        new Thread(r1).start();
        new Thread(r2).start();
    }
}
