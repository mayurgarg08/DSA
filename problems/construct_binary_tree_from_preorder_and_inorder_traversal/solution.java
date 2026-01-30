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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> mpp = new HashMap<>();
        for(int i = 0; i< inorder.length; i++) {
            mpp.put(inorder[i], i);
        }

        TreeNode root = build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, mpp);
        return root;
    }
    private TreeNode build(int[] preOrder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> mpp) {
        if(preStart > preEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preOrder[preStart]);

        int inRoot = mpp.get(root.val);
        int numsLeft = inRoot -inStart;

        root.left = build(preOrder, preStart+1, preStart+numsLeft, inorder, inStart, inRoot-1, mpp);
        root.right = build(preOrder, preStart+numsLeft+1, preEnd, inorder, inRoot+1, inEnd, mpp);

        return root;
    }
}