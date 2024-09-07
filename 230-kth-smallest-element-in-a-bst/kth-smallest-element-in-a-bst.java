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
    int num = 0;
    public int kthSmallest(TreeNode root, int k) {
       num = k;
       return kth(root);     
    }

    public int kth(TreeNode root) {
         if(root == null) {
            return -1;
        }

        int left = kth(root.left);
        num--;
        if(num == 0) {
            return root.val;
        }
        if(left != -1) {
            return left;
        }
        int right = kth(root.right);

        return right;
    }
}