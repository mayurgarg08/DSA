class Solution {
    private void mark_parent(TreeNode root, Map<TreeNode, TreeNode> parent_track) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode current = q.poll();
            if(current.left != null) {
                parent_track.put(current.left, current);
                q.offer(current.left);
            }
            if(current.right != null) {
                parent_track.put(current.right, current);
                q.offer(current.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parent_track = new HashMap<>();
        mark_parent(root, parent_track);
        Queue<TreeNode> q = new LinkedList<>();
        Map<TreeNode, Boolean> visited = new HashMap<>();
        q.offer(target);
        visited.put(target, true);
        int curr_level = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            if(curr_level == k) break;
            curr_level++;

            for(int i = 0; i < size; i++) {
                TreeNode current = q.poll();
                if(current.left != null && visited.get(current.left) == null) {
                    q.offer(current.left);
                    visited.put(current.left, true);
                }
                if(current.right != null && visited.get(current.right) == null) {
                    q.offer(current.right);
                    visited.put(current.right, true);
                }
                TreeNode parent = parent_track.get(current);
                if(parent != null && visited.get(parent) == null) {
                    q.offer(parent);
                    visited.put(parent, true);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()) {
            ans.add(q.poll().val);
        }
        return ans;
     }
}
