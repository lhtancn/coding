package xiaozhao_2016;

import java.util.Scanner;

/**
 * Created by lhtan on 5/2/2017.
 */

/**
 * 一只兔子藏身于20个圆形排列的洞中（洞从1开始编号），一只狼从x号洞开始找,下次隔一个洞找(及在x＋2号洞找)，在下次个两个洞找(及在x＋5号洞找)，它找了n次仍然没有找到。问兔子可能在那些洞中。

 输入描述:
 输入有多组数据，每组数据一行两个整数分别为x和n(x <= 20,n <= 100000)


 输出描述:
 每组数据一行按从小到大的顺序输出兔子可能在的洞，数字之间用空格隔开。若每个洞都不肯能藏着兔子，输出-1。
 */

/**
 * 这题好神奇，直觉上对20大数循环且间隔递增不均等，最后也能保持在固定几个洞上循环（一个测试用例：20 18979）
 */
public class RabbitHoles {
    public void findRabbit(){
        try(Scanner in = new Scanner(System.in)) {
            while(in.hasNext()) {
                int x = in.nextInt();
                int n = in.nextInt();
                int[] holes = new int[20];
                int index = x - 1;
                if(x < 0) {
                    continue;
                }
                for(int i = 0; i < n; ++i) {
                    holes[index] = 1;
                    index = index + i + 2;
                    index = index % 20;
                    System.out.print(index + " ");
                }
                int resHoles = 0;
                for(int i = 0; i < 20; ++i) {
                    if(holes[i] == 0) {
                        ++resHoles;
                    }
                }
                if(resHoles == 0) {
                    System.out.print("-1");
                }else {
                    for(int i = 0; i < 20; ++i) {
                        if(holes[i] == 0) {
                            System.out.print(i + 1 + " ");      //要把结果打印成一行，所以不能用println().
                        }
                    }
                }
                System.out.print("\n");         //注意添加换行符
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}