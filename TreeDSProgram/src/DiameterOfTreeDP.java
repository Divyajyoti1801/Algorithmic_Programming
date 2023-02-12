public class DiameterOfTreeDP {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int idx = -1;

        static Node createTree(int Nodes[]) {
            idx++;
            if (Nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(Nodes[idx]);
            newNode.left = createTree(Nodes);
            newNode.right = createTree(Nodes);
            return newNode;
        }
    }

    static int diameter(Node root) {
        if (root == null) {
            return 0;
        }
        int[] d = new int[1];
        height(root, d);
        return d[0];
    }

    static int height(Node root, int d[]) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left, d);
        int right = height(root.right, d);
        d[0] = Math.max(d[0], left + right);
        return Math.max(left, right) + 1;
    }

    public static void main(String args[]) {
        int Nodes[] = new int[] { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.createTree(Nodes);
        System.out.println(root.data);
        System.out.println();
        System.out.println("Diameter of the tree: " + diameter(root));
    }
}
