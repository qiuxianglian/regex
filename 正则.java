import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class 正则 {

    public static void main(String[] args) {
        if(args.length<2){
            System.out.println("使用方法: 正则命令 正则表达式 匹配目标");
            return;
        }
        正则 正则 = new 正则( args[0]);
        System.out.println(正则.匹配(args[1]));
    }

    private final String 正则字符串;
    private 抽象节点 抽象节点;

    public 正则(String 正则字符串) {
        this.正则字符串 = 正则字符串;
        编译();
    }

    public 正则 编译(){
        抽象节点 = 解析器.解析(正则字符串);
        return this;
    }

    public boolean 匹配(String 新字符串){
        if(新字符串 == null){
            return false;
        }

        AtomicInteger 字符串指针 = new AtomicInteger(0);

        抽象节点 当前位 = 抽象节点;
        流 节点流 = 当前位.入流();
        while (节点流.hasNext()){
            if(字符串指针.get()>=新字符串.length()){
                return false;
            }

            抽象节点 节点 = 节点流.next();
            if(!匹配节点(节点,节点流,新字符串,字符串指针,true)){
                return false;
            }

        }
        return true;
    }

    private boolean 匹配节点(抽象节点 节点,流 节点流,String 新字符串,AtomicInteger 字符串指针,boolean 更新指针){
        if(节点 == null) return true;
        if(节点.为标志符节点()){
            return 匹配标志符节点(节点.转为标志符节点(), 节点流, 新字符串, 字符串指针, 更新指针);
        }else if(节点.为匹配星()){
            return 匹配星节点(节点.转为匹配星(), 节点流, 新字符串, 字符串指针, 更新指针);
        }else if(节点.为匹配站位()){
            return 匹配站位节点(节点.转为匹配站位(), 节点流, 新字符串, 字符串指针, 更新指针);
        }

        return true;
    }

    private boolean 匹配标志符节点(标志符节点 标志符节点,流 节点流,String 新字符串,AtomicInteger 字符串指针,boolean 更新指针){
        int 备份指针 = 字符串指针.get();
        String 字符串值 = 标志符节点.get字符串值();
        for (int i = 0; i < 字符串值.length(); i++) {
            if(备份指针>=新字符串.length()){
                return false;
            }

            if(字符串值.charAt(i) == 新字符串.charAt(字符串指针.get())){
                备份指针++;
            }else{
                return false;
            }
        }
        if(更新指针){
            字符串指针.set(备份指针);
        }
        return true;
    }
    private boolean 匹配星节点(匹配星 匹配星节点,流 节点流,String 新字符串,AtomicInteger 字符串指针,boolean 更新指针){
        AtomicInteger 备份指针 = new AtomicInteger(字符串指针.get());
        if(!节点流.hasNext()){
            return true;
        }
        if(字符串指针.get()>=新字符串.length()){
            return false;
        }
        抽象节点 下节点 = 节点流.peek();
        while (!匹配节点(下节点,节点流,新字符串, 备份指针,false)){
            if(备份指针.get() >= 新字符串.length()){
                return false;
            }
            备份指针.incrementAndGet();

        }
        if(更新指针){
            字符串指针.set(备份指针.get());
        }

        return true;
    }



    private boolean 匹配站位节点(匹配站位 匹配站位节点,流 节点流,String 新字符串,AtomicInteger 字符串指针,boolean 更新指针){
        if(字符串指针.get()>=新字符串.length()){
            return false;
        }
        if(更新指针){
            字符串指针.incrementAndGet();
        }

        return true;
    }

    public static class 解析器 {
        private String 正则字符串;

        public 解析器(String 正则字符串) {
            this.正则字符串 = 正则字符串;
        }
        private class 标志符累积器 {
            private StringBuffer 累积器;
            private boolean 开关 = false;

            public 标志符累积器() {
                this.累积器 = new StringBuffer();
            }

            public void 开(){
                this.开关 = true;
            }
            public void 关(){
                this.开关 = false;
            }

            public void 累积(char 字){
                if(开关){
                    累积器.append(字);
                }
            }
            public void 导出到(节点列表 节点列表){
                this.关();
                if(!累积器.isEmpty()){
                    String 阶段结果 = 累积器.toString();
                    累积器 =  new StringBuffer();
                    节点列表.添加(new 标志符节点(阶段结果));
                }
            }
        }

        public static 抽象节点 解析(String 字符串){
            return new 解析器(字符串).翻译();
        }

        public 抽象节点 翻译(){
            节点列表 节点列表 = new 节点列表();
            标志符累积器 累积器 = new 标志符累积器();
            for(int i=0;i<正则字符串.length();i++){
                char 字 = 正则字符串.charAt(i);
                if(匹配星.为星(字)){
                    累积器.导出到(节点列表);
                    节点列表.添加(new 匹配星());
                }else if(匹配站位.为站位(字)){
                    累积器.导出到(节点列表);
                    节点列表.添加(new 匹配站位());
                }else{
                    累积器.开();
                    累积器.累积(字);
                }
            }
            累积器.导出到(节点列表);
            return 节点列表;
        }


    }

    public static interface 流 extends Iterator<抽象节点> {
        抽象节点 peek();
    }

    public abstract static class 抽象节点{

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


    public static class 节点列表 extends 抽象节点 {
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

    public static class 标志符节点 extends 抽象节点 {
        private final String 字符串值;

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
                    take = true;
                    return 标志符节点.this;
                }
            };
        }
    }


    public static class 匹配站位 extends 正则.抽象节点 {
        public static boolean 为站位(char 字){
            return 字=='?';
        }
        @Override
        public String toString() {
            return "?";
        }


        public boolean 为匹配站位(){
            return true;
        }
        public 匹配站位 转为匹配站位(){
            return this;
        }

        @Override
        public 流 入流() {
            return new 流() {
                private boolean take = false;
                @Override
                public 正则.抽象节点 peek() {
                    if(hasNext()){
                        return 匹配站位.this;
                    }
                    return null;
                }

                @Override
                public boolean hasNext() {
                    return !take;
                }

                @Override
                public 正则.抽象节点 next() {
                    take = true;
                    return 匹配站位.this;
                }
            };
        }
    }

    public static class 匹配星 extends 正则.抽象节点 {
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
                public 正则.抽象节点 peek() {
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
                public 正则.抽象节点 next() {
                    take = true;
                    return 匹配星.this;
                }
            };
        }
    }
}
