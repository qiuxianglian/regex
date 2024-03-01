import java.util.concurrent.atomic.AtomicInteger;

public class 匹配标志符 extends 抽象节点 {
    private final String 字符串值;

    public 匹配标志符(String 字符串值) {
        this.字符串值 = 字符串值;
    }

    public static boolean 为标志符(char 字) {
        return !匹配零或多次.为星(字) && !匹配占位.为站位(字);
    }

    public String get字符串值() {
        return 字符串值;
    }

    @Override
    public String toString() {
        return 字符串值;
    }

    public 匹配标志符 转为标志符节点() {
        return this;
    }

    public boolean 为标志符节点() {
        return true;
    }

    @Override
    public boolean 匹配(流 节点流, String 新字符串, AtomicInteger 字符串指针) {
        String 字符串值 = this.get字符串值();
        for (int i = 0; i < 字符串值.length(); i++) {
            if (字符串指针.get() >= 新字符串.length()) {
                return false;
            }

            if (字符串值.charAt(i) == 新字符串.charAt(字符串指针.get())) {
                字符串指针.incrementAndGet();
            } else {
                return false;
            }
        }
        return true;
    }
}
