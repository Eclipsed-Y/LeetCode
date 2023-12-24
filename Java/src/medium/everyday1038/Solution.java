package medium.everyday1038;

import java.util.HashMap;
import java.util.function.BiConsumer;

public class Solution {

    /*
    给定一个二叉搜索树 root (BST)，请将它的每个节点的值替换成树中大于或者等于该节点值的所有节点值之和。

提醒一下， 二叉搜索树 满足下列约束条件：

节点的左子树仅包含键 小于 节点键的节点。
节点的右子树仅包含键 大于 节点键的节点。
左右子树也必须是二叉搜索树。
     */
    public HashMap<Integer, Integer>hm = new HashMap<>();
    public TreeNode bstToGst(TreeNode root) {
        travel(root);
        change(root);
        return root;
    }
    public void travel(TreeNode p){
        if (p!=null){
            if(hm.containsKey(p.val)){
                hm.put(p.val, hm.get(p.val) + 1);
            } else{
                hm.put(p.val, 1);
            }
            travel(p.left);
            travel(p.right);
        }
    }
    public void change(TreeNode p){
        if (p!=null){
            final int[] tmp = {0};
            hm.forEach(new BiConsumer<Integer, Integer>() {
                @Override
                public void accept(Integer integer, Integer integer2) {
                    if (p.val <= integer){
                        tmp[0] += integer * integer2;
                    }
                }
            });
            p.val = tmp[0];
            change(p.left);
            change(p.right);
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
        this.left = left;
        this.right = right;
    }
}
