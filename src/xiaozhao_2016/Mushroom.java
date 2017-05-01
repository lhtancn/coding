package xiaozhao_2016;

import java.util.Scanner;

/**
 * Created by lhtan on 4/30/2017.
 */
/*
现在有两个好友A和B，住在一片长有蘑菇的由n＊m个方格组成的草地，A在(1,1),B在(n,m)。现在A想要拜访B，由于她只想去B的家，所以每次她只会走(i,j+1)或(i+1,j)这样的路线，在草地上有k个蘑菇种在格子里(多个蘑菇可能在同一方格),问：A如果每一步随机选择的话(若她在边界上，则只有一种选择)，那么她不碰到蘑菇走到B的家的概率是多少？

        输入描述:
        第一行N，M，K(1 ≤ N,M ≤ 20, k ≤ 100),N,M为草地大小，接下来K行，每行两个整数x，y，代表(x,y)处有一个蘑菇。


        输出描述:
        输出一行，代表所求概率(保留到2位小数)

        输入例子:
        2 2 1
        2 1

        输出例子:
        0.50
*/

//由此题可知，测试用例的数据是一次性全部给好（多次测试），然后结果一次性输出。
//所以若提前结束当前测试用例，要考虑好下次测试用例的进入格式问题

public class Mushroom {
    public void calPro() {
        Scanner in = new Scanner(System.in);
        try {
            while(in.hasNext()){
                String[] attr = in.nextLine().split(" ");
                int n = Integer.parseInt(attr[0]);
                int m = Integer.parseInt(attr[1]);
                int k = Integer.parseInt(attr[2]);
                if(k == 0) {
                    System.out.println("1.00");
//                    return ;                         若当前判断提前结束，则应该continue结束本次while循环，
                                                       //但不应该return去结束函数，否则下次的数据没有结果

                    continue;
                } else if(m == 1 || n == 1){
                    System.out.println("0.00");
//                    return;
                    continue;
                }
                double[][] lawn = new double[n][m];
                for(int i = 0; i < k; ++i) {
                    String[] pos = in.nextLine().split(" ");
                    int x = Integer.parseInt(pos[0]) - 1;
                    int y = Integer.parseInt(pos[1]) - 1;
                    if(x == n - 1 && y == m - 1) {
                        System.out.println("Error input.");
                        return;
                    }
                    lawn[x][y] = -1;
                }
                double pro = findPathCount(lawn, n, m);

                /**
                 * 这样计算组合数时，由于各个值指向不明，结果错。最后像下面那样明面写出各个参数值，利用参数值计算
                 * 不过最后结果不是路径除，而是概率加
                 */

//                int start = m > n ? m : n;
//                for(int i = start + 1; i <= m + n; ++i) {
//                    sumCount *= i;
//                }
//                for(int i = 2; i <= m + n - start; ++i) {
//                    sumCount /= i;
//                }

                System.out.println(String.format("%.2f", pro));
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            in.close();
        }
    }

    private double findPathCount(double[][] lawn, int n, int m) {


        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < m; ++j) {
                if(i == 0 && j == 0) {
//                    lawn[i][j] == 1;
                    lawn[i][j] = 1;
                    continue;
                }
                if(lawn[i][j] == -1){
                    lawn[i][j] = 0;
                    continue;
                }
                if(i == 0) {
                    lawn[i][j] = lawn[i][j - 1] * 0.5;
                }else if(j == 0) {
                    lawn[i][j] = lawn[i - 1][j] * 0.5;
                }else {
                    lawn[i][j] = lawn[i - 1][j] * (j == m - 1 ? 1 : 0.5) + lawn[i][j - 1] * (i == n - 1 ? 1 : 0.5);
                }
            }
        }

        return lawn[n - 1][m - 1];
    }
}
