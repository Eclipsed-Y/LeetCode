package medium._everyday2477;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Solution {
    /*
    给你一棵 n 个节点的树（一个无向、连通、无环图），每个节点表示一个城市，编号从 0 到 n - 1 ，且恰好有 n - 1 条路。0 是首都。给你一个二维整数数组 roads ，其中 roads[i] = [ai, bi] ，表示城市 ai 和 bi 之间有一条 双向路 。

每个城市里有一个代表，他们都要去首都参加一个会议。

每座城市里有一辆车。给你一个整数 seats 表示每辆车里面座位的数目。

城市里的代表可以选择乘坐所在城市的车，或者乘坐其他城市的车。相邻城市之间一辆车的油耗是一升汽油。

请你返回到达首都最少需要多少升汽油。
     */
    HashSet<Integer> hs = new HashSet<>();
    long ans = 0;

    public long minimumFuelCost(int[][] roads, int seats) {
        int n = 0;
        for (int[] road : roads) {
            n = Math.max(Math.max(n, road[0]), road[1]);
        }
        n += 1;
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            matrix.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            matrix.get(road[0]).add(road[1]);
            matrix.get(road[1]).add(road[0]);
        }
        hs.add(0);
        dfs(matrix, 0, seats);
        return ans;
    }

    public long dfs(ArrayList<ArrayList<Integer>> matrix, int now, int seats) {
        long people = 0;
        for (int i = 0; i < matrix.get(now).size(); i++) {
            if (!hs.contains(matrix.get(now).get(i))) {
                hs.add(matrix.get(now).get(i));
                long tmp = dfs(matrix, matrix.get(now).get(i), seats);
                ans += tmp / seats;
                if (tmp % seats != 0) {
                    ans += 1;
                }
                people += tmp;
            }
        }

        return people + 1;
    }
}
