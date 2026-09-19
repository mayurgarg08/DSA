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
    public int hSum(TreeNode root, int[] maxValue) {
        if(root == null) return 0;
        int leftSum = Math.max(0, hSum(root.left, maxValue));
        int rightSum = Math.max(0, hSum(root.right, maxValue));

        maxValue[0] = Math.max(maxValue[0], leftSum + rightSum + root.val);
        return Math.max(leftSum, rightSum) + root.val;
    }
    public int maxPathSum(TreeNode root) {
        int maxValue[] = new int[1];
        maxValue[0] = Integer.MIN_VALUE;
        hSum(root, maxValue);
        return maxValue[0];
    }
}