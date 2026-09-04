package bomteng.stream.test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 練習 stream groupingBy
 */
public class StreamTest3 {

    public static void main(String[] args) {
        test1(); // List<Map<String, Object>> 分組
        System.out.println();

        test2(); // Array 分組
        System.out.println();

        test3();// List分組 Collectors.summingInt
        System.out.println();

        test4();// 多層分組 | Map<key1, List<Bean Map<key2,>>>

    }

    static void test1() {
        // 1.模擬資料 有兩種類型 indexed, fixed
        // type, code, name, currency, rate
        List<Map<String, Object>> tempList = List.of(
                Map.of("type", "indexed", "code", "SP500", "name", "標普500", "currency", "USD", "rate", "5"),
                Map.of("type", "fixed", "code", "FX001", "name", "定存標的A", "currency", "TWD", "rate", "2"),
                Map.of("type", "indexed", "code", "NASQ", "name", "那斯達克", "currency", "USD", "rate", "8")
        );

        // 2.依照 type 分組
        Map<String, List<ProductLinkItemBean>> groupedItems = tempList.stream()
              .filter(Objects::nonNull)
              .filter(item->item.get("type") != null)
              .collect(Collectors.groupingBy(
                      item -> String.valueOf(item.get("type")),
                      Collectors.mapping(StreamTest3::converToBean, Collectors.toList())
        ));

        // 印出
        groupedItems.forEach((type, items) -> {
            System.out.println("分類 [" +type+"] 共有 " + items.size() + " 筆，資料為:");
            items.forEach(System.out::println);
        });
    }

    // Map 轉成 物件
    private static ProductLinkItemBean converToBean(Map<String, Object> linkItem) {
        ProductLinkItemBean bean = new ProductLinkItemBean();
        if (linkItem.get("code") != null) {
            bean.setCode(String.valueOf(linkItem.get("code")));
        }
        if (linkItem.get("name") != null) {
            bean.setLinkName(String.valueOf(linkItem.get("name")));
        }
        if (linkItem.get("currency") != null) {
            bean.setCurrency(String.valueOf(linkItem.get("currency")));
        }
        if (linkItem.get("rate") != null) {
            bean.setRate(String.valueOf(linkItem.get("rate")));
        }
        return bean;
    }


    static void test2() {
        // Array 結構分組
        // 將字串陣列依照 字串長度 自動歸類到不同List中
        String[] fruitsArray = {"Apple", "Banana", "Kiwi", "Orange", "Fig", "Mango", "Watermelon", "Guava", "Nut", "Pear", "Yuzu", "strawberry"};
        // 依照字串長度分類
        Map<Integer, List<String>> groupByLength = Arrays.stream(fruitsArray)
                .collect(Collectors.groupingBy(String::length));
        System.out.println("------練習1: Array 依長度分組 ------");
        groupByLength.forEach((len, list) ->
                System.out.println("長度:" + len + " 的水果是: " +list)
        );
    }

    static void test3() {
        // 從List<bean> 分組 並 加總總金額與計數
        List<Product> productList = List.of(
                new Product("P01", "indexed", 100),
                new Product("P02", "fixed", 200),
                new Product("P03", "indexed", 350),
                new Product("P04", "fixed", 150),
                new Product("P05", "indexed", 100)
        );

        // (1) 依照 type 分組並計算各組的 總金額
        Map<String, Integer>  sumAmountByType = productList.stream()
                .collect(Collectors.groupingBy(
                        Product::getType,
                        Collectors.summingInt(Product::getPrice)
                ));
        System.out.println("------練習2(1): 依 Type 分組並加總金額------");
        sumAmountByType.forEach((type, total) ->
                System.out.println("類型["+type+"], 總金額:" + total)
        );

        // (2) 依 Type 分組並計算各組 商品筆數
        Map<String, Long> countByType = productList.stream()
                .collect(Collectors.groupingBy(
                        Product::getType,
                        Collectors.counting()
                ));
        System.out.println("------練習2(2): 依 Type 分組並加計算數量------");
        countByType.forEach((type, count) ->
                System.out.println("類型["+type+"], 共有:" + count + "筆商品")
        );
    }

    static void test4() {
        // 找出各組中的「最高價商品」(groupingBy + maxBy)
        List<Product> productList = List.of(
                new Product("P01", "indexed", 100),
                new Product("P02", "fixed", 200),
                new Product("P03", "indexed", 350),
                new Product("P04", "fixed", 150),
                new Product("P05", "indexed", 100)
        );

        Map<String, Optional<Product>> maxPriceByType = productList.stream()
                .collect(Collectors.groupingBy(
                   Product::getType,
                   Collectors.maxBy(Comparator.comparingInt(Product::getPrice))
                ));

        System.out.println("------練習3: 各組中最高價的商品------");
        maxPriceByType.forEach((type, opProduct) ->
                opProduct.ifPresent(prod ->
                        System.out.println("類型["+type+"], 最高價商品:" + prod.getCode() + "(價格: " + prod.getPrice() + ")")
                )
        );
    }
}

class ProductLinkItemBean {
    private String code;
    private String linkName;
    private String currency;
    private String rate;

    public void setCode(String code) { this.code = code; }
    public void setLinkName(String linkName) { this.linkName = linkName; }
    public void setCurrency(String currency) { this.currency = currency; }
    public void setRate(String rate) { this.rate = rate; }

    @Override
    public String toString() {
        return "ProductLinkItemBean{code='" + code + "', linkName='" + linkName + "', currency='" + currency + "', rate='" + rate + "'}";
    }
}

class Product {
    private String code;
    private String type;
    private int price;

    public Product(String code, String type, int price) {
        this.code = code;
        this.type = type;
        this.price = price;
    }

    public String getCode() { return code; }
    public String getType() { return type; }
    public int getPrice() { return price; }
}
