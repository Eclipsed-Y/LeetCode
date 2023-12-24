package medium.everyday1631;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    /*
    你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，其中 heights[row][col] 表示格子 (row, col) 的高度。一开始你在最左上角的格子 (0, 0) ，且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。你每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。

一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。

请你返回从左上角走到右下角的最小 体力消耗值 。
     */
    public int minimumEffortPath(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        int right = heights[0][0], left = heights[0][0];
        for (int[] height : heights) {
            for (int i : height) {
                right =  Math.max(right, i);
                left = Math.min(left, i);
            }
        }
        int ans = right - left;
        left = 0;
        right = ans - 1;
        while (left <= right){
            flag = new int[m][n];
            int now = (left + right)/ 2;
            if (check(heights, now)){
                ans = now;
                right = now - 1;
            } else{
                left = now + 1;
            }
        }
        return ans;
    }
    int m, n;
    int[] dy = {0, 1, 0, -1}, dx = {1, 0, -1, 0};
    int[][] flag;
    public boolean check(int[][] heights, int now) {
        ArrayList<ArrayList<Integer>> q = new ArrayList<>();
        q.add(new ArrayList<>(Arrays.asList(0, 0)));
        flag[0][0] = 1;
        while(!q.isEmpty()){
            ArrayList<Integer> cur = q.remove(0);
            int y = cur.get(0), x = cur.get(1);
            if(y == m - 1 && x == n - 1)return true;
            for (int i = 0; i < 4; i++) {
                int next_y =  y + dy[i], next_x = x + dx[i];
                if(next_y >= 0 && next_y < m &&next_x >= 0 && next_x < n && flag[next_y][next_x] == 0 && Math.abs(heights[next_y][next_x] - heights[y][x]) <= now){
                    flag[next_y][next_x] = 1;
                    q.add(new ArrayList<>(Arrays.asList(next_y, next_x)));
                }
            }
        }
        return false;
    }
}
