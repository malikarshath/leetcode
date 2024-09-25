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
    int maxValue;
    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        pathSum(root);
        return maxValue;
    }

    public int pathSum(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = pathSum(root.left);
        int right = pathSum(root.right);
        left = left < 0 ? 0 : left;
        right = right < 0 ? 0 : right;
        maxValue = Math.max(maxValue, root.val + left + right);

        return root.val + Math.max(left , right);
    }
}