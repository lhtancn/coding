package xiaozhao_2016;

/**
 * Created by lhtan on 5/3/2017.
 */
/**
 * 有一个NxN整数矩阵，请编写一个算法，将矩阵顺时针旋转90度。
 给定一个NxN的矩阵，和矩阵的阶数N,请返回旋转后的NxN矩阵,保证N小于等于300。
 测试样例：
 [[1,2,3],[4,5,6],[7,8,9]],3
 返回：[[7,4,1],[8,5,2],[9,6,3]]
 */

/**
 * 两种方法都建立在图的转换规律上，第一种没有复制数组，理论用了O(1)的空间，且时间复杂度也较小
 */
public class Rotate {
    public int[][] rotateMatrix(int[][] mat, int n) {
        // write code here
        if (mat == null || mat.length == 0 || mat.length != n) {
            return null;
        }
        if (n % 2 == 0) {                       //示意图可知要分奇偶
            for (int i = 0; i < (n >> 1); ++i) {
                for (int j = 0; j < (n >> 1); ++j) {
                    int temp = mat[i][j];
                    mat[i][j] = mat[n - 1 - j][i];
                    mat[n - 1 - j][i] = mat[n - 1 - i][n - 1 - j];
                    mat[n - 1 - i][n - 1 - j] = mat[j][n - 1 - i];
                    mat[j][n - 1 - i] = temp;
                }
            }
        } else {
            for (int i = 0; i < (n >> 1); ++i) {
                for (int j = 0; j < (n >> 1) + 1; ++j) {
                    int temp = mat[i][j];
                    mat[i][j] = mat[n - 1 - j][i];
                    mat[n - 1 - j][i] = mat[n - 1 - i][n - 1 - j];
                    mat[n - 1 - i][n - 1 - j] = mat[j][n - 1 - i];
                    mat[j][n - 1 - i] = temp;
                }
            }
        }

        return mat;
    }
}

/*
//第二种方法，用了O(n * n)空间
public class Rotate {
    public int[][] rotateMatrix(int[][] mat, int n) {
        // write code here
        if(mat == null || mat.length == 0 || mat.length != n) {
            return null;
        }
        int[][] res = new int[n][n];
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                res[j][n - 1 - i] = mat[i][j];
            }
        }
        return res;
    }
}
*/
