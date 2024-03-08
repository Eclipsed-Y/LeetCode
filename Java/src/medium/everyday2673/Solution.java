package medium.everyday2673;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    /**
     * 给你一个整数 n 表示一棵 满二叉树 里面节点的数目，节点编号从 1 到 n 。根节点编号为 1 ，树中每个非叶子节点 i 都有两个孩子，分别是左孩子 2 * i 和右孩子 2 * i + 1 。
     *
     * 树中每个节点都有一个值，用下标从 0 开始、长度为 n 的整数数组 cost 表示，其中 cost[i] 是第 i + 1 个节点的值。每次操作，你可以将树中 任意 节点的值 增加 1 。你可以执行操作 任意 次。
     *
     * 你的目标是让根到每一个 叶子结点 的路径值相等。请你返回 最少 需要执行增加操作多少次。
     *
     * 注意：
     *
     * 满二叉树 指的是一棵树，它满足树中除了叶子节点外每个节点都恰好有 2 个子节点，且所有叶子节点距离根节点距离相同。
     * 路径值 指的是路径上所有节点的值之和。
     */
    int ans;
    public int minIncrements(int n, int[] cost) {
        ans = 0;
        dfs(cost, 0, n - 1);
        return ans;
    }
    public int dfs(int[] cost, int now, int last){
        if (now * 2 + 1 > last){
            return cost[now];
        }
        int left = dfs(cost, now * 2 + 1, last);
        int right = dfs(cost, now * 2 + 2, last);
        ans += Math.abs(left - right);
        return cost[now] + Math.max(left, right);
    }
}
