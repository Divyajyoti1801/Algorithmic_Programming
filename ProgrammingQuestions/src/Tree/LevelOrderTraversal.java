package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
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

    static ArrayList<Integer> LevelOrder(Node node) {

        ArrayList<Integer> res = new ArrayList<>();
        if (node == null) {
            return res;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            Node currNode = q.remove();
            if (currNode != null) {
                res.add(currNode.data);
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
        return res;
    }

    public static void main(String args[]) {
    }
}
