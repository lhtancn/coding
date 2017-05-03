package xiaozhao_2016;

/**
 * Created by lhtan on 5/3/2017.
 */

/**
 * 春节期间小明使用微信收到很多个红包，非常开心。在查看领取红包记录时发现，某个红包金额出现的次数超过了红包总数的一半。请帮小明找到该红包金额。写出具体算法思路和代码实现，要求算法尽可能高效。
 给定一个红包的金额数组gifts及它的大小n，请返回所求红包的金额。
 若没有金额超过总数的一半，返回0。
 测试样例：
 [1,2,3,2,2],5
 返回：2
 */
public class Gift {
    public int getValue(int[] gifts, int n) {
        // write code here
        if(gifts == null || gifts.length == 0 || n != gifts.length) {
            return 0;
        }
        int mid = findMid(gifts, 0, n - 1, n >> 1);
        int count = 0;

        for(int i = 0; i < n; ++i) {
            if(gifts[i] == mid) {
                ++count;
            }
        }
        if(count > (n >> 1)) {
            return mid;
        }else {
            return 0;
        }
    }

    private int findMid(int[] gifts, int start, int end, int midIndex) {
        int tmp = gifts[start];
        int i = start;
        int j = end;
        while(i < j) {
            while(gifts[j] >= tmp && i < j) {
                --j;
            }
            gifts[i] = gifts[j];
            while(gifts[i] <= tmp && i < j) {
                ++i;
            }
            gifts[j] = gifts[i];
        }
        gifts[i] = tmp;

        int mid = i;
        if(mid < midIndex) {
            return findMid(gifts, mid + 1, end, midIndex);
        }else if(mid > midIndex) {
            return findMid(gifts, start, mid - 1, midIndex);
        }
        return tmp;
    }
}
