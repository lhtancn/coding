package xiaozhao_2016;

/**
 * Created by lhtan on 5/4/2017.
 */

/**
 * 无序数组中最小的k个数
 * 对于一个无序数组，数组中元素为互不相同的整数，请返回其中最小的k个数，顺序与原数组中元素顺序一致。
 给定一个整数数组A及它的大小n，同时给定k，请返回其中最小的k个数。
 测试样例：
 [1,2,4,3],4,2
 返回：[1,2]
 */
public class KthNumbers {
    public int[] findKthNumbers(int[] A, int n, int k) {
        // write code here
        if(A == null || A.length == 0 || k < 1){
            return null;
        }
        if(k >= n) {
            return A;
        }
        int[] B = new int[n];
        for(int i = 0; i < n; ++i) {
            B[i] = A[i];
        }
        int max = quickSort(B, 0, n - 1, k);
        if(max == Integer.MIN_VALUE) {
            return null;
        }
        int[] res = new int[k];
        int index = 0;
        for(int i = 0; i < n; ++i) {
            if(A[i] <= max) {
                res[index++] = A[i];
            }
        }
        return res;
    }

    private int quickSort(int[] A, int start, int end, int k) {
        if(start > end) {
            return Integer.MIN_VALUE;
        }
        int i = start;
        int j = end;
        int temp = A[start];
        while(i < j) {
            while(A[j] >= temp && i < j) {
                --j;
            }
            A[i] = A[j];
            while(A[i] <= temp && i < j) {
                ++i;
            }
            A[j] = A[i];
        }
        A[i] = temp;
        if(i == k - 1) {
            return temp;
        }else if(i > k - 1) {
            return quickSort(A, start, i - 1, k);
        }else {
            return quickSort(A, i + 1, end, k);
        }
    }
}
