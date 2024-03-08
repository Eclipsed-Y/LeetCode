package medium.everyday2368;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    /**
     * 现有一棵由 n 个节点组成的无向树，节点编号从 0 到 n - 1 ，共有 n - 1 条边。
     *
     * 给你一个二维整数数组 edges ，长度为 n - 1 ，其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条边。另给你一个整数数组 restricted 表示 受限 节点。
     *
     * 在不访问受限节点的前提下，返回你可以从节点 0 到达的 最多 节点数目。
     *
     * 注意，节点 0 不 会标记为受限节点。
     */
    int ans;
    int n;
    ArrayList<ArrayList<Integer>>matrix;
    int[] flag;
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        ans = 0;
        this.n = n;
        flag = new int[n];
        matrix = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            matrix.add(new ArrayList<>());
        }
        int [] r = new int[n];
        for (int x : restricted) {
            r[x] = 1;
        }
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            if (r[x] == 1 || r[y] == 1) {
                continue;
            }
            matrix.get(x).add(y);
            matrix.get(y).add(x);
        }
        dfs(0);
        return ans;
    }
    public void dfs(int x){
        flag[x] = 1;
        ans += 1;
        for (Integer next : matrix.get(x)) {
            if(flag[next] == 0){
                dfs(next);
            }
        }
    }

}
