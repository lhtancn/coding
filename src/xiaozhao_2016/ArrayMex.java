package xiaozhao_2016;

/**
 * Created by lhtan on 5/4/2017.
 */

/**
 *请设计一个高效算法，查找数组中未出现的最小正整数。
 给定一个整数数组A和数组的大小n，请返回数组中未出现的最小正整数。保证数组大小小于等于500。
 测试样例：
 [-1,2,3,4],4
 返回：1
 */

public class ArrayMex {
    public int findArrayMex(int[] A, int n) {           //更好的方法，结果不过超过n + 1，所以设置n + 1个桶就好了
        // write code here
        if (A == null || A.length == 0) {
            return 1;
        }

        int[] bucket = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            int index = A[i];
            if (index > 0 && index <= n) {
                bucket[index - 1] = 1;
            }
        }
        int res = 0;
        for (int i = 0; i < bucket.length; ++i) {
            if (bucket[i] == 0) {
                res = i + 1;
                break;
            }
        }
        return res;
    }

    /*
    public int findArrayMex(int[] A, int n) {
        // write code here
        if(A == null || A.length == 0) {
            return -1;                      //可能为1也可以作为异常报错
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; ++i) {
            max = A[i] > max ? A[i] : max;
            min = A[i] < min ? A[i] : min;
        }
        if(max <= 0) {
//            return -1;           //都小于等于0时，最小缺失正整数应该为1
            return 1;
        }
        int[] bucket = new int[max];
        for(int i = 0; i < n; ++i) {
            int index = A[i];
            if(index > 0) {             //判断，对于小于等于0的数值不加入桶
                bucket[index - 1] = 1;
            }
        }
        for(int i = 0; i < bucket.length; ++i) {
            if(bucket[i] == 0) {
                return i + 1;
            }
        }
        return max + 1;
    }
    */
}
