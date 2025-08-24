package bomteng.Lambda.Book.A;

/**
 * 114/8/23 Ch12
 * 12.1 認識Lambda語法 2
 *
 */
public class StringOrder {
    public static int byLength(String s1, String s2) {
        return s1.length() - s2.length();
    }

    public static int byLexicography(String s1, String s2) {
        return s1.compareTo(s2);
    }

    public static int byLexicographyIgnoreCase(String s1, String s2) {
        return s1.compareToIgnoreCase(s2);
    }
}
