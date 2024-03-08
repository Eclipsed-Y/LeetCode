package medium.everyday2476;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    /**
     * 给你一个 二叉搜索树 的根节点 root ，和一个由正整数组成、长度为 n 的数组 queries 。
     * <p>
     * 请你找出一个长度为 n 的 二维 答案数组 answer ，其中 answer[i] = [mini, maxi] ：
     * <p>
     * mini 是树中小于等于 queries[i] 的 最大值 。如果不存在这样的值，则使用 -1 代替。
     * maxi 是树中大于等于 queries[i] 的 最小值 。如果不存在这样的值，则使用 -1 代替。
     * 返回数组 answer 。
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        int n = queries.size();
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ans.add(Arrays.asList(-1, -1));
        }
        int[][] q = new int[n][2];
        for (int i = 0; i < q.length; i++) {
            q[i][0] = queries.get(i);
            q[i][1] = i;
        }
        Arrays.sort(q, Comparator.comparingInt(o -> o[0]));
        List<Integer> tree = new ArrayList<>();
        dfs(root, tree);
        int[] max = new int[n], min = new int[n];
        Arrays.fill(max, -1);
        Arrays.fill(min, -1);
        int i = 0, j = 0;
        while (j < n){
            boolean flag = false;
            while (i < tree.size() && tree.get(i) <= q[j][0]){
                flag = true;
                min[j] = tree.get(i);
                i++;
            }
            if (flag){
                i--;
            }
            j++;
        }
        j = n - 1;
        i = tree.size() - 1;
        while (j >= 0){
            boolean flag = false;
            while (i >= 0 && tree.get(i) >= q[j][0]){
                flag = true;
                max[j] = tree.get(i);
                i --;
            }
            if (flag){
                i ++;
            }
            j--;
        }
        for (int k = 0; k < n; k++) {
            ans.set(q[k][1], new ArrayList<>(Arrays.asList(min[k], max[k])));
        }
        return ans;
    }
    public void dfs(TreeNode root, List<Integer> tree){
        if(root == null){
            return;
        }
        if (root.left != null){
            dfs(root.left, tree);
        }
        tree.add(root.val);
        if (root.right != null){
            dfs(root.right, tree);
        }
    }
}
