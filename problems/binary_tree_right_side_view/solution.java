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
    private void rightView(TreeNode node, List<Integer> res, int currDepth) {
        if(node == null) return;

        if(currDepth == res.size()) {
            res.add(node.val);
        }
        rightView(node.right, res, currDepth+1);
        rightView(node.left, res, currDepth+1);
    }
    public List<Integer> rightSideView(TreeNode root) {
       List<Integer> res = new ArrayList<>();
       rightView(root, res, 0);
       return res;
    }
}