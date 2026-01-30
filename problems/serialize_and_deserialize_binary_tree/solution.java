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
        if (root == null) return "";

    Queue<TreeNode> q = new LinkedList<>();
    StringBuilder res = new StringBuilder();

    q.offer(root);

    while (!q.isEmpty()) {
        TreeNode node = q.poll();

        if (node == null) {
            res.append("null,");
            continue;
        }

        res.append(node.val).append(",");
        q.offer(node.left);
        q.offer(node.right);
    }

    return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
         if (data.equals("")) return null;

    String[] values = data.split(",");
    TreeNode root = new TreeNode(Integer.parseInt(values[0]));

    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);

    int i = 1;
    while (!q.isEmpty() && i < values.length) {
        TreeNode parent = q.poll();

        // left
        if (!values[i].equals("null")) {
            parent.left = new TreeNode(Integer.parseInt(values[i]));
            q.offer(parent.left);
        }
        i++;

        // right
        if (i < values.length && !values[i].equals("null")) {
            parent.right = new TreeNode(Integer.parseInt(values[i]));
            q.offer(parent.right);
        }
        i++;
    }

    return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));