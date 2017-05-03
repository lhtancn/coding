package xiaozhao_2016;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by lhtan on 5/3/2017.
 */

/**
 * 亮亮深吸一口气，小心地将盒子打开，里面是一张地图，地图上除了一些奇怪的字母以外没有任何路线信息，这可让亮亮犯了愁，这些字母代表了什么意思呢？ 亮亮绞尽脑汁也想不出什么思路，突然，亮亮眼前一亮，“我可以把这些字母所有的排列方式全部写出来，一定可以找到答案！” 于是，亮亮兴奋的开始寻找字母里的秘密。

 输入描述:
 每组数据输入只有一行，是一个由不同的大写字母组成的字符串，已知字符串的长度在1到9之间，我们假设对于大写字母有'A' < 'B' < ... < 'Y' < 'Z'。


 输出描述:
 输出这个字符串的所有排列方式，每行一个排列，要求字母序比较小的排列在前面。

 输入例子:
 WHL

 输出例子:
 HLW

 HWL

 LHW

 LWH

 WHL

 WLH
 */
public class Decipher {
    public void getSorts(){
        try(Scanner in = new Scanner(System.in)) {
            while(in.hasNext()) {
                char[] ca = in.next().toCharArray();
                TreeSet<String> set = new TreeSet<>();
                sortCore(ca, 0, set);
                for(String str : set) {
                    System.out.println(str);
                }
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void sortCore(char[] arr, int index, TreeSet<String> set) {
        if(index == arr.length - 1) {
            set.add(String.valueOf(arr));
            return;
        }
        for(int i = index; i < arr.length; ++i) {       //i从index开始，否则当前最高位不变的情况不统计
            char tmp = arr[i];
            arr[i] = arr[index];
            arr[index] = tmp;

            sortCore(arr, index + 1, set);

//            char tmp = arr[i];                           //不要重复定义tmp
            tmp = arr[i];
            arr[i] = arr[index];
            arr[index] = tmp;
        }
    }
}