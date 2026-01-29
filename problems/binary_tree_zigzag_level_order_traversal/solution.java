class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> qu = new LinkedList<TreeNode>();
        List<List<Integer>> wraplist = new LinkedList<List<Integer>>();
        if (root == null) return wraplist;

        qu.offer(root);
        int turn = 0;

        while(!qu.isEmpty()) {
            int size = qu.size();
            List<Integer> temp = new ArrayList<>();

            for(int i = 0; i < size; i++) {
                TreeNode it = qu.poll();

                if(turn == 0) {
                    temp.add(it.val);
                } else {
                    temp.add(0, it.val);
                }
                if(it.left != null) qu.offer(it.left);
                if(it.right != null) qu.offer(it.right);
            }

            wraplist.add(temp);
            turn = turn == 0 ? 1 : 0; 
        }
        return wraplist;
    }
}
