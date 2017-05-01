package xiaozhao_2016;

import java.util.Scanner;

/**
 * Created by lhtan on 5/1/2017.
 */
/*
有一个数组a[N]顺序存放0~N-1，要求每隔两个数删掉一个数，到末尾时循环至开头继续进行，求最后一个被删掉的数的原始下标位置。以8个数(N=7)为例:｛0，1，2，3，4，5，6，7｝，0->1->2(删除)->3->4->5(删除)->6->7->0(删除),如此循环直到最后一个数被删除。

        输入描述:
        每组数据为一行一个整数n(小于等于1000)，为数组成员数,如果大于1000，则对a[999]进行计算。


        输出描述:
        一行输出最后一个被删掉的数的原始下标位置。

        输入例子:
        8

        输出例子:
        6
*/


public class DeleteNum {
    public void deleteCore() {
        int circle = 2;
        try(Scanner in = new Scanner(System.in)) {
            while(in.hasNext()) {
                int num = in.nextInt();
                num = num > 1000 ? 1000 : num;
                boolean[] arr = new boolean[num];
                int arrIndex = 0;
                int resNum = num;
                while(resNum > 1) {
                    if(circle == 0) {
                        arr[arrIndex] = true;
                        circle = 2;
                        --resNum;
                    }else {
                        --circle;
                    }

                    ++arrIndex;
                    if(arrIndex == num) {
                        arrIndex = 0;
                    }
                    while(arr[arrIndex] && resNum > 0) {            //resNum条件应是大于0，这样才能保证最终的arrIndex是最后剩的，而不是上次删掉的下一位（这位可能也被删掉了）
                        ++arrIndex;
                        if(arrIndex == num) {
                            arrIndex = 0;
                        }
                    }

                }
                System.out.println(arrIndex);           //得出结果要记得打印输出
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
