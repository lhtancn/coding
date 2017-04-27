package xiaozhao_2016;

/**
 * Created by lhtan on 4/27/2017.
 */

/*
现在有一个城市销售经理，需要从公司出发，去拜访市内的商家，已知他的位置以及商家的位置，但是由于城市道路交通的原因，他只能在左右中选择一个方向，在上下中选择一个方向，现在问他有多少种方案到达商家地址。
        给定一个地图map及它的长宽n和m，其中1代表经理位置，2代表商家位置，-1代表不能经过的地区，0代表可以经过的地区，请返回方案数，保证一定存在合法路径。保证矩阵的长宽都小于等于10。
        测试样例：
        [[0,1,0],[2,0,0]],2,3
        返回：2
*/

public class Visit {
    public int countPath(int[][] map, int n, int m) {
        // write code here
        if(map == null || map.length == 0) {
            return 0;
        }
        int[] mPos = new int[3];        //经理位置
        int[] rPos = new int[3];		//零售商位置
        findPos(map, mPos, rPos);
        if(mPos[2] == 0 || rPos[2] == 0) {
            return 0;
        }
        int[][] count = new int[n][m];
        updateCount(map, mPos, rPos, count);
        return count[rPos[0]][rPos[1]];
    }

    private void updateCount(int[][] map, int[] mPos, int[] rPos, int[][] count) {
        int rowTo = mPos[0] > rPos[0] ? -1 : 1;
        int colTo = mPos[1] > rPos[1] ? -1 : 1;
        for(int i = mPos[0]; i != rPos[0] + rowTo; i += rowTo) {
            for(int j = mPos[1]; j != rPos[1] + colTo; j += colTo) {
                if(i == mPos[0] && j == mPos[1]) {
                    count[i][j] = 1;
                    continue;
                }
                if(i == mPos[0]) {
                    count[i][j] = (map[i][j] == -1 ? 0 : count[i][j - colTo]);
                }else if(j == mPos[1]) {
                    count[i][j] = (map[i][j] == -1 ? 0 : count[i - rowTo][j]);
                }else {
                    count[i][j] = (map[i][j] == -1 ? 0 : count[i - rowTo][j] + count[i][j - colTo]);
                }
            }
        }
    }

    private void findPos(int[][] map, int[] mPos, int[] rPos) {
        for(int i = 0; i < map.length; ++i) {
            for(int j = 0; j < map[0].length; ++j) {
                if(map[i][j] == 1) {
                    mPos[0] = i;
                    mPos[1] = j;
                    mPos[2] = 1;
                }else if(map[i][j] == 2){
                    rPos[0] = i;
                    rPos[1] = j;
                    rPos[2] = 1;
                }
            }
        }
    }
}
