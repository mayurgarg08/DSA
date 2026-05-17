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
    public List<String> binaryTreePaths(TreeNode root) {
       List<String> ans = new ArrayList<>();
       if(root == null) return ans;
       helper(root, new StringBuilder(), ans);
       return ans;
    }
    private void helper(TreeNode node, StringBuilder current, List<String> ans) {
         int len = current.length();
         current.append(node.val);

        if(node.left == null && node.right == null) {
            ans.add(current.toString());
            current.setLength(len); 
            return;
        }

        current.append("->");

        if(node.left != null)
            helper(node.left, current, ans);

        if(node.right != null)
            helper(node.right, current, ans);

        current.setLength(len);
    } 
}