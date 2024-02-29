import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class 节点列表 extends 抽象节点 {
    private List<抽象节点> 抽象节点s;

    public 节点列表(List<抽象节点> 抽象节点s) {
        this.抽象节点s = 抽象节点s;
    }

    public 节点列表() {
        this.抽象节点s = new ArrayList<>();
    }

    public void 添加(抽象节点 抽象节点){
        抽象节点s.add(抽象节点);
    }

    public List<抽象节点> get抽象节点s() {
        return 抽象节点s;
    }



    @Override
    public String toString() {
        return 抽象节点s.stream().map(Object::toString).collect(Collectors.joining(""));
    }

    public boolean 为节点列表(){
        return true;
    }

    public 节点列表 转为节点列表(){
        return this;
    }

    @Override
    public 流 入流() {
        return new 流() {
            @Override
            public 抽象节点 peek() {
                if(hasNext()){
                    return  节点列表.this.抽象节点s.get(坐标);
                }
                return null;
            }

            private int 坐标 = 0;
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
}
