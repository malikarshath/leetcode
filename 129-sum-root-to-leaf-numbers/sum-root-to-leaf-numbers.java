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
    int finalAns = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null) {
            return 0;
        }
        finalAns = 0;
        sumNumbers(root,0);
        return finalAns;
    }

    public void sumNumbers(TreeNode root, int num) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            finalAns += (num * 10) + root.val;
            return;
        }

        int currVal = num * 10 + root.val;

        sumNumbers(root.left, currVal);
        sumNumbers(root.right, currVal);
    }
}