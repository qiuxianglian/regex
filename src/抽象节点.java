public abstract class 抽象节点{
//    abstract public boolean 匹配(String 字符串,int 始,int 终);

    public boolean 为节点列表(){
        return false;
    }

    public 节点列表 转为节点列表(){
        throw new RuntimeException("not impl");
    }

    public 匹配站位 转为匹配站位(){
        throw new RuntimeException("not impl");
    }

    public 匹配星 转为匹配星(){
        throw new RuntimeException("not impl");
    }

    public boolean 为匹配站位(){
        return false;
    }

    public 标志符节点 转为标志符节点(){
        throw new RuntimeException("not impl");
    }

    public boolean 为标志符节点(){
        return false;
    }

    public boolean 为匹配星(){
        return false;
    }

    abstract public 流 入流();
}
