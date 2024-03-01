import java.util.concurrent.atomic.AtomicInteger;

public class 匹配零或一次 extends 匹配前缀 {
    public static final char 名 = '?';

    public 匹配零或一次(抽象节点 前缀) {
        super(前缀, 名);
    }

    public boolean 为匹配零或一次() {
        return true;
    }

    public 匹配零或一次 转为匹配零或一次() {
        return this;
    }

}