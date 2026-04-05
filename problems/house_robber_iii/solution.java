class Solution {
    private Map<TreeNode, Integer> map = new HashMap<>();

    private int helper(TreeNode node) {
        if(node == null) return 0;

        if(map.containsKey(node)) return map.get(node);

        int take = node.val;
        if(node.left != null) {
            take += helper(node.left.left);
            take += helper(node.left.right);
        }
        if(node.right != null) {
            take += helper(node.right.left);
            take += helper(node.right.right);
        }

        int notTake = helper(node.left) + helper(node.right);

        int ans = Math.max(take, notTake);
        map.put(node, ans);

        return ans;
    }

    public int rob(TreeNode root) {
        return helper(root);
    }
}