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

    public boolean isValidBST(TreeNode root) {

        if(root == null) {
            return false;
        }

        if(root.left == null && root.right == null) {
            return true;
        }
        
        long leftLimit = Integer.MIN_VALUE;
        long rightLimit = Integer.MAX_VALUE;


        return isBST(root, leftLimit, rightLimit);


    }

    public boolean isBST(TreeNode A, long left, long right) {
        if(A == null) {
            return true;
        }

        long val = (long)A.val;
        if(val < left || val > right) {
            return false;
        }


        boolean l = isBST(A.left, left, val - 1);
        if(l == false) {
            return false;
        }
        boolean r = isBST(A.right, val + 1, right);

        return l && r;
    }

    
}