package medium.everyday889;

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

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return build(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preleft, int preright, int[] postorder, int postleft, int postright) {
        if (preleft > preright){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preleft], null, null);
        if (preleft < preright) {
            int idx = postleft;
            while (postorder[idx] != preorder[preleft + 1]) {
                idx++;
            }
            int preNum =  1 + idx - postleft;
            root.left = build(preorder, preleft + 1, preleft + preNum, postorder, postleft, idx);
            root.right = build(preorder, preleft + preNum + 1, preright, postorder, idx + 1, postright - 1);
        }
        return root;
    }
}
