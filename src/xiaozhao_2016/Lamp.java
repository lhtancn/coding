package xiaozhao_2016;

import java.text.DecimalFormat;
import java.util.*;

/**
 * Created by lhtan on 5/3/2017.
 */

/**
 * 一条长l的笔直的街道上有n个路灯，若这条街的起点为0，终点为l，第i个路灯坐标为ai，每盏灯可以覆盖到的最远距离为d，为了照明需求，所有灯的灯光必须覆盖整条街，但是为了省电，要是这个d最小，请找到这个最小的d。

 输入描述:
 每组数据第一行两个整数n和l（n大于0小于等于1000，l小于等于1000000000大于0）。第二行有n个整数(均大于等于0小于等于l)，为每盏灯的坐标，多个路灯可以在同一点。


 输出描述:
 输出答案，保留两位小数。

 输入例子:
 7 15
 15 5 3 7 9 14 0

 输出例子:
 2.50
 */

public class Lamp {
    public void getMinDis(){
        try(Scanner in = new Scanner(System.in)){
            while(in.hasNext()) {
                String[] arr = in.nextLine().split(" ");
                if(arr.length != 2) {
                    continue;
                }
      //          int lampNum = Integer.parseInt(arr[0]);
                int dis = Integer.parseInt(arr[1]);
                String[] pos = in.nextLine().split(" ");
                Set<Integer> set = new TreeSet<>();
                for(String item : pos) {
                    int lampPos = Integer.parseInt(item);
                    set.add(lampPos);
                }
                double[] gap = new double[set.size() + 1];
                int prePos = 0;
                int index = 0;
                Iterator<Integer> it = set.iterator();          //Iterator的使用方式
                for(; it.hasNext();) {
                    int curPos = it.next();
                    gap[index] = (curPos - prePos) / 2.0;
                    if(index == 0) {
                        gap[index] *= 2;
                    }
                    ++index;
                    prePos = curPos;
                    if(index == set.size()) {
                        gap[index] = dis - curPos;
                        break;
                    }
                }
                Arrays.sort(gap);
                DecimalFormat df = new DecimalFormat("0.00");       //double格式化输出， 需导入java.text.DecimalFormat.
                System.out.println(df.format(gap[gap.length - 1]));
            }

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}