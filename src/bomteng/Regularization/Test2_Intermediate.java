package bomteng.Regularization;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2_Intermediate {
    public static void main(String[] args) {

        // 抓出 yyyy-mm-dd 的日期格式
        findDate();

        // 移除<script>標籤
        clearText();
    }

    public static void findDate() {
        String input = "今天是 2025-04-26，昨天是 2025-04-25，錯誤格式是 25-04-2025";
        // ( ... )：將日期包成一個群組，matcher.group(1) 會抓出來用
        // 建立 Pattern 物件，表示正則規則
        Pattern pattern = Pattern.compile("\\b(\\d{4}-\\d{2}-\\d{2})\\b");

        // 透過 Pattern 建立 matcher，目標字串是 input
        Matcher matcher = pattern.matcher(input);

        // 判斷是否找到了
        if (matcher.find()) {
            System.out.println("V 有找到符合日期的格式!");
            // 因 .fin() 已移動過，要先印出第一個匹配
            System.out.println("第 1 個日期：" + matcher.group(1));

            // 找出剩餘的匹配結果
            int count = 2;
            while (matcher.find()) {
                System.out.println("第 " + count + " 個日期：" + matcher.group(1));
                count++;
            }
        } else {
            System.out.println("x 沒有找到符合日期格式！");
        }

        // 總共找到幾個
        matcher.reset();
        int total = 0;
        while (matcher.find()) {
            total++;
        }
        System.out.println("總共找到 " + total + " 筆日期!");
    }

    public static void clearText() {
        String html ="<script type=\"text/javascript\">alert('XSS')</script><p>Hello World!</p>";
        System.out.println("本來的html內容：" + html);

        // <script.*?> 包含標籤
        String sanitized = html.replaceAll("(?i)<script.*?>.*?</script>", "");
        System.out.println("遮蔽的html內容：" + sanitized);
    }
}
