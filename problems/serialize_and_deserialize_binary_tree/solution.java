/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        helper(root, list);
        String result = String.join(",", list);
        return result;
    }

    // Helper method for serialization (preorder traversal).
    public void helper(TreeNode node, List<String> list) {
        if (node == null) {
            list.add("X");  // Using "X" as the null marker
            return;
        }
        list.add(String.valueOf(node.val));  // Add current node's value
        helper(node.left, list);  // Recursively serialize left subtree
        helper(node.right, list);  // Recursively serialize right subtree
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        Queue<String> queue = new LinkedList<>(Arrays.asList(values));
        return helper2(queue);  // Start deserialization using a queue
    }

    // Helper method for deserialization using a queue of values.
    public TreeNode helper2(Queue<String> queue) {
        String value = queue.poll();  // Get the next value from the queue
        if (value.equals("X")) {
            return null;  // If the value is "X", it represents a null node
        }

        TreeNode node = new TreeNode(Integer.parseInt(value));  // Create a new node
        node.left = helper2(queue);  // Recursively construct the left subtree
        node.right = helper2(queue);  // Recursively construct the right subtree
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));