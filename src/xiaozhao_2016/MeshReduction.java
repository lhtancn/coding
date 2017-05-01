package xiaozhao_2016;

import java.util.Scanner;

/**
 * Created by lhtan on 4/30/2017.
 */
/*
度度熊有一张网格纸，但是纸上有一些点过的点，每个点都在网格点上，若把网格看成一个坐标轴平行于网格线的坐标系的话，每个点可以用一对整数x，y来表示。度度熊必须沿着网格线画一个正方形，使所有点在正方形的内部或者边界。然后把这个正方形剪下来。问剪掉正方形的最小面积是多少。
        输入描述:
        第一行一个数n(2≤n≤1000)表示点数，接下来每行一对整数xi,yi(－1e9<=xi,yi<=1e9)表示网格上的点


        输出描述:
        一行输出最小面积

        输入例子:
        2
        0 0
        0 3

        输出例子:
        9
*/

public class MeshReduction {
    public void meshCore() {

        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int minX = Integer.MAX_VALUE;       //这四个赋值要放到while中
            int minY = Integer.MAX_VALUE;
            int maxX = Integer.MIN_VALUE;
            int maxY = Integer.MIN_VALUE;
            try {
//                int cycleCount = Integer.valueOf(in.nextLine());      //这样得到cycleCount时，牛客上会不通过,通过测试与in.nextLine()有关
//                int cycleCount = Integer.parseInt(in.next());     //牛客可通过，用in.nextLine()不通过
                int cycleCount = in.nextInt();
                while(cycleCount > 0) {
//                    String[] arr = in.nextLine().split(" ");      //这样确认curX，curY时牛客上提交失败
//                    int curX = Integer.valueOf(arr[0]);
//                    int curY = Integer.valueOf(arr[1]);
                    int curX = in.nextInt();
                    int curY = in.nextInt();
                    minX = curX < minX ? curX : minX;
                    minY = curY < minY ? curY : minY;
                    maxX = curX > maxX ? curX : maxX;
                    maxY = curY > maxY ? curY : maxY;
                    --cycleCount;
                }
                int edgeLen = maxX - minX > maxY - minY ? maxX - minX : maxY - minY;
                System.out.println(edgeLen * edgeLen);      //因为两个edgeLen相乘后不会超过int表示范围，所以此处与上处不进行long转化
            } catch (Exception e){
                System.out.println(e.getMessage());
            }

        }
        in.close();
    }
}
