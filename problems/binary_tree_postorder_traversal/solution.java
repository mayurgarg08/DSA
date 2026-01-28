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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> post = new ArrayList<>();
       TreeNode curr = root;
       Stack<TreeNode> st = new Stack<>();
       while(curr != null || !st.isEmpty()) {
        if(curr != null) {
            st.push(curr);
            curr = curr.left;
        } else {
            TreeNode temp = st.peek().right;
            if(temp == null) {
                temp = st.pop();
                post.add(temp.val);
                while (!st.isEmpty() && temp == st.peek().right) {
                    temp = st.pop();
                    post.add(temp.val);
                }
            } else {
                curr = temp;
            }
        }
       }
       return post;
    }
}