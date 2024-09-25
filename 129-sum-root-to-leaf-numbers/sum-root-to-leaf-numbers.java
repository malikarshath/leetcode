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
        sumNumbers(root, "");
        return finalAns;
    }

    public void sumNumbers(TreeNode root, String str) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            String finalStr = str + String.valueOf(root.val);
            finalAns += Integer.valueOf(finalStr);
            return;
        }

        String currVal = str + String.valueOf(root.val);

        sumNumbers(root.left, currVal);
        sumNumbers(root.right, currVal);
    }
}