package xiaozhao_2016;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by lhtan on 5/3/2017.
 */

/**
 * 在一组数的编码中，若任意两个相邻的代码只有一位二进制数不同， 则称这种编码为格雷码(Gray Code)，请编写一个函数，使用递归的方法生成N位的格雷码。
 给定一个整数n，请返回n位的格雷码，顺序为从0开始。
 测试样例：
 1
 返回：["0","1"]
 */

public class GrayCode {
    public String[] getGray(int n) {
        // write code here

        if(n < 1) {
            return null;
        }
        /**
         * 重点：必须要LinkedList<T> list = new LinkedList<>(), 而不是List<T> list = new LinkedList<>()，
         * 因为要使用LinkedList()独有的offer()等方法,而后者在初始化时list为List类，不具有offer等方法。
         */
        LinkedList<String> initList = new LinkedList<>();
        initList.offer("0");
        initList.offer("1");
        LinkedList<String> resList = circle(1, n, initList);

        String[] res = resList.toArray(new String[resList.size()]);     //list转array方法，简便的对list.toArray()中的Object具体类化处理
        return res;
    }

    private LinkedList<String> circle(int index, int n, LinkedList<String> pre) {
        if(index == n) {
            return pre;
        }
        LinkedList<String> cur = new LinkedList<>();
        while(pre.peek() != null) {
            String str = pre.pollLast();
            cur.offerFirst("0" + str);
            cur.offerLast("1" + str);
        }
        return circle(++index, n, cur);
    }
}
