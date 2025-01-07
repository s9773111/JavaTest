package bomteng.Enum;

import lombok.Getter;

@Getter
public enum Weekday {
    SUNDAY("星期日", "Sunday"),
    MONDAY("星期一", "Monday"),
    TUESDAY("星期二", "Tuesday"),
    WEDENSDAY("星期三", "Wendesday"),
    THURSDAY("星期四", "Thursday"),
    FRIDAY("星期五", "Friday"),
    SATURDAY("星期六", "Saturday");

    private final String chineseName;
    private final String englishName;

    //建構子
    Weekday(String chineseName, String englishName) {
        this.chineseName = chineseName;
        this.englishName = englishName;
    }

    public String getChineseName() {
        return chineseName;
    }

    public String getEnglishName() {
        return englishName;
    }

    //靜態方法
    public static String getChineseByEnglish(String englishName) {
        for (Weekday day : Weekday.values()) {
            if (day.getEnglishName().equalsIgnoreCase(englishName)) {
                return day.getChineseName();
            }
        }
        return null;
    }

    public static String getEnglishByChinese(String chineseName) {
        for (Weekday day : Weekday.values()) {
            if (day.getChineseName().equals(chineseName)) {
                return day.getEnglishName();
            }
        }
        return null;
    }
}
