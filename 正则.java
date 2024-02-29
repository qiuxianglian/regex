import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public class 正则 {

    public static void main(String[] args) {
        正则 正则 = new 正则("a*e?");
        System.out.println(正则.匹配("a7eq"));
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
}
