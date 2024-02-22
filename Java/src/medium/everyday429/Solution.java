package medium.everyday429;


import java.util.ArrayList;
import java.util.List;

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
    List<List<Integer>>ans;
    public List<List<Integer>> levelOrder(Node root) {

        ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        dfs(root, 0);
        return ans;
    }
    public void dfs(Node p, int depth){
        if(ans.size() <= depth) {
            ans.add(new ArrayList<>());
        }
        ans.get(depth).add(p.val);
        for (Node child : p.children) {
            dfs(child, depth + 1);
        }
    }
}