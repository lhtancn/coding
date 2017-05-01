package xiaozhao_2016;

import java.util.Scanner;

/**
 * Created by lhtan on 5/1/2017.
 */
/*
A和B是好友，他们经常在空闲时间聊天，A的空闲时间为[a1 ,b1 ],[a2 ,b2 ]..[ap ,bp ]。B的空闲时间是[c1 +t,d1 +t]..[cq +t,dq +t],这里t为B的起床时间。这些时间包括了边界点。B的起床时间为[l,r]的一个时刻。若一个起床时间能使两人在任意时刻聊天，那么这个时间就是合适的，问有多少个合适的起床时间？

        输入描述:
        第一行数据四个整数：p,q,l,r（1≤p,q≤50,0≤l≤r≤1000)。接下来p行数据每一行有一对整数ai，bi(0≤aii+1>bi,ci+1>di


        输出描述:
        输出答案个数

        输入例子:
        2 3 0 20
        15 17
        23 26
        1 4
        7 11
        15 17

        输出例子:
        20
*/

/**
 * 只有对于某起床时间，a和b的休闲时间有重叠，则算这个时间有效
 */
public class Chatting {
    public void getSuitTime() {
        Scanner in = new Scanner(System.in);
        try{
            while(in.hasNext()) {
                int aRestTimes = in.nextInt();
                int bRestTimes = in.nextInt();
                int bGetStart = in.nextInt();
                int bGetEnd = in.nextInt();
                in.nextLine();
                int[] aPart = new int[aRestTimes << 1];
                int[] bPart = new int[bRestTimes << 1];
                for(int i = 0; i < aRestTimes; ++i) {
                    aPart[i << 1] = in.nextInt();
                    aPart[(i << 1) + 1] = in.nextInt();
                    in.nextLine();
                }
                if(bRestTimes == 0) {
                    System.out.println("0");
                    continue;
                }
                for(int i = 0; i < bRestTimes; ++i) {
                    bPart[i << 1] = in.nextInt();
                    bPart[(i << 1) + 1] = in.nextInt();
                    in.nextLine();
                }
                int res = 0;
                //三重循环，要找优化方法
                for(int i = bGetStart; i <= bGetEnd; ++i) {
                    boolean tag = false;
                    for(int j = 0; j < aRestTimes; ++j) {
                        int aIndex = j << 1;
                        for(int k = 0; k < bRestTimes; ++k) {
                            int bIndex = k << 1;
                            if(!(bPart[bIndex] + i > aPart[aIndex + 1]
                                    || bPart[bIndex + 1] + i < aPart[aIndex])) {
                                ++res;
                                tag = true;
                                break;
                            }
                        }
                        if(tag) {
                            break;
                        }
                    }
                }
                System.out.println(res);
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            in.close();
        }
    }
}
