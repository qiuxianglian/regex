public class 标志符节点 extends 抽象节点 {
    private String 字符串值;

    public 标志符节点(String 字符串值) {
        this.字符串值 = 字符串值;
    }

    public String get字符串值() {
        return 字符串值;
    }

    @Override
    public String toString() {
        return 字符串值;
    }

    public static boolean 为标志符(char 字){
        return !匹配星.为星(字) && !匹配站位.为站位(字);
    }

    public 标志符节点 转为标志符节点(){
        return this;
    }

    public boolean 为标志符节点(){
        return true;
    }

    @Override
    public 流 入流() {
        return new 流() {
            private boolean take = false;
            @Override
            public 抽象节点 peek() {
                if(hasNext()){
                    return 标志符节点.this;
                }
                return null;
            }

            @Override
            public boolean hasNext() {
                return !take;
            }

            @Override
            public 抽象节点 next() {
                return 标志符节点.this;
            }
        };
    }
}


