package xiaozhao_2016;
import java.util.*;
/**
 * Created by lhtan on 5/2/2017.
 */

/**
 * 果园里有一堆苹果，一共n头(n大于1小于9)熊来分，第一头为小东，它把苹果均分n份后，多出了一个，它扔掉了这一个，拿走了自己的一份苹果，接着第二头熊重复这一过程，即先均分n份，扔掉一个然后拿走一份，以此类推直到最后一头熊都是这样(最后一头熊扔掉后可以拿走0个，也算是n份均分)。问最初这堆苹果最少有多少个。
 给定一个整数n,表示熊的个数，返回最初的苹果数。保证有解。
 测试样例：
 2
 返回：3
 */

/**
 * 进行简单推演时要每步骤都工整写下来，且对两步之间的过渡逻辑进行分析是否正确
 */
public class Apples {
    public int getInitial(int n) {
        // write code here
        if(n >= 9 || n <= 1) {
            return -1;
        }
        int res = 0;
        boolean tag = true;
        int lastTake = 0;
        while(tag) {
            res = lastTake;
            for(int j = 0; j < n; ++j) {
                res = (res * n) + 1;
                if(j == n - 1) {        //此判断要在取余判断之前，因为此时的res即为倒推n轮后的总苹果树，不需再进行其它判断，退出返回结果即可
                    tag = false;
                    break;
                }
                if(res % (n - 1) != 0){
                    break;
                }
                res = res / (n - 1);
            }
            ++lastTake;
        }

        return res;
    }
}
