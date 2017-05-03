package xiaozhao_2016;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lhtan on 5/3/2017.
 */
/*
有一个二维数组(n*n),写程序实现从右上角到左下角沿主对角线方向打印。
        给定一个二位数组arr及题目中的参数n，请返回结果数组。
        测试样例：
        [[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]],4
        返回：[4,3,8,2,7,12,1,6,11,16,5,10,15,9,14,13]
*/

public class Printer {
    public int[] arrayPrint(int[][] arr, int n) {
        // write code here
        if(arr == null || arr.length == 0) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        for(int k = n - 1; k >= 0; k--) {
            int xPos = 0;
            for(int j = k; j < n; j++) {
                list.add(arr[xPos++][j]);
            }
        }
        for(int k = 1; k < n; ++k) {
            int yPos = 0;
            for(int i = k; i < n; ++i) {
                list.add(arr[i][yPos++]);
            }
        }
        int[] resArr = new int[list.size()];            //list.toArray(T[])可将list<Integer> --> Integer[], 但是不能 --> int[]
        for(int i = 0; i < resArr.length; ++i) {
            resArr[i] = list.get(i);
        }
        return resArr;
    }
}
