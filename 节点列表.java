import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class 节点列表 extends 抽象节点 {
    private final List<抽象节点> 抽象节点s;

    public 节点列表(List<抽象节点> 抽象节点s) {
        this.抽象节点s = 抽象节点s;
    }

    public 节点列表() {
        this.抽象节点s = new ArrayList<>();
    }

    public void 添加(抽象节点 抽象节点) {
        抽象节点s.add(抽象节点);
    }

    public List<抽象节点> get抽象节点s() {
        return 抽象节点s;
    }


    @Override
    public String toString() {
        return 抽象节点s.stream().map(Object::toString).collect(Collectors.joining(""));
    }

    public boolean 为节点列表() {
        return true;
    }

    public 节点列表 转为节点列表() {
        return this;
    }

    @Override
    public 流 入流() {
        return new 流() {
            private int 坐标 = 0;

            @Override
            public 抽象节点 预览() {
                if (hasNext()) {
                    return 节点列表.this.抽象节点s.get(坐标);
                }
                return null;
            }

            @Override
            public 抽象节点 回顾() {
                return 坐标 < 2 ? null : 节点列表.this.抽象节点s.get(坐标-2);
            }

            @Override
            public 抽象节点 last() {
                if(坐标 == 0){
                    return null;
                }
                坐标 -- ;
                return 节点列表.this.抽象节点s.get(坐标);
            }


            @Override
            public boolean hasNext() {
                return 坐标 < 节点列表.this.抽象节点s.size();
            }

            @Override
            public 抽象节点 next() {
                抽象节点 抽象节点 = 节点列表.this.抽象节点s.get(坐标);
                坐标++;
                return 抽象节点;
            }
        };
    }

    @Override
    public boolean 匹配(流 _节点流, String 新字符串, AtomicInteger 字符串指针) {
        流 节点流 = this.入流();
        while (节点流.hasNext()) {
            if (字符串指针.get() >= 新字符串.length()) {
                return false;
            }
            抽象节点 节点 = 节点流.next();
            if (!节点.匹配(节点流, 新字符串, 字符串指针)) {
                return false;
            }
        }
        return 字符串指针.get() >= 新字符串.length();
    }
}