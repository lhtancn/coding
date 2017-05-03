package xiaozhao_2016;

/**
 * Created by lhtan on 5/3/2017.
 */

/**
 * 有一楼梯共m级，刚开始时你在第一级，若每次只能跨上一级或者二级，要走上m级，共有多少走法？注：规定从一级到一级有0种走法。
 给定一个正整数int n，请返回一个数，代表上楼的方式数。保证n小于等于100。为了防止溢出，请返回结果Mod 1000000007的值。
 测试样例：
 3
 返回：2
 */

public class GoUpstairs {
    public int countWays(int n) {
        // write code here
        if(n < 1) {
            return -1;
        }
        if(n <= 2) {            //注意审题义，以及测试测试用例，此处刚开始就处在第一级台阶，与以往的不在台阶上有区别
            return n - 1;
        }

        int former = 1;
        int late = 1;
        for(int i = 2; i < n; ++i) {
            int tmp = former + late;
            former = late;
            late = tmp % 1000000007;
        }
        return late;
    }
}
