package bomteng.Lambda.Book.B;

import java.util.Map;
import java.util.Optional;

/**
 * 使用 Optional 取代 null
 *  傳回Option<String>
 *
 *  Option.empty()
 *  Option.of()
 *  Option.isPresent()
 *  Option.orElse()
 *  Option.ofNullable()
 */
public class OptionTest_1 {

    public static void main(String[] args) {
        // old
        oldMethod();

        // 用Optional實例
        newMethod();

        newMethod2();
    }


    static void oldMethod() {
        var nickName = findNickName("Duke");
        if (nickName == null) {
            nickName = "No This People";
        }
        System.out.println(nickName);
    }

    static void newMethod() {
        // 此會噴錯 NoSuchElementException
        // var nickName = findNickName2("Duke").get();

        // var nickOptional = findNickName2("Duke");
        var nickOptional = findNickName2("Monica");
        var nickName = "No This People2";
        if (nickOptional.isPresent()) {
            nickName = nickOptional.get();
        }
        System.out.println(nickName);
    }

    static void newMethod2() {
        var nickOptional = findNickName3("Duke");
        // 比較好的方式
        System.out.println(nickOptional.orElse("No This Man3, orElse()"));
    }


    static String findNickName(String name) {
        // fake data
        var nickNames = Map.of(
            "Justin", "caterpillar",
            "Monica", "momor",
            "Irene", "hamimi"
        );
        return nickNames.get(name);
    }

    static Optional<String> findNickName2(String name) {
        // fake data
        var nickNames = Map.of(
                "Justin", "caterpillar",
                "Monica", "momor",
                "Irene", "hamimi"
        );
        var nickName = nickNames.get(name);

        return nickName == null ? Optional.empty() : Optional.of(nickName);
    }

    static Optional<String> findNickName3(String name) {
        var nickNames = Map.of(
                "Justin", "caterpillar",
                "Monica", "momor",
                "Irene","hamimi"
        );
        return Optional.ofNullable(nickNames.get(name));
    }
}
