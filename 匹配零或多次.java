import java.util.concurrent.atomic.AtomicInteger;

public class 匹配零或多次 extends 抽象节点 {
    public static boolean 为星(char 字) {
        return 字 == '*';
    }

    @Override
    public String toString() {
        return "*";
    }

    public boolean 为匹配零或多次() {
        return true;
    }

    @Override
    public boolean 匹配(流 节点流, String 新字符串, AtomicInteger 字符串指针, boolean 更新指针) {
        AtomicInteger 备份指针 = new AtomicInteger(字符串指针.get());
        if (!节点流.hasNext()) {
            return true;
        }
        if (字符串指针.get() >= 新字符串.length()) {
            return false;
        }
        抽象节点 下节点 = 节点流.peek();
        while (!下节点.匹配(节点流, 新字符串, 备份指针, false)) {
            if (备份指针.get() >= 新字符串.length()) {
                return false;
            }
            备份指针.incrementAndGet();

        }
        if (更新指针) {
            字符串指针.set(备份指针.get());
        }

        return true;
    }

    public 匹配零或多次 转为匹配零或多次() {
        return this;
    }
}
