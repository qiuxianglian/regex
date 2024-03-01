import java.util.concurrent.atomic.AtomicInteger;

public class 匹配一或多次 extends 抽象节点 {
    public static boolean 为星(char 字) {
        return 字 == '+';
    }

    @Override
    public String toString() {
        return "+";
    }

    public boolean 为匹配一或多次() {
        return true;
    }

    public 匹配一或多次 转为匹配一或多次() {
        return this;
    }

    @Override
    public boolean 匹配(流 节点流, String 新字符串, AtomicInteger 字符串指针) {
        return false;
    }
}