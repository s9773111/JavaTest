package bomteng.optional.test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * 2026/2/3
 * Optional 基礎
 * GPT 基礎
 */
public class OptionalTest0 {
    public static void main(String[] args) {
        //Test1(); // 建立 Optional
        System.out.println("-----------------------");

        //Test2(); // 認識orElse, orElseGet差異
        System.out.println("-----------------------");

        //Test3(); // map/filter 常見字串處理
        System.out.println("-----------------------");

        //Test4(); //flatMap(當map之後又是Optional)
        System.out.println("-----------------------");

        //Test5(); // orElseThrow
        System.out.println("-----------------------");

        //Test6(); // isPresent + get, ifPresent
        System.out.println("-----------------------");

        Test7(); // 科學記號 專案遇到
        System.out.println("-----------------------");

    }

    public static void Test1(){
        System.out.println("[Test1 建立 Optional]");
        // 1. of: 確定值 不為 null 時使用
        Optional<String> a = Optional.of("Hello");
        // 2. ofNullable: 值可能是 null
        Optional<String> b = Optional.ofNullable(null);
        // 3. empty: 直接建立一個 空 Optional
        Optional<String> c = Optional.empty();

        System.out.println("直接打印 Optional 物件:");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        System.out.println();

        System.out.println("打印2 ifPresent：");
        // ifPresent(...) 是Consumer
        // void ifPresent(Consumer<? super T> action), Consumer<String>
        a.ifPresent(System.out::println);
        b.ifPresent(System.out::println);
        c.ifPresent(System.out::println);

        System.out.println();

        System.out.println("打印3 orElse()");
        System.out.println(a.orElse("a空的！！"));
        System.out.println(b.orElse("b空的！！"));
        System.out.println(c.orElse("c空的！！"));
    }

    public static void Test2(){
        System.out.println("[Test2 orElse vs orElseGet 差異]");
        // orElse(x)：先把 x 算好，再看要不要用
        // orElseGet(() -> x)：需要時才算
        Optional<String> opt = Optional.of("OK");

        System.out.println("--- orElse ---");
        String a = opt.orElse(expensiveCompute());
        System.out.println("result=" + a);

        System.out.println("--- orElseGet 1 ---");
        // Supplier<T> | ()->xxxx()
        String b= opt.orElseGet(() -> expensiveCompute());
        System.out.println("result=" + b);

        System.out.println("--- orElseGet 2 ---");
        String c = opt.orElseGet(OptionalTest0::expensiveCompute);
        System.out.println("result=" + c);
    }

    static String expensiveCompute() {
        System.out.println("！！ expensiveCompute executed!");
        return "DEFAULT";
    }

    static void Test3() {
        System.out.println("[Test3 map 使用情境]");
        Optional<String> name1 = Optional.of("  Isaac  ");
        Optional<String> name2 = Optional.of("     ");
        Optional<String> name3 = Optional.empty();

        System.out.println("原值:" + name1 + ", " + name2 + ", " + name3);
//        name1.ifPresent( v -> System.out.println("name1 = " + v));
//        name2.ifPresent( v -> System.out.println("name2 = " + v));
//        name3.ifPresent( v -> System.out.println("name3 = " + v));
        System.out.println("name1: " + name1.orElse("null"));
        System.out.println("name2: " + name2.orElse("null"));
        System.out.println("name3: " + name3.orElse("null"));

        // map 轉換(去空白->轉大寫)
        // map: <U> Optional<U> map(Function<? super T, ? extends U> mapper)
        // map 要的是Function<T, U>, Function<String, String>
        String trimmedUpper = name1.map(String::trim)
                                   .map(String::toUpperCase)
                                   .orElse("Unknown");
        System.out.println("map 後:" + trimmedUpper);

        // filter 過濾條件
        // filter(Predicate<? super T> predicate)
        String n2 = name2.map(String::trim)
                         .filter(s -> !s.isEmpty()) // 若去空白為空，則變為Optional.empty
                         .orElse("EMPTY-NAME");
        System.out.println("filter: " + n2);

        String n3 = name3.map(String::trim).orElse("No-value");
        System.out.println("empty: " + n3);
    }

