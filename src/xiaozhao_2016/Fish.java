package xiaozhao_2016;

import java.util.Scanner;

/**
 * Created by lhtan on 4/30/2017.
 */

/*
ss请cc来家里钓鱼，鱼塘可划分为n＊m的格子，每个格子有不同的概率钓上鱼，cc一直在坐标(x,y)的格子钓鱼，而ss每分钟随机钓一个格子。问t分钟后他们谁至少钓到一条鱼的概率大？为多少？

        输入描述:
        第一行五个整数n,m,x,y,t(1≤n,m,t≤1000,1≤x≤n,1≤y≤m);
        接下来为一个n＊m的矩阵，每行m个一位小数，共n行，第i行第j个数代表坐标为(i,j)的格子钓到鱼的概率为p(0≤p≤1)


        输出描述:
        输出两行。第一行为概率大的人的名字(cc/ss/equal),第二行为这个概率(保留2位小数)

        输入例子:
        2 2 1 1 1
        0.2 0.1
        0.1 0.4

        输出例子:
        equal
        0.20
*/


public class Fish {
    public void fishCore() {
        Scanner in = new Scanner(System.in);
        try {
            while (in.hasNext()) {
                double ssPro = 0;
                String[] att = in.nextLine().split(" ");
                int rows = Integer.parseInt(att[0]);
                int cols = Integer.parseInt(att[1]);
                int row = Integer.parseInt(att[2]) - 1;
                int col = Integer.parseInt(att[3]) - 1;
                int times = Integer.parseInt(att[4]);

                double ccPro = 0;
                for (int i = 0; i < rows; ++i) {                 //用in.nextDouble()时复杂度过大，超时
                    String[] arr = in.nextLine().split(" ");
                    for (int j = 0; j < cols; ++j) {
                        double curPro = Double.parseDouble(arr[j]);
                        if (i == row && j == col) {
                            ccPro = curPro;
                        }
                        ssPro += curPro;
                    }
                }

                ssPro /= rows * cols;
                ssPro = 1 - Math.pow((1 - ssPro), times);
                ccPro = 1 - Math.pow((1 - ccPro), times);
                if (ssPro > ccPro) {
                    System.out.println("ss" + "\n" + String.format("%.2f", ssPro));
                } else if (ssPro < ccPro) {
                    System.out.println("cc" + "\n" + String.format("%.2f", ccPro));
                } else {
                    System.out.println("equal" + "\n" + String.format("%.2f", ssPro));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            in.close();
        }
    }
}