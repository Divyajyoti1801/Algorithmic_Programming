import java.lang.Thread.State;
import java.util.*;

public class IterativeInOrderTraversal {
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

    static class BinarySearchTree {
        public static int idx = -1;

        public static Node createTree(int Nodes[]) {
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

    static List<Integer> iterativeInorder(Node root) {
        List<Integer> data = new ArrayList<>();
        if (root == null) {
            return data;
        }
        Stack<Node> s = new Stack<>();
        while (root != null || !s.isEmpty()) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            data.add(root.data);
            root = root.right;
        }
        return data;
    }

    // Some important Question related to Iterative inorder traversal

    // Question 1: Kth Smallest Element in BST

    static int KthSmallestElement(Node root, int k) {
        if (root == null) {
            return -1;
        }
        Stack<Node> s = new Stack<>();
        while (root != null || !s.isEmpty()) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            if (--k == 0) {
                break;
            }
            root = root.right;
        }
        return root.data;
    }

    // Question 2: Validate Binary Search Tree
    static boolean isValidBST(Node root) {
        if (root == null) {
            return true;
        }
        Stack<Node> s = new Stack<>();
        Node pre = null;
        while (root != null || !s.isEmpty()) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            if (pre != null && root.data <= pre.data) {
                return false;
            }
            pre = root;
            root = root.right;
        }
        return true;
    }

    public static void main(String args[]) {
        int[] Nodes = new int[] { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinarySearchTree tree = new BinarySearchTree();
        Node root = tree.createTree(Nodes);
        System.out.println("Root Confirmation: " + root.data);
        List<Integer> result = iterativeInorder(root);
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("3rd Smallest element in BST: " + KthSmallestElement(root, 2));
        System.out.println("Is it a valid Binary Search Tree: " + isValidBST(root));
    }
}
