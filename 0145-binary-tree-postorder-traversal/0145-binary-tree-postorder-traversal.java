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
       List<Integer> ans = new ArrayList<>();
       Stack<TreeNode> stk = new Stack<>();
       if(root == null) return ans;
       TreeNode curr = root;
       while(!stk.isEmpty() || curr != null) {
           if(curr != null) {
              stk.push(curr);
              curr = curr.left;
           } else {
              TreeNode temp = stk.peek().right;
              if(temp == null) {
                temp = stk.peek();
                stk.pop();
                ans.add(temp.val);
                while(!stk.isEmpty() && temp == stk.peek().right) {
                    temp = stk.peek();
                    stk.pop();
                    ans.add(temp.val);
                }

              } else {
                curr = temp;
              }
           } 
       }
       return ans;
    }
}