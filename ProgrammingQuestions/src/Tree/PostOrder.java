package Tree;

import java.util.Stack;

public class PostOrder {
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

    static void iterativePostOrder(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> s = new Stack<>();
        s.push(root);
        while (!s.empty()) {
            Node curr = s.pop();
            System.out.print(curr.data + " ");
            if (curr.right != null) {
                s.push(curr.right);
            }
            if (curr.left != null) {
                s.push(curr.left);
            }
        }
        System.out.println();
    }

    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();
        int Nodes[] = new int[] { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        Node root = tree.createTree(Nodes);
        iterativePostOrder(root);
    }
}
