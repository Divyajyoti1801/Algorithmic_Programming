package Tree;

import java.util.Stack;

public class PreOrder {
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

    static void iterativePreOrder(Node root) {
        Stack<Node> s = new Stack<>();
        Node curr = root;
        while (!s.empty() || curr != null) {
            if (curr != null) {
                s.push(curr);
                curr = curr.left;
            } else {
                curr = s.pop();
                System.out.print(curr.data + " ");
                curr = curr.right;
            }
        }
        System.out.println();
    }

    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();
        int Nodes[] = new int[] { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        Node root = tree.createTree(Nodes);
        iterativePreOrder(root);
    }
}
