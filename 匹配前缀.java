import java.util.concurrent.atomic.AtomicInteger;

public abstract class 匹配前缀 extends  抽象节点{
    private 抽象节点 前缀;
    private char 匹配类型;

    @Override
    public boolean 匹配(流 节点流, String 新字符串, AtomicInteger 字符串指针) {
        if (!节点流.hasNext()) {
            字符串指针.set(新字符串.length());
            return true;
        }
        if (字符串指针.get() >= 新字符串.length()) {
            return false;
        }

        int 统计匹配次数 = 0;
        while (前缀.匹配(节点流, 新字符串, 字符串指针)) {
            if (字符串指针.get() >= 新字符串.length()) {
                return false;
            }
            统计匹配次数 ++;
        }

        if(为匹配零或多次()) {
            return true;
        }

        if(为匹配一或多次()){
            return 统计匹配次数>=1;
        }

        if(为匹配零或一次()){
            return 统计匹配次数<=1;
        }
        throw new RuntimeException("不支持的匹配类型："+this);
    }


    public 匹配前缀(抽象节点 前缀,char 匹配类型) {
        this.前缀 = 前缀;
        this.匹配类型 = 匹配类型;
    }

    @Override
    public String toString() {
        return 前缀 + "" +  匹配类型;
    }
}
