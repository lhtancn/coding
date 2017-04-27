package xiaozhao_2016;

/**
 * Created by lhtan on 4/27/2017.
 */

/*
有一个直方图，用一个整数数组表示，其中每列的宽度为1，求所给直方图包含的最大矩形面积。比如，对于直方图[2,7,9,4],它所包含的最大矩形的面积为14(即[7,9]包涵的7x2的矩形)。
        给定一个直方图A及它的总宽度n，请返回最大矩形面积。保证直方图宽度小于等于500。保证结果在int范围内。
        测试样例：
        [2,7,9,4,1],5
        返回：14
*/


public class MaxInnerRec {
    public int countArea(int[] A, int n) {
        // write code here
        if(A == null || A.length == 0) {
            return 0;
        }

//        int[][] area = new int[n][n];     //原用矩阵对应每两个节点之间的面积，后因为状态转移时仅需同行截至前一列的面积，所以后改为列向量
        int[] curArea = new int[n];
        int max = 0;
        for(int i = 0; i < n; ++i) {
            for(int j = i; j < n; ++j) {
                int num = j - i + 1;
                if(i == j) {
                    curArea[i] = A[i];
                    continue;
                }
                int lastBase = curArea[i] / (num - 1);
                int curBase = A[j] < lastBase ? A[j] : lastBase;
                curArea[i] = num * curBase;
                max = curArea[i] > max ? curArea[i] : max;
            }
        }
        return max;
    }
}
