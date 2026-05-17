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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
       List<List<Integer>> ans = new ArrayList<>();
       if(root == null) return ans;
       helper(root, 0, new ArrayList<>(), ans, targetSum);
       return ans;
    }
    private void helper(TreeNode node, int sum, List<Integer> current, List<List<Integer>> ans, int targetSum) {
        if(node.left == null && node.right == null) {
            if(sum + node.val == targetSum) {
                current.add(node.val);
                ans.add(new ArrayList<>(current));
                current.remove(current.size()-1);
            }
            return;
        }
        current.add(node.val);
        if(node.left != null) helper(node.left, sum + node.val, current, ans, targetSum);
        if(node.right != null) helper(node.right, sum + node.val, current, ans, targetSum);
        current.remove(current.size()-1);
    } 
}