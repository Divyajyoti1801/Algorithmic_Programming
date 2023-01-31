import javax.xml.crypto.Data;

public class SumOfNodes {
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

        static Node buildTree(int Nodes[]) {
            idx++;
            if (Nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(Nodes[idx]);
            newNode.left = buildTree(Nodes);
            newNode.right = buildTree(Nodes);
            return newNode;
        }
    }

    static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    static int sumOfNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int leftNodes = sumOfNodes(root.left);
        int rightNodes = sumOfNodes(root.right);
        return leftNodes + rightNodes + root.data;
    }

    public static void main(String args[]) {
        int Nodes[] = new int[] { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(Nodes);
        System.out.println("Root Node Data: " + root.data);
        preOrder(root);
        System.out.println();
        System.out.println("Sum Of Nodes in BST: " + sumOfNodes(root));

    }
}
