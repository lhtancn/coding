package xiaozhao_2016;

import java.util.Scanner;

/**
 * Created by lhtan on 5/3/2017.
 */

/**
 * A[n,m]是一个n行m列的矩阵，a[i,j]表示A的第i行j列的元素，定义x[i,j]为A的第i行和第j列除了a[i,j]之外所有元素(共n+m-2个)的乘积，即x[i,j]=a[i,1]*a[i,2]*...*a[i,j-1]*...*a[i,m]*a[1,j]*a[2,j]...*a[i-1,j]*a[i+1,j]...*a[n,j],现输入非负整形的矩阵A[n,m]，求MAX(x[i,j])，即所有的x[i,j]中的最大值。

 输入描述:
 第一行两个整数n和m。之后n行输入矩阵，均为非负整数。


 输出描述:
 一行输出答案。

 输入例子:
 3 5
 5 1 8 5 2
 1 3 10 3 3
 7 8 5 5 16

 输出例子:
 358400
 */

public class Multi {
    public void getMax(){
        try(Scanner in = new Scanner(System.in)) {
            while(in.hasNext()) {
                int rows = in.nextInt();
                int cols = in.nextInt();
                int[][] matrix = new int[rows][cols];
                for(int i = 0; i < rows; i++) {
                    for(int j = 0; j < cols; j++) {
                        matrix[i][j] = in.nextInt();
                    }
                }
                long[][] rowMulti = new long[rows][cols];
                long[][] colMulti = new long[rows][cols];
                getRowMulti(rowMulti, matrix, rows, cols);
                getColMulti(colMulti, matrix, rows, cols);
                long max = 0;
                for(int i = 0; i < rows; ++i) {
                    for(int j = 0; j < cols; ++j) {
                        max = rowMulti[i][j] * colMulti[i][j] > max ? rowMulti[i][j] * colMulti[i][j] : max;
                    }
                }
                System.out.println(max);

            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void getRowMulti(long[][] row, int[][] matrix, int rows, int cols) {
        for(int i = 0; i < rows; ++i) {

            long[] former = new long[cols];
            long[] late = new long[cols];

            former[0] = 1;
            late[cols - 1] = 1;
            for(int j = 1; j < cols; j++) {
                former[j] = former[j - 1] * matrix[i][j - 1];
                late[cols - 1 - j] = late[cols - j] * matrix[i][cols - j];
            }
            for(int j = 0; j < cols; j++) {
                row[i][j] = former[j] * late[j];
            }
        }
    }


    /**
     * 要注意按列计算时数组下标的正确性
     */
    private void getColMulti(long[][] col, int[][] matrix, int rows, int cols) {
        for(int i = 0; i < cols; ++i) {

            long[] former = new long[rows];
            long[] late = new long[rows];

            former[0] = 1;
            late[rows - 1] = 1;
            for(int j = 1; j < rows; j++) {
                former[j] = former[j - 1] * matrix[j - 1][i];
                late[rows - 1 - j] = late[rows - j] * matrix[rows - j][i];
            }
            for(int j = 0; j < rows; j++) {
                col[j][i] = former[j] * late[j];
            }
        }
    }
}
