package medium.demo;

import java.util.*;

public class BFS {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }
    public List<Integer> bfs(TreeNode root){
        HashSet<Integer> set = new HashSet<>();
        
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        List<Integer>ans = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            ans.add(node.val);
            if (node.left != null)
                q.add(node.left);
            if (node.right != null)
                q.add(node.right);
        }
        return ans;
    }
}
