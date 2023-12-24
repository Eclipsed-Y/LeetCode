package medium.everyday1457;

import java.util.HashMap;

public class Solution {
    /*
            给你一棵二叉树，每个节点的值为 1 到 9 。我们称二叉树中的一条路径是 「伪回文」的，当它满足：路径经过的所有节点值的排列中，存在一个回文序列。
        请你返回从根到叶子节点的所有路径中 伪回文 路径的数目。
     */
    HashMap<Integer, Integer> hm = new HashMap<>();
    int ans = 0;

    public int pseudoPalindromicPaths(TreeNode root) {
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode p) {
        if (hm.containsKey(p.val)) {
            hm.remove(p.val);
        } else {
            hm.put(p.val, 1);
        }
        if (p.left == null && p.right == null) {
            if (hm.size() <= 1) {
                ans += 1;
            }
        }
        if (p.left != null) {
            dfs(p.left);
        }
        if (p.right != null){
            dfs(p.right);
        }
        if (hm.containsKey(p.val)) {
            hm.remove(p.val);
        } else {
            hm.put(p.val, 1);
        }
    }
}

class TreeNode {
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
