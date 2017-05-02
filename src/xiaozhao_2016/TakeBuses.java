package xiaozhao_2016;

/**
 * Created by lhtan on 5/2/2017.
 */

/**
 * 从小明家所在公交站出发有n路公交到公司，现给出每路公交的停站数(不包括起点和终点)，及每次停的时间(一路车在每个站停的时间相同)和发车的间隔，先假定每辆车同时在相对时间0分开始发车，且所有车在相邻两个站之间的耗时相同,都为5分钟。给定小明起床的相对时间(相对0的分钟数)，请计算他最早到达公司的相对时间。
 给定每路车的停站数stops,停站时间period,发车间隔interval及公交路数n，出发时间s。请返回最早到达时间。保证公交路数小于等于500，停站数小于等于50
 */
public class TakeBuses {
    public int chooseLine(int[] stops, int[] period, int[] interval, int n, int s) {
        // write code here
        if(n == 0|| stops == null || period == null || interval == null || stops.length == 0
                || period.length == 0 || interval.length == 0) {
            return -1;
        }
        int[] wait = new int[n];
        for(int i = 0; i < n; ++i) {
            wait[i] = (s % interval[i] == 0 ? 0 : interval[i] - (s % interval[i]))
                    + (stops[i] + 1) * 5 + stops[i] * period[i];
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; ++i) {
            min = wait[i] < min ? wait[i] : min;
        }
        return min + s;                                     //最后不要忘记加起床时间，最后加可以省循环计算
    }
}
