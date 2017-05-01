package xiaozhao_2016;

/**
 * Created by lhtan on 5/1/2017.
 */

/**
 * 请你实现一个简单的字符串替换函数。原串中需要替换的占位符为"%s",请按照参数列表的顺序一一替换占位符。若参数列表的字符数大于占位符个数。则将剩下的参数字符添加到字符串的结尾。
 给定一个字符串A，同时给定它的长度n及参数字符数组arg，请返回替换后的字符串。保证参数个数大于等于占位符个数。保证原串由大小写英文字母组成，同时长度小于等于500。
 测试样例：
 "A%sC%sE",7,['B','D','F']
 返回："ABCDEF"
 */

public class StringFormat {
    public String formatString(String A, int n, char[] arg, int m) {
        // write code here
        if(arg == null || arg.length == 0 || A.length() == 0) {
            return A;
        }
        StringBuilder sb = new StringBuilder();
        int argIndex = 0;
        if(!(A.charAt(0) == '%' && A.charAt(1) == 's')) {
            sb.append(String.valueOf(A.charAt(0)));
        }

        for(int i = 1; i < n; ++i){
            if(A.charAt(i - 1) == '%' && A.charAt(i) == 's') {
                if(sb.length() != 0) {                      //依照下标删除元素时，要检查是否会有溢出情况。此处若不加判断，且第一个就需要删除，则会溢出。
                    sb.deleteCharAt(sb.length() - 1);
                }
                sb.append(String.valueOf(arg[argIndex++]));
            }else {
                sb.append(String.valueOf(A.charAt(i)));
            }
        }
        while(argIndex < m) {
            sb.append(String.valueOf(arg[argIndex++]));
        }
        return sb.toString();
    }
}