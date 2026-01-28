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
    public List<Integer> preorderTraversal(TreeNode root) { 
        List<Integer> preorder = new ArrayList<>();
        if(root == null) return preorder;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()) {
            TreeNode it = st.pop();
            if(it.right != null) {
                st.push(it.right);
            } 
            if(it.left != null) {
                st.push(it.left);
            }
            preorder.add(it.val);
        }
        return preorder;
    }
}