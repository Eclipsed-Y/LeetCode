package medium.everyday2583;


import java.util.ArrayList;
import java.util.Comparator;

class Solution {
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
    ArrayList<Long> list;
    public long kthLargestLevelSum(TreeNode root, int k) {
        list = new ArrayList<>();
        dfs(root, 0);
        list.sort(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                return o2.compareTo(o1);
            }
        });
        if (list.size() < k){
            return -1;
        }
        return list.get(k - 1);
    }
    public void dfs(TreeNode root, int level){
        if(root == null){
            return;
        }
        if(list.size() <= level){
            list.add((long)root.val);
        } else {
            list.set(level, list.get(level) + root.val);
        }
        if(root.left != null){
            dfs(root.left, level + 1);
        }
        if(root.right != null){
            dfs(root.right, level + 1);
        }
    }
}