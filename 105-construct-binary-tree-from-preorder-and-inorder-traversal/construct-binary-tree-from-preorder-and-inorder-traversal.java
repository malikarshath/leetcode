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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if(preorder.length != inorder.length) {
            return null;
        }

        Map<Integer, Integer> mp = new HashMap();

        for(int i = 0; i < n; i++) {
            mp.put(inorder[i], i);
        }
        return construct(0, n - 1, 0, n - 1, preorder, inorder, mp);
    }

    public TreeNode construct(int ps, int pe, int is, int ie, int[] preorder, int[] inorder,Map<Integer, Integer> mp) {
        if(ps > pe || is > ie) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[ps]);
        int rootIndex = mp.containsKey(root.val) ? mp.get(root.val) : -1;

        // for(int i = is ; i <= ie; i++) {
        //     if(inorder[i] == root.val) {
        //         rootIndex = i;
        //         break;
        //     }
        // } 

        if(rootIndex == -1) {
            return null;
        }
        int len = rootIndex - is;

        root.left = construct(ps + 1, ps + len, is, rootIndex - 1, preorder, inorder, mp);
        root.right = construct(ps + len + 1, pe, rootIndex + 1, ie, preorder, inorder, mp);
        return root;
    }
}