class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        for (int i = 1; i < preorder.length; i++) {
            TreeNode node = new TreeNode(preorder[i]);
            TreeNode parent = null;

            while (!st.isEmpty() && node.val > st.peek().val) {
                parent = st.pop();
            }

            if (parent != null) {
                parent.right = node;  
            } else {
                st.peek().left = node;
            }

            st.push(node);
        }
        return root;
    }
}
