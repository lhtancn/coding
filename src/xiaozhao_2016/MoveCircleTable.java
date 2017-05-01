package xiaozhao_2016;

import java.util.Scanner;

/**
 * Created by lhtan on 5/1/2017.
 */
/*
现在有一张半径为r的圆桌，其中心位于(x,y)，现在他想把圆桌的中心移到(x1,y1)。每次移动一步，都必须在圆桌边缘固定一个点然后将圆桌绕这个点旋转。问最少需要移动几步。

        输入描述:
        一行五个整数r,x,y,x1,y1(1≤r≤100000,-100000≤x,y,x1,y1≤100000)


        输出描述:
        输出一个整数，表示答案

        输入例子:
        2 0 0 0 4

        输出例子:
        1
*/

public class MoveCircleTable {
    public void moveCore() {
        Scanner in = new Scanner(System.in);
        try {
            while(in.hasNext()) {
                String[] arr = in.nextLine().split(" ");
                int r = Integer.parseInt(arr[0]);
                int curX = Integer.parseInt(arr[1]);
                int curY = Integer.parseInt(arr[2]);
                int targetX = Integer.parseInt(arr[3]);
                int targetY = Integer.parseInt(arr[4]);
                long diffPow = (long)Math.pow(targetX - curX, 2) + (long)Math.pow(targetY - curY, 2);
                double diff = Math.sqrt(diffPow);           //不进行开方，用直接与直径平方相处再开方的方法，nowcoder中会造成溢出等。
                int d = 2 * r;
                double res = diff % d == 0 ? diff / d : diff / d + 1;
                System.out.println((int)res);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            in.close();
        }
    }
}
