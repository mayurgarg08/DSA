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
    class Pair {
        TreeNode node;
        int num;
        Pair(TreeNode node, int num) {
            this.node = node;
            this.num = num;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth = 0;
        Queue<Pair> q = new LinkedList<>();
        if(root == null) return maxWidth;
        q.offer(new Pair(root, 0));
        while(!q.isEmpty()) {
            int size = q.size();
            int first = 0;
            int last = 0;
            for(int i = 0; i < size; i++) {
                 Pair curr = q.peek();
                if(i == 0) first = curr.num;
                if(i == size-1) last = curr.num;
               
                int currId = curr.num;
                q.poll();
                if(curr.node.left != null) q.offer(new Pair(curr.node.left, 2*currId + 1));
                if(curr.node.right != null) q.offer(new Pair(curr.node.right, 2*currId + 2));
            }
            maxWidth = Math.max(maxWidth, last-first+1);
        }
        return maxWidth;
    }
}