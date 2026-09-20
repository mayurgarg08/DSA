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
 class Pair {
    TreeNode node;
    int num;

    Pair(TreeNode node, int num) {
        this.node = node;
        this.num = num;
    }
 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
       if(root == null) return 0;
       int ans = 0;
       Queue<Pair> q = new LinkedList<>();
       q.offer(new Pair(root, 0));
       while(!q.isEmpty()) {
        int size = q.size();
        int first = 0, last = 0;
        for(int i = 0; i < size; i++) {
           int currId = q.peek().num;
           TreeNode curr = q.peek().node;
           q.poll();
           if(i == 0) first = currId;
           if(i == size-1) last = currId;
           if(curr.left != null) {
               q.offer(new Pair(curr.left, currId*2 + 1));           
           }
           if(curr.right != null) {
               q.offer(new Pair(curr.right, currId*2 + 2));
           } 
        }   
        ans = Math.max(ans, (last-first+1));
       }
       return ans;
    }
}