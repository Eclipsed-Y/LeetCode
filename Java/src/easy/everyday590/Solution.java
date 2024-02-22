package easy.everyday590;

import java.util.ArrayList;
import java.util.List;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

class Solution {
    List<Integer> ans;
    public List<Integer> postorder(Node root) {
        ans = new ArrayList<>();
        if (root == null){
            return ans;
        }
        dfs(root);
        return ans;
    }

    private void dfs(Node root) {
        for (Node child : root.children) {
            dfs(child);
        }
        ans.add(root.val);
    }
}