package xiaozhao_2016;

import java.util.*;

/**
 * Created by lhtan on 5/2/2017.
 */

/**
 * 小v今年有n门课，每门都有考试，为了拿到奖学金，小v必须让自己的平均成绩至少为avg。每门课由平时成绩和考试成绩组成，满分为r。现在他知道每门课的平时成绩为ai ,若想让这门课的考试成绩多拿一分的话，小v要花bi 的时间复习，不复习的话当然就是0分。同时我们显然可以发现复习得再多也不会拿到超过满分的分数。为了拿到奖学金，小v至少要花多少时间复习。

 输入描述:
 第一行三个整数n,r,avg(n大于等于1小于等于1e5，r大于等于1小于等于1e9,avg大于等于1小于等于1e6)，接下来n行，每行两个整数ai和bi，均小于等于1e6大于等于1


 输出描述:
 一行输出答案。

 输入例子:
 5 10 9
 0 5
 9 1
 8 1
 0 1
 9 100

 输出例子:
 43
 */

public class ScholarShip {
    public void getTime() {
        try(Scanner in = new Scanner(System.in)) {
            while(in.hasNext()) {
                String[] arr = in.nextLine().split(" ");
                if(arr.length != 3) {
                    continue;
                }
                int lessionNum = Integer.parseInt(arr[0]);
                int fullMarks = Integer.parseInt(arr[1]);
                int ave = Integer.parseInt(arr[2]);
                int diffMarks = lessionNum * ave;
                Map<Integer, Integer> map = new HashMap<>();
                for(int i = 0; i < lessionNum; ++i) {
                    int hadMarks = in.nextInt();
                    diffMarks -= hadMarks;
                    int key = in.nextInt();
                    int value = fullMarks - hadMarks;   //剩余可获得分数
                    if(map.containsKey(key)) {
                        value += map.get(key);
                    }
                    map.put(key, value);
                }
                in.nextLine();
                if(diffMarks <= 0) {
                    System.out.println("0");
                    continue;
                }
                long time = 0;              //此处要用long型。int时，pow(2, 32) < pow(8, 11) < pow(10, 6 + 6 + 6) 所以可能会引起溢出

                Object[] keyArr = map.keySet().toArray();
                Arrays.sort(keyArr);

                for(Object i : keyArr) {
                    Integer item = Integer.parseInt(String.valueOf(i));
                    int value = map.get(item);
                    if(diffMarks > value) {
                        diffMarks -= value;
                        time += value * item;
                    }else {
                        time += diffMarks * item;
                        diffMarks = 0;
                        break;
                    }
                }
                if(diffMarks == 0) {
                    System.out.println(time);
                }
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}