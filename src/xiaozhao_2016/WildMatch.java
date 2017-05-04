package xiaozhao_2016;

/**
 * Created by lhtan on 5/4/2017.
 */

/**
 * 字符串通配
 * 对于字符串A，其中绝对不含有字符’.’和’*’。再给定字符串B，其中可以含有’.’或’*’，’*’字符不能是B的首字符，并且任意两个’*’字符不相邻。exp中的’.’代表任何一个字符，B中的’*’表示’*’的前一个字符可以有0个或者多个。请写一个函数，判断A是否能被B匹配。
 给定两个字符串A和B,同时给定两个串的长度lena和lenb，请返回一个bool值代表能否匹配。保证两串的长度均小于等于300。
 测试样例：
 "abcd",4,".*",2
 返回：true
 */
public class WildMatch {
    public boolean chkWildMatch(String A, int lena, String B, int lenb) {
        // write code here
        return checkCore(A, 0, B, 0);
    }

    private boolean checkCore(String A, int indexA, String B, int indexB) {
        if(indexA >= A.length() && indexB >= B.length()) {      //要注意是>=而不是==，因为+2后可能会越过==阶段
            return true;
        }
        if(indexB >= B.length()) {              //同上
            return false;
        }

        if(indexB < B.length() - 1 && B.charAt(indexB + 1) == '*') {
            if(indexA < A.length() && (A.charAt(indexA) == B.charAt(indexB) || B.charAt(indexB) == '.')) {
                return checkCore(A, indexA, B, indexB + 2) ||
                        checkCore(A, indexA + 1, B, indexB + 2) ||
                        checkCore(A, indexA + 1, B, indexB);
            }else {
                return checkCore(A, indexA, B, indexB + 2);         //考虑A已完结，B剩.*或者其它字母与*组合的情况
            }
        }else {
            if(indexA < A.length() && A.charAt(indexA) == B.charAt(indexB) || B.charAt(indexB) == '.') {
                return checkCore(A, indexA + 1, B, indexB + 1) ||
                        checkCore(A, indexA, B, indexB + 1);
            }
        }
        return false;
    }
}
