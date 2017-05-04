package xiaozhao_2016;

/**
 * Created by lhtan on 5/3/2017.
 */

/**
 * 对于一个矩阵，请设计一个算法从左上角(mat[0][0])开始，顺时针打印矩阵元素。
 给定int矩阵mat,以及它的维数nxm，请返回一个数组，数组中的元素为矩阵元素的顺时针输出。
 测试样例：
 [[1,2],[3,4]],2,2
 返回：[1,2,4,3]
 */

public class MatrixPrinterByTime {
    private int index = 0;

    public int[] clockwisePrint(int[][] mat, int n, int m) {
        // write code here
        if (mat == null || mat.length == 0) {
            return null;
        }
        int[] res = new int[n * m];
        int start = 0;
        while ((start << 1) < n && (start << 1) < m) {
            getEle(mat, start, res);
            ++start;
        }
        return res;
    }

    private void getEle(int[][] mat, int start, int[] res) {
        int endRow = mat.length - 1 - start;
        int endCol = mat[0].length - 1 - start;
        for (int j = start; j <= endCol; ++j) {
            res[index++] = mat[start][j];
        }
        for (int i = start + 1; i <= endRow && endRow > start; ++i) {
            res[index++] = mat[i][endCol];
        }
        for (int j = endCol - 1; j >= start && endRow > start && endCol > start; --j) {
            res[index++] = mat[endRow][j];
        }
        for (int i = endRow - 1; i >= start + 1 && endCol > start && endRow > start + 1; --i) {
            res[index++] = mat[i][start];
        }
    }

}
