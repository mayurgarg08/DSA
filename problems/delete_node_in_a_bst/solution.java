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
    private TreeNode rightMost(TreeNode node) {
        if(node.right == null) {
            return node;
        }
        return rightMost(node.right);
    }
    private TreeNode helper(TreeNode node) {
        if(node.left == null) {
           return node.right;
        } 
        if(node.right == null) {
            return node.left;
        }
        TreeNode right = node.right;
        TreeNode lastRight = rightMost(node.left);
        lastRight.right = right;
        return node.left;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val == key) return helper(root);
        TreeNode dummy = root;
         while(root != null) {
            if(root.val > key) {
                if(root.left != null && root.left.val == key) {
                    root.left = helper(root.left);
                    break;
                } else {
                    root = root.left;
                }
            } else {
                if(root.right != null && root.right.val == key) {
                    root.right = helper(root.right);
                    break;
                } else {
                    root = root.right;
                }
            }
         }
         return dummy;
    }
}