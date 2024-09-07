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

        Queue<Pair> q = new LinkedList<>();

        Pair p = new Pair(leftLimit, rightLimit, root);
        q.add(p);

        while(!q.isEmpty()) {

            int size = q.size();

            for(int i = 1; i <= size; i++) {
                Pair curr = q.poll();
                long val = (long)curr.node.val;
                long left = curr.left;
                long right = curr.right;

                if(val < left || val > right) {
                    return false;
                } 

                if(curr.node.left != null) {
                    q.add(new Pair(left, val - 1, curr.node.left));
                }

                if(curr.node.right != null) {
                    q.add(new Pair(val + 1, right, curr.node.right));
                }
            }

        }

        return true;


    }

    class Pair {
        long left, right;
        TreeNode node;

        Pair(long l, long r, TreeNode n) {
            this.left = l;
            this.right = r;
            this.node = n;
        }
    }
}