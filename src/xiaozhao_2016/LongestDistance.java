package xiaozhao_2016;

/**
 * Created by lhtan on 4/27/2017.
 */

/*有一个长为n的数组A，求满足0≤a≤b<n的A[b]-A[a]的最大值。
        给定数组A及它的大小n，请返回最大差值。
        测试样例：
        [10,5],2
        返回：0
*/

public class LongestDistance {
    public int getDis(int[] A, int n) {
        // write code here
        if(A == null || A.length == 0 || A.length != n) {
            return -1;
        }
        int diff = 0;
        int min = A[0];
        for(int i = 1; i < n; ++i) {
            int curDiff = A[i] - min;
            diff = curDiff > diff ? curDiff : diff;
            min = A[i] < min ? A[i] : min;
        }
        return diff;
    }
}
