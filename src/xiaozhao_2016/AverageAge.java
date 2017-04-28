package xiaozhao_2016;

import java.util.Scanner;

/**
 * Created by lhtan on 4/28/2017.
 */
/*
已知某公司总人数为W，平均年龄为Y岁(每年3月末计算，同时每年3月初入职新人)，假设每年离职率为x，x>0&&x<1,每年保持所有员工总数不变进行招聘，新员工平均年龄21岁。
        从今年3月末开始，请实现一个算法，可以计算出第N年后公司员工的平均年龄。(最后结果向上取整)。
        输入描述:
        输入W Y x N

        输出描述:
        输出第N年后的平均年龄

        输入例子:
        5 5 0.2 3

        输出例子:
        15
*/

public class AverageAge {
    public void getAve() {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {               //对于以System.in输入的测试用例，此处应加while循环，以防止多次测试
            String[] arr = in.nextLine().split(" ");
            double Y = Double.parseDouble(arr[1]);
            double x = Double.parseDouble(arr[2]);
            int N = Integer.parseInt(arr[3]);
            for (int i = 0; i < N; ++i) {
                Y = (1 - x) * (Y + 1) + 21 * x;         //每过一年，老员工的年龄增大一岁，所以此处为（1 - x） * (Y + 1)而不是(1 - x) * Y
            }
            System.out.println(Y == (int) Y ? (int) Y : ((int) Y + 1));        //可用(int)Math.ceil(Y)代替向上取整，且不用导入java.lang.Math包
            //System.out.println(Math.ceil(Y));
        }
    }
}
