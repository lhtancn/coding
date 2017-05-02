package xiaozhao_2016;

/**
 * Created by lhtan on 5/2/2017.
 */

/**
 * 小东和三个朋友一起在楼上抛小球，他们站在楼房的不同层，假设小东站的楼层距离地面N米，球从他手里自由落下，每次落地后反跳回上次下落高度的一半，并以此类推知道全部落到地面不跳，求4个小球一共经过了多少米？(数字都为整数)
 给定四个整数A,B,C,D，请返回所求结果。
 测试样例：
 100,90,80,70
 返回：1020
 */
public class Balls {
    public int calcDistance(int A, int B, int C, int D) {
        // write code here
        if(A < 0 || B < 0 || C < 0 || D < 0) {
            return -1;
        }
        double[] high = new double[5];      //int的除2操作的取整误差太大，多次后会少很多米，所以使用double，high[4]作为结果累加
        high[0] = A;
        high[1] = B;
        high[2] = C;
        high[3] = D;
        for (int i = 0; i < 4; i++) {
            high[4] += high[i];
        }
        while(high[0] > 0 || high[1] > 0 || high[2] > 0 || high[3] > 0) {
            add(high);
        }
        System.out.println(high[4]);
        return (int)Math.round(high[4]);        //使用Math.round()对double值进行4舍5入的取整操作
    }

    private void add(double[] high) {
        for(int index = 0; index < 4; ++index) {
            if(high[index] > 0) {
                high[4] += high[index];
                high[index] = high[index] / 2;
            }
        }

    }
}
