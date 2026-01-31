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
    private void findInorder(List<Integer> inorder, TreeNode root) {
        if(root != null) {
            findInorder(inorder, root.left);
            inorder.add(root.val);
            findInorder(inorder, root.right);
        }
    }
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> inorder = new ArrayList<>();
        findInorder(inorder, root);
        int kth_Smallest = inorder.get(k-1);
        return kth_Smallest;
    }
}