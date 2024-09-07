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
    int diff = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        diff = Integer.MAX_VALUE;
        min(root);

        return diff;
    }

    public void min(TreeNode root) {
        if(root == null) {
            return;
        }

        if(root.left != null) {
            diff = Math.min(diff, Math.abs(root.val - getMax(root.left)));
        }

        if(root.right != null) {
            diff = Math.min(diff, Math.abs(root.val -getMin(root.right)));
        }
        min(root.left);
        min(root.right);
    }

    public int getMin(TreeNode node) {

        while(node.left != null) {
            node = node.left;
        }

        return node.val;
    }

    public int getMax(TreeNode node) {

        while(node.right != null) {
            node = node.right;
        }

        return node.val;
    }
}