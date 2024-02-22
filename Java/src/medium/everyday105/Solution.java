package medium.everyday105;




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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int[] inorder, int pleft, int pright, int ileft, int iright) {
        TreeNode root = new TreeNode(preorder[pleft], null, null);
        int idx = ileft;
        for (int i = ileft; i <= iright; i++) {
            if (inorder[i] == preorder[pleft]){
                idx = i;
                break;
            }
        }
        int leftNum = idx - ileft;
        if (leftNum > 0) {
            root.left = build(preorder, inorder, pleft + 1, pleft + leftNum, ileft, idx - 1);
        }
        int rightNum = iright - idx;
        if (rightNum > 0) {
            root.right = build(preorder, inorder, pleft + leftNum + 1, pright, idx + 1, iright);
        }
        return root;
    }
}
