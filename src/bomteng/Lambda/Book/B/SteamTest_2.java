package bomteng.Lambda.Book.B;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Stream 與 Lambda
 *   Stream: 來源、中介操作(聚合操作)、最終操作
 *   .filter
 *   .map
 *   .collect
 *   .forEach
 *
 *
 */
public class SteamTest_2 {
    public static void main(String[] args) {
        // 舊有範例
        oldMethod();

        streamMethod();

        // reduce collect
        streamMethod2();
    }

    static void oldMethod() {
        var players = List.of(
                new Player("Justin", 30),
                new Player("Monica", 39),
                new Player("Irene", 3),
                new Player("Isaac", 15)
        );

        List<String> names = new ArrayList<>();
        for (Player player : players) {
            if (player.age() > 15) {
                names.add(player.name().toUpperCase());
            }
        }

        for(String name : names) {
            System.out.println(name);
        }
    }

    static void streamMethod() {
        var players = List.of(
                new Player("Justin", 30),
                new Player("Monica", 39),
                new Player("Irene", 3),
                new Player("Isaac", 15)
        );

        // stream只能迭代一次
        players.stream()
                .filter(player -> player.age() < 18)
                .map(Player::name)
                .map(String::toUpperCase)
                .collect(toList())
                //.forEach(System.out::print);
                .forEach(s -> System.out.print(s + " "));
    }

    static void streamMethod2() {
        
    }
}

record Player(String name, Integer age){}
