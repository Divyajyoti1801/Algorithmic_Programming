public class DiameterOfTree {
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

    static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        System.out.print(root.data + " ");
        postOrder(root.right);
    }

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        int h1 = height(root.left);
        int h2 = height(root.right);
        int result = Math.max(h1, h2) + 1;
        return result;
    }

    // Time Complexity : O(n^2)
    public static int diameter(Node root) {
        if (root == null) {
            return 0;
        }
        int d1 = diameter(root.left);
        int d2 = diameter(root.right);
        int diam = height(root.left) + height(root.right) + 1;
        return Math.max(d1, Math.max(d2, diam));
    }

    // Method Second for Optimizing Time Complexity: O(n)
    static class TreeDimeter {
        int ht;
        int diam;

        TreeDimeter(int ht, int diam) {
            this.ht = ht;
            this.diam = diam;
        }
    }

    static TreeDimeter diameterOPT(Node root) {
        if (root == null) {
            return new TreeDimeter(0, 0);
        }

        TreeDimeter left = diameterOPT(root.left);
        TreeDimeter right = diameterOPT(root.right);
        int treeHeight = Math.max(left.ht, right.ht) + 1;
        int diam1 = left.diam;
        int diam2 = right.diam;
        int diam3 = left.ht + right.ht + 1;
        int treeDiameter = Math.max(diam1, Math.max(diam2, diam3));
        TreeDimeter info = new TreeDimeter(treeHeight, treeDiameter);
        return info;
    }

    public static void main(String args[]) {
        int Nodes[] = new int[] { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.createTree(Nodes);
        System.out.println(root.data);
        postOrder(root);
        System.out.println();
        System.out.println("Diameter of Tree: " + diameter(root));
        System.out.println(diameterOPT(root).diam);

    }
}
