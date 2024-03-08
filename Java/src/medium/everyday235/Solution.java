package medium.everyday235;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    /**
     * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
     * <p>
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    HashSet<Integer>hashSet;
    TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        hashSet = new HashSet<>();
        ans = null;
        dfs1(root, p.val);
        dfs2(root, q.val);
        return ans;
    }
    public boolean dfs1(TreeNode p, int x){
        if(p == null){
            return false;
        }
        if(p.val == x){
            hashSet.add(p.val);
            return true;
        }
        if(dfs1(p.left, x) || dfs1(p.right, x)){
            hashSet.add(p.val);
            return true;
        }
        return false;
    }
    public TreeNode dfs2(TreeNode p, int x){
        if(p == null){
            return null;
        }
        TreeNode left = dfs2(p.left, x);
        if(left != null){
            if (ans == null && hashSet.contains(p.val)){
                ans = p;
            }
            return p;
        }
        TreeNode right = dfs2(p.right, x);
        if(right != null){
            if (ans == null && hashSet.contains(p.val)){
                ans = p;
            }
            return p;
        }
        if(p.val == x){
            if (hashSet.contains(p.val)){
                ans = p;
            }
            return p;
        }
        return null;
    }
}
