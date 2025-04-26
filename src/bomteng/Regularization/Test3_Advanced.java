package bomteng.Regularization;

public class Test3_Advanced {
    public static void main(String[] args) {
        sanitizedPwd();

        sanitizedManyText();
    }
    public static void sanitizedPwd() {
        String result = "{\"password\":\"123456\",\'email\':\'test@example.com\',\"pwd\":\"7777777\", \"pwd\":\"777\", \"pwd\":888, \"pwd\":777}";
        System.out.println("Pwd原內容：" + result);
        //result = result.replaceAll("(\"|')?(password|pwd)(\"|')?\\s*:\\s*(\"|')?[^\"',\\s]+(\"|')?","$1$2$3:*****");
        result = result.replaceAll("(\"|')?(password|pwd)(\"|')?\\s*:\\s*(\"[^\"]*\"|'[^']*'|[^\"',\\s}\\]]+)","$1$2$3:*****");
        System.out.println("Pwd遮蔽後：" + result);
    }
    public static void sanitizedManyText() {
        String result = "{\"password\":\"123456\",\'email\':\'test@example.com\',\"pwd\":\"7777777\", \"pwd\":\"777\", \"pwd\":888, \"pwd\":777}";
        System.out.println("ManyText原內容:" + result);
        result = result.replaceAll(
                "(?i)([\"']?(password|pwd|secret|ssn|token|sessionId|certiCode|mobilePhone|toAddress|email|address)[\"']?\\s*[:=]\\s*)([\"']?)[^\",\\s}]+([\"'])?",
                "$1***"
        );
        System.out.println("ManyText遮蔽後:" + result);
    }
}
