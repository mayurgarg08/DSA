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
    private int height(TreeNode root) {
        if(root == null) return 0;
        int leftH = 1 + height(root.left);
        int rightH = 1 + height(root.right);

        return Math.max(leftH, rightH);
    }
    public int diameterOfBinaryTree(TreeNode root) {
       if(root == null) return 0;

       int leftH = height(root.left);
       int rightH = height(root.right);
       
       int currH = leftH + rightH;

       int leftD = diameterOfBinaryTree(root.left);
       int rightD = diameterOfBinaryTree(root.right);

       return Math.max(currH, Math.max(leftD, rightD));
    }
}