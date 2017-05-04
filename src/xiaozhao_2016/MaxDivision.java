package xiaozhao_2016;

/**
 * Created by lhtan on 5/4/2017.
 */

/**
 * 请设计一个复杂度为O(n)的算法，计算一个未排序数组中排序后相邻元素的最大差值。
 给定一个整数数组A和数组的大小n，请返回最大差值。保证数组元素个数大于等于2小于等于500。
 测试样例：
 [9,3,1,10],4
 返回：6
 */

/**
 * 桶排序
 */
public class MaxDivision {
    public int findMaxDivision(int[] A, int n) {
        // write code here
        if(A == null || A.length == 0) {
            return -1;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; ++i) {
            max = A[i] > max ? A[i] : max;
            min = A[i] < min ? A[i] : min;
        }
        int[] bucket = new int[max - min + 1];
        for(int i = 0; i < n; ++i) {
            bucket[A[i] - min] = 1;
        }
        int maxGap = 0;
        int curGap = 0;
        for(int i = 1; i < bucket.length; ++i) {
            if(bucket[i] == 0) {
                ++curGap;
                maxGap = curGap > maxGap ? curGap : maxGap;
                continue;
            }
            curGap = 0;
        }
        return maxGap + 1;    //计算最大差值，所以此处要加1
    }
}
