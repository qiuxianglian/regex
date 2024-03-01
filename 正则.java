import java.util.concurrent.atomic.AtomicInteger;

public class 正则 {
    private final 抽象节点 抽象节点;

    public 正则(String 正则字符串) {
        抽象节点 = 解析器.解析(正则字符串);
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("使用方法: 正则命令 正则表达式 匹配目标");
            return;
        }
        String 表达式 = args[0];
        String 字符串 = args[1];
        正则 正则 = new 正则(表达式);
        System.out.println(正则.匹配(字符串));
    }

    public boolean 匹配(String 新字符串) {
        if (新字符串 == null) return false;
        AtomicInteger 字符串指针 = new AtomicInteger(0);
        return 抽象节点.匹配(抽象节点.入流(), 新字符串, 字符串指针);
    }
}
