public class 匹配星 extends 抽象节点 {
    public static boolean 为星(char 字){
        return 字=='*';
    }
    @Override
    public String toString() {
        return "*";
    }


    public boolean 为匹配星(){
        return true;
    }
    public 匹配星 转为匹配星(){
        return this;
    }

    @Override
    public 流 入流() {
        return new 流() {
            private boolean take = false;
            @Override
            public 抽象节点 peek() {
                if(hasNext()){
                    return 匹配星.this;
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
                return 匹配星.this;
            }
        };
    }
}
