import java.util.concurrent.atomic.AtomicInteger;

public class 匹配占位 extends 抽象节点 {
    public static boolean 为站位(char 字) {
        return 字 == '.';
    }

    @Override
    public String toString() {
        return ".";
    }

    public boolean 为匹配站位() {
        return true;
    }

    @Override
    public boolean 匹配(流 节点流, String 新字符串, AtomicInteger 字符串指针, boolean 更新指针) {
        if (字符串指针.get() >= 新字符串.length()) {
            return false;
        }
        if (更新指针) {
            字符串指针.incrementAndGet();
        }
        return true;
    }

    public 匹配占位 转为匹配站位() {
        return this;
    }
}
