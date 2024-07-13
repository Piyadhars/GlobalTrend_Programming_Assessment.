import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Main {
    public String serialize(TreeNode root) {
        if (root == null) return "X,";

        return root.val + "," + serialize(root.left) + serialize(root.right);
    }
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeHelper(queue);
    }

    private TreeNode deserializeHelper(Queue<String> queue) {
        String val = queue.poll();
        if (val.equals("X")) return null;

        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = deserializeHelper(queue);
        node.right = deserializeHelper(queue);

        return node;
    }

    public static void main(String[] args) {
        Main codec = new Main();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        String serializedTree = codec.serialize(root);
        System.out.println("Serialized Tree: " + serializedTree);

        TreeNode deserializedRoot = codec.deserialize(serializedTree);

        System.out.println("Deserialized Tree:");
        printTree(deserializedRoot);
    }

    public static void printTree(TreeNode node) {
        if (node == null) return;

        System.out.print(node.val + " ");
        printTree(node.left);
        printTree(node.right);
    }
}
