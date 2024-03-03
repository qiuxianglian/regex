import java.util.concurrent.atomic.AtomicInteger;

public class 匹配一或多次 extends 匹配前缀 {
    public static final char 名 = '+';

    public 匹配一或多次(抽象节点 前缀) {
        super(前缀, 名);
    }


    public boolean 为匹配一或多次() {
        return true;
    }

    public 匹配一或多次 转为匹配一或多次() {
        return this;
    }

}