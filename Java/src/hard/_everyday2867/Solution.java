package hard._everyday2867;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    /**
     * 给你一棵 n 个节点的无向树，节点编号为 1 到 n 。给你一个整数 n 和一个长度为 n - 1 的二维整数数组 edges ，其中 edges[i] = [ui, vi] 表示节点 ui 和 vi 在树中有一条边。
     *
     * 请你返回树中的 合法路径数目 。
     *
     * 如果在节点 a 到节点 b 之间 恰好有一个 节点的编号是质数，那么我们称路径 (a, b) 是 合法的 。
     *
     * 注意：
     *
     * 路径 (a, b) 指的是一条从节点 a 开始到节点 b 结束的一个节点序列，序列中的节点 互不相同 ，且相邻节点之间在树上有一条边。
     * 路径 (a, b) 和路径 (b, a) 视为 同一条 路径，且只计入答案 一次 。
     */
    HashSet<Integer>[] graph;
    long ans;
    int n;
    HashSet<Integer> primes;
    public long countPaths(int n, int[][] edges) {
        this.n = n;
        primes = new HashSet<>();
        ans = 0;
        graph = new HashSet[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new HashSet<>();
        }
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            graph[x - 1].add(y - 1);
            graph[y - 1].add(x - 1);
        }
        for (int i = 0; i < n; i++) {
            if (isPrime(i)){
                primes.add(i);
            }
        }
        for (int i = 0; i < n; i++) {
            if (primes.contains(i)){
                ArrayList<Long> list = new ArrayList<>();
                for (Integer x : graph[i]) {
                    if (!primes.contains(x)){
                        list.add(dfs(x, new int[n]));
                    }
                }
                for (int j = 0; j < list.size(); j++) {
                    ans += list.get(j);
                    for (int k = j + 1; k < list.size(); k++) {
                        ans += list.get(j) * list.get(k);
                    }
                }
            }
        }
        return ans;
    }
    public long dfs(int x, int[] flag){
        long cnt = 0;
        flag[x] = 1;
        for (Integer tar : graph[x]) {
            if(!primes.contains(tar) && flag[tar] == 0){
                cnt += dfs(tar, flag);
            }
        }
        return cnt + 1;
    }
    public boolean isPrime(int x){
        x++;
        if(x == 1){
            return false;
        }
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if(x % i == 0){
                return false;
            }
        }
        return true;
    }
}
