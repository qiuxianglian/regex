import java.util.concurrent.atomic.AtomicInteger;

public class 匹配括号 extends  抽象节点{
    private 抽象节点 括号内容;
    @Override
    public boolean 匹配(流 节点流, String 新字符串, AtomicInteger 字符串指针) {

        return false;
    }

    @Override
    public String toString() {
        return "(" +
                括号内容 +
                ')';
    }
}
