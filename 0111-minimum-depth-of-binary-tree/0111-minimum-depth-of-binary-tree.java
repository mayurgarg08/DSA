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
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        return helper(0, root);
    }
    private int helper(int count, TreeNode node) {
        if(node.left == null && node.right == null) return count+1;
        int left = 0, right = 0;
        if(node.left != null) left += helper(count+1, node.left);
        if(node.right != null) right += helper(count+1, node.right);
        if(left == 0) return right;
        if(right == 0) return left;
        return Math.min(left, right);
    }
}