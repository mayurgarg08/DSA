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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> qu = new LinkedList<TreeNode>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        if(root == null) return wrapList;
        qu.offer(root);

        while(!qu.isEmpty()) {
            int size = qu.size();
            List<Integer> temp = new LinkedList<Integer>();
            for(int i = 0; i< size; i++) {
               TreeNode it = qu.poll();

            if(it.left != null) {
                qu.add(it.left);
             }
            if(it.right != null) {
                qu.add(it.right);
             }
             temp.add(it.val);
            }
            wrapList.add(temp);
        }
        return wrapList;
    }
}