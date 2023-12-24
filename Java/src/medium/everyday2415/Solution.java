package medium.everyday2415;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class Solution {
    ArrayList<Stack<Integer>> arr = new ArrayList<>();

    public TreeNode reverseOddLevels(TreeNode root) {
        dfs1(root, 0);
        dfs2(root, 0);
        return root;
    }

    public void dfs1(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (level % 2 == 1) {
            if (arr.size() <= level / 2) {
                arr.add(new Stack<>());
            }
            arr.get(level / 2).push(root.val);
        }
        dfs1(root.left, level + 1);
        dfs1(root.right, level + 1);
    }

    public void dfs2(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (level % 2 == 1) {
            root.val = arr.get(level / 2).pop();
        }
        dfs2(root.left, level + 1);
        dfs2(root.right, level + 1);
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    //  TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
