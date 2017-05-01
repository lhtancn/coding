package xiaozhao_2016;

/**
 * Created by lhtan on 5/1/2017.
 */

/**
 * 写一段代码，判断一个包括'{','[','(',')',']','}'的表达式是否合法(注意看样例的合法规则。)
 给定一个表达式A,请返回一个bool值，代表它是否合法。
 测试样例：
 "[a+b*(5-4)]*{x+b+b*(({1+2)}}"
 返回：true
 */

/**
 * 即使仅是测试左右括号数量匹配，给的测试用例也错了。若是用栈的话，可以更好的考虑到括号的顺序匹配。
 */
public class ChkExpression {
    public boolean chkLegal(String A) {
        // write code here
        int tagBig = 0, tagMid = 0, tagLit = 0;
        for(int i = 0; i < A.length(); ++i) {
            if(A.charAt(i) == '{') {
                ++tagBig;
            }else if(A.charAt(i) == '[') {
                ++tagMid;
            }else if(A.charAt(i) == '(') {
                ++tagLit;
            }else if(A.charAt(i) == '}') {
                --tagBig;
            }else if(A.charAt(i) == ']') {
                --tagMid;
            }else if(A.charAt(i) == ')') {
                --tagLit;
            }
        }
        return tagBig == 0 && tagMid == 0 && tagLit == 0;          //去除掉if else语句，直接用本身结果做返回值
    }
}

