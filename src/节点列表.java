import java.util.ArrayList;
import java.util.List;

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
}
