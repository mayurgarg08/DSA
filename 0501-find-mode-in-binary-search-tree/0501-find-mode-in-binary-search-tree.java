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
    List<Integer> result = new ArrayList<>();

    int prev;
    int count = 0;
    int maxCount = 0;
    boolean first = true;

    public int[] findMode(TreeNode root) {
        inorder(root);

        int[] ans = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            ans[i] = result.get(i);
        }

        return ans;
    }

    private void inorder(TreeNode node){
        if(node == null) return;

        inorder(node.left);

        if(first){
            prev = node.val;
            count = 1;
            first = false;
        } 
        else if(node.val == prev){
            count++;
        } 
        else{
            prev = node.val;
            count = 1;
        }

        if(count > maxCount){
            maxCount = count;
            result.clear();
            result.add(node.val);
        }
        else if(count == maxCount){
            result.add(node.val);
        }

        inorder(node.right);
    }
}