package bomteng.Enum;

public class EnumMain {
    public static void main(String[] args) {
        //列舉一周
        for (Weekday day : Weekday.values()) {
            System.out.println("中文: " + day.getChineseName() + ", 英文: " + day.getEnglishName());
        }

        //查詢: 依據英文查找中文
        String chinese = Weekday.getChineseByEnglish("Monday");
        System.out.println("Monday 中文是: " + chinese);

        //查詢: 依據中文查找英文
        String english = Weekday.getEnglishByChinese("星期五");
        System.out.println("星期五 英文是: " + english);

        //找不到時
        String invalid = Weekday.getChineseByEnglish("Holiday");
        System.out.println("Holiday 中文是: " + invalid);
    }
}
