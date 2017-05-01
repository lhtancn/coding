package xiaozhao_2016;

import java.util.Scanner;

/**
 * Created by lhtan on 5/1/2017.
 */

/*
给定一个字符串，问是否能通过添加一个字母将其变为回文串。
        输入描述:
        一行一个由小写字母构成的字符串，字符串长度小于等于10。


        输出描述:
        输出答案(YES\NO).

        输入例子:
        coco

        输出例子:
        YES
*/

public class HuiWen {
    public void judgeHuiWen(){
        /**
         * 这种try-catch方式不是太会用，且要在java7及以上版本才行，
         * 可以进行自动资源管理，释放Scanner资源，相当于自动调用in.close().
         */
        try (Scanner in = new Scanner(System.in)) {
            while (in.hasNext()) {
                String str = in.next();
                boolean tag = false;
                int endIndex = str.length() - 1;
                for (int i = 0; i < (str.length() >> 1); ++i) {      // '>>'与'<<'刚开始写反了
                    if (str.charAt(i) != str.charAt(endIndex - i)) {
                        if (judgeCore(str, i + 1, endIndex - i)
                                && judgeCore(str, i, endIndex - i - 1)) {
                            tag = true;
                        }
                    }
                }
                if (tag) {
                    System.out.println("NO");
                } else {
                    System.out.println("YES");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    private boolean judgeCore(String str, int start, int end) {
        while(start < end) {
            if(str.charAt(start) != str.charAt(end)) {
                return true;
            }
            ++start;
            --end;
        }
        return false;
    }
}
