/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        int s = 0;
        int e = inorder.length - 1;

        return build(inorder, postorder, s, e, s, e);
        
    }

    public TreeNode build(int[] in, int[] po, int is, int ie, int ps, int pe) {
        if(ps > pe || is > ie) {
            return null;
        }

        TreeNode root = new TreeNode(po[pe]);

        int rootIndex = -1;

        for(int i = is; i <= ie; i++) {
            if(root.val == in[i]) {
                rootIndex = i;
                break;
            }
        }

        if(rootIndex == -1) return null;

        int x = ie - rootIndex;

        root.left = build(in, po, is, rootIndex - 1, ps, pe - x - 1);
        root.right = build(in, po, rootIndex + 1, ie, pe - x, pe - 1);

        return root;
    }
}