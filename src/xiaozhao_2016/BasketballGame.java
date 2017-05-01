package xiaozhao_2016;

import java.util.Scanner;

/**
 * Created by lhtan on 5/1/2017.
 */

/**
 * 从此题得出，Scanner的in有如下特点，buf中会一次性缓存所有输入（貌似不超过1024字符），换行以一个字符'\n'存入，
 * 当用nextInt(), next()等非nextLine()方法时，会自动跳过换行存储的'\n'，读取下一个输入时由空格分隔的数据（会判断是否符合要求，不符合抛异常，比如'ds'不符合nextInt()），
 * 若用nextLine()时，它会读取当前位置到'\n'（包括在内）之间的字符。
 */
public class BasketballGame {
    public void getIndex() {
        Scanner in = new Scanner(System.in);
        try{
            while(in.hasNext()) {
                int pacNum = in.nextInt();
                int basketNum = in.nextInt();
        //        in.nextLine();                    将此行取消掉，也可行，所以当都用nextInt(), nextDouble(), next()等（非nextLine()）不会因'\n'产生冲突

                boolean tag = false;
                int outRes = 0;
                int[] vector = new int[pacNum];
                for(int i = 0; i < basketNum; ++i) {
                    int res = in.nextInt() % pacNum;
               //     in.nextLine();           把此行取消掉，牛客也能通过，且用内存更少
                    if(vector[res] == 1 && !tag) {
                        tag = true;
                        outRes = i + 1;
//                        System.out.println(i + 1);
//                        break;                    不能直接中断，因为后面还有数据，要等这次测试用例数据全部跑完，下个用例才能正常测试
                    }else {
                        vector[res] = 1;
                    }
                }
                if(tag) {
                    System.out.println(outRes);
                }else {
                    System.out.println("-1");
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally{
            in.close();
        }
    }
}
