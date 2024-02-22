package medium.everyday106;

public class Solution {
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, postorder, 0, postorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode build(int[] inorder, int[] postorder, int pleft, int pright, int ileft, int iright) {
        TreeNode root = new TreeNode(postorder[pright], null, null);
        int idx = ileft;
        for (int i = ileft; i <= iright; i++) {
            if (inorder[i] == postorder[pright]){
                idx = i;
                break;
            }
        }
        int leftNum = idx - ileft;
        if (leftNum > 0) {
            root.left = build(inorder, postorder, pleft, pleft + leftNum - 1, ileft, idx - 1);
        }
        int rightNum = iright - idx;
        if (rightNum > 0) {
            root.right = build(inorder, postorder, pleft + leftNum, pright - 1, idx + 1, iright);
        }
        return root;
    }
}
