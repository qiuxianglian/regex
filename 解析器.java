public class 解析器 {
    private final String 正则字符串;

    public 解析器(String 正则字符串) {
        this.正则字符串 = 正则字符串;
    }

    public static 抽象节点 解析(String 字符串) {
        return new 解析器(字符串).翻译();
    }

    public 抽象节点 翻译() {
        节点列表 节点列表 = new 节点列表();
        标志符累积器 累积器 = new 标志符累积器();
        for (int i = 0; i < 正则字符串.length(); i++) {
            char 字 = 正则字符串.charAt(i);
            if (匹配零或多次.名 == 字) {
                节点列表.添加(new 匹配零或多次(累积器.导出()));
            } else if (匹配零或一次.名 == 字) {
                节点列表.添加(new 匹配零或一次(累积器.导出()));
            } else if (匹配一或多次.名 == 字) {
                节点列表.添加(new 匹配一或多次(累积器.导出()));
            } else if (匹配占位.为站位(字)) {
                累积器.导出到(节点列表);
                节点列表.添加(new 匹配占位());
            } else {
                累积器.开();
                累积器.累积(字);
            }
        }
        累积器.导出到(节点列表);
        return 节点列表;
    }

    private static class 标志符累积器 {
        private StringBuffer 累积器;
        private boolean 开关 = false;

        public 标志符累积器() {
            this.累积器 = new StringBuffer();
        }

        public void 开() {
            this.开关 = true;
        }

        public void 关() {
            this.开关 = false;
        }

        public void 累积(char 字) {
            if (开关) {
                累积器.append(字);
            }
        }

        public void 导出到(节点列表 节点列表) {
            this.关();
            if (累积器.length()!=0) {
                String 阶段结果 = 累积器.toString();
                累积器 = new StringBuffer();
                节点列表.添加(new 匹配标志符(阶段结果));
            }
        }

        public 匹配标志符 导出() {
            this.关();
            if (累积器.length()!=0) {
                String 阶段结果 = 累积器.toString();
                累积器 = new StringBuffer();
                return new 匹配标志符(阶段结果);
            }else{
                return null;
            }
        }
    }
}
