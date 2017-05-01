package xiaozhao_2016;

import java.util.Scanner;

/**
 * Created by lhtan on 5/1/2017.
 */

/*
给定一个递增序列，a1 <a2 <...<an 。定义这个序列的最大间隔为d=max{ai+1 - ai }(1≤i<n),现在要从a2 ,a3 ..an-1 中删除一个元素。问剩余序列的最大间隔最小是多少？

        输入描述:
        第一行，一个正整数n(1<=n<=100),序列长度;接下来n个小于1000的正整数，表示一个递增序列。


        输出描述:
        输出答案。

        输入例子:
        5
        1 2 3 7 8

        输出例子:
        4
*/


public class MaxGap {
    public void getMaxGap() {
        Scanner in = new Scanner(System.in);
        try {
            while(in.hasNext()) {
                int n = in.nextInt();
                in.nextLine();

                int[] arr = new int[n];
                for(int i = 0; i < n; ++i) {
                    arr[i] = in.nextInt();
                }
                if(n < 3) {
                    System.out.println("error input.");
                    continue;
                }
                int maxPre = arr[1] - arr[0];
                int minLate = Integer.MAX_VALUE;
                for(int i = 2; i < n; ++i) {
                    maxPre = arr[i] - arr[i - 1] > maxPre ? arr[i] - arr[i - 1] : maxPre;
                    minLate = arr[i] - arr[i - 2] < minLate ? arr[i] - arr[i - 2] : minLate;
                }
                int res = maxPre > minLate ? maxPre : minLate;
                System.out.println(res);
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            in.close();
        }
    }
}
