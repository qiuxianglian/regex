import java.util.concurrent.atomic.AtomicInteger;

public abstract class 抽象节点 {

    public boolean 为节点列表() {
        return false;
    }

    public 节点列表 转为节点列表() {
        throw new RuntimeException("not impl");
    }

    public 匹配占位 转为匹配站位() {
        throw new RuntimeException("not impl");
    }

    public 匹配零或多次 转为匹配零或多次() {
        throw new RuntimeException("not impl");
    }

    public boolean 为匹配站位() {
        return false;
    }

    public 匹配标志符 转为标志符节点() {
        throw new RuntimeException("not impl");
    }

    public boolean 为标志符节点() {
        return false;
    }

    public boolean 为匹配零或多次() {
        return false;
    }

    public boolean 为匹配一或多次() {
        return false;
    }

    public 匹配一或多次 转为匹配一或多次() {
        throw new RuntimeException("not impl");
    }

    public boolean 为匹配零或一次() {
        return false;
    }

    public 匹配零或一次 转为匹配零或一次() {
        throw new RuntimeException("not impl");
    }

    public 流 入流() {
        return 单字流(this);
    }

    abstract public boolean 匹配(流 节点流, String 新字符串, AtomicInteger 字符串指针);


    protected 流 单字流(抽象节点 节点) {
        return new 流() {
            private boolean take = false;

            @Override
            public 抽象节点 peek() {
                if (hasNext()) {
                    return 节点;
                }
                return null;
            }

            @Override
            public boolean hasNext() {
                return !take;
            }

            @Override
            public 抽象节点 next() {
                take = true;
                return 节点;
            }
        };

    }


}

