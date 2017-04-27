package xiaozhao_2016;

/**
 * Created by lhtan on 4/27/2017.
 */

/*
在4x4的棋盘上摆满了黑白棋子，黑白两色的位置和数目随机其中左上角坐标为(1,1),右下角坐标为(4,4),现在依次有一些翻转操作，要对一些给定支点坐标为中心的上下左右四个棋子的颜色进行翻转，请计算出翻转后的棋盘颜色。
        给定两个数组A和f,分别为初始棋盘和翻转位置。其中翻转位置共有3个。请返回翻转后的棋盘。
        测试样例：
        [[0,0,1,1],[1,0,1,0],[0,1,1,0],[0,0,1,0]],[[2,2],[3,3],[4,4]]
        返回：[[0,1,1,1],[0,0,1,0],[0,1,1,0],[0,0,1,0]]
*/

public class Flip {
    public int[][] flipChess(int[][] A, int[][] f) {
        // write code here
        if(A == null || A.length == 0 || f == null || f.length == 0) {
            return A;
        }
        for(int[] arr : f) {
            flipCore(A, arr[0] - 1, arr[1] - 1);
        }
        return A;
    }
    private void flipCore(int[][] A, int row, int col) {
        if(row < 0 || col < 0) {
            return ;
        }

        /**
         * 最开始写成了"A[row - 1][col] = A[row][col] ^ 1",
         * 但手工代入验证时想当然的使用了A[row - 1][col] ^ 1，导致一时未检测出错误，
         * 所以手工验证时要完全依照代码步骤来，不能想当然跳步骤。
         */
        if(row > 0) {
            A[row - 1][col] = A[row - 1][col] ^ 1;
        //    A[row - 1][col] ^= 1;

        }
        if(col > 0) {
            A[row][col - 1] = A[row][col - 1] ^ 1;
        }
        if(row < A.length - 1) {
            A[row + 1][col] = A[row + 1][col] ^ 1;
        }
        if(col < A[0].length - 1) {
            A[row][col + 1] = A[row][col + 1] ^ 1;
        }
    }
}
