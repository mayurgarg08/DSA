class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        if(root == null) return ans;
        int turn = 0;
        while(!que.isEmpty()) {
            int size = que.size();
            List<Integer> temp = new ArrayList<>();

            for(int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                if(turn == 0) temp.add(node.val);
                else temp.add(0, node.val);

                if(node.left != null) {
                    que.add(node.left);
                }
                if(node.right != null) {
                    que.add(node.right);
                }
            }
            ans.add(temp);
            turn = turn == 0 ? 1 : 0;
        }
        return ans;
    }
}