    static void Test4() {
        System.out.println("[Test4 flatMap 使用情境]");

        User u1 = new User("A01"); // 有地址,zip
        User u2 = new User("B02"); // 有地址,zip為null
        User u3 = new User("C03"); // 無地址,zip

        /**
         * 關鍵差異：
         * findAddressByUser 回傳的是 Optional<Address>
         * 如用 map: 結果會變成 Optional<Optional<Address>> 包2層難用
         * 如用 flatMap: 結果會變成 Optional<Address> 攤平變1層
         */

        // 案例1:一路順暢找到 zip
        // 假設：查 Address 可能找不到(回傳Optional)
        // 第一種表達方式
        /*
        Optional<String> zip1 = Optional.of(u1)
                .flatMap(OptionalTest0::findAddressByUser)
                .flatMap(OptionalTest0::findZipByAddress);
        System.out.println("user u1 zip = " + zip1.orElse("NO-ZIP"));
        */

        // 第二種表達方式
        String zip11 = Optional.of(u1)
                .flatMap(OptionalTest0::findAddressByUser)
                .flatMap(OptionalTest0::findZipByAddress)
                .orElse("查無 ZIP");
        System.out.println("user u1 zip = " + zip11);

        // 案例2: 地址中有zip是null
        String zip2 = Optional.of(u2)
                .flatMap(OptionalTest0::findAddressByUser)
                .flatMap(OptionalTest0::findZipByAddress)
                .orElse("查無 ZIP");
        System.out.println("user u2 zip = " + zip2);

        // 案例3: 連地址都沒有
        String zip3 = Optional.of(u3)
                .flatMap(OptionalTest0::findAddressByUser)
                .flatMap(OptionalTest0::findZipByAddress)
                .orElse("查無 ZIP");
        System.out.println("user u3 zip = " + zip3);
    }

    static Optional<Address> findAddressByUser(User user) {
        // A01有地址
        // B02有地址但 zip null
        // 非上述的使用者就是回傳empty
        if ("A01".equals(user.id))
            return Optional.of(new Address("220"));
        if ("B02".equals(user.id))
            return Optional.of(new Address(null));
        return Optional.empty();
    }

    static Optional<String> findZipByAddress(Address address) {
        return Optional.ofNullable(address.zip);
    }

    // Demo Classes
    static class User {
        final String id;
        User(String id) {
            this.id = id;
        }
    }

    static class Address {
        final String zip;
        Address(String zip) {
            this.zip = zip;
        }
    }

    static void Test5() {
        System.out.println("[Test5 orElseThrow 使用情境]");
        // orElseThrow 若找不到就視為錯誤 | X99, A01
        Optional<User> maybeUser = findUser("A01");
        try {
            User u = maybeUser.orElseThrow(() -> new IllegalArgumentException("User not found: X99"));
            System.out.println("Found user: " + u.id);
        } catch (Exception e) {
            System.out.println("Caught: " + e);
        }



    }

    static Optional<User> findUser(String id) {
        if("A01".equals(id))
            return Optional.of(new User("A01"));
        return Optional.empty();
    }


    static void Test6() {
        System.out.println("[Test6 isPresent/get ifPresent 使用情境]");
        Optional<String> opt = Optional.of("OK");
        Optional<String> empty = Optional.empty();

        // 不推薦使用
        if (opt.isPresent())
            System.out.println("opt.get() = " + opt.get());

        try {
            System.out.println("empty.get() = " + empty.get());
        } catch (Exception e) {
            System.out.println("Caught: " + e);
        }
        System.out.println();

        // 推薦寫法1 orElse
        System.out.println("推薦寫法:");
        System.out.println("empty.orElse = " + empty.orElse("DEFAULT"));
        opt.ifPresent(System.out::println);
        opt.ifPresent(v -> System.out.println("opt = " + v));


    }

    static void Test7() {
        System.out.println("[Test7 科學記號 使用情境]");
        Map<String, Object> planFactors = new HashMap<>();
        planFactors.put("GP_PAYMENT", new BigDecimal("12340000000000000000000"));
        planFactors.put("GP_ANNUALIZED", 1.238E8); // Double 科學記號

        System.out.println("GP_PAYMENT = " + toPlainStringOrEmpty(planFactors.get("GP_PAYMENT")));
        System.out.println("GP_ANNUALIZED = " + toPlainStringOrEmpty(planFactors.get("GP_ANNUALIZED")));
        System.out.println("GP_X(missing) = " + toPlainStringOrEmpty(planFactors.get("GP_X")));
    }

    static String toPlainStringOrEmpty(Object v) {
        return Optional.ofNullable(v)
                .map(x -> new BigDecimal(x.toString()).toPlainString())
                .orElse("");
    }
}
