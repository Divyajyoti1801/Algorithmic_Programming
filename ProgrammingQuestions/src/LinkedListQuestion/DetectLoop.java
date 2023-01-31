package LinkedListQuestion;

public class DetectLoop {
    static class Node {
        int data;
        Node link;

        Node(int data) {
            this.data = data;
            this.link = null;
        }
    }

    static Node head = null;

    static void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.link != null) {
            temp = temp.link;
        }
        temp.link = newNode;
    }

    static void traverse(Node head) {
        if (head == null) {
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " => ");
            temp = temp.link;
        }
        System.out.println("NULL");
    }

    static boolean solution(Node head) {
        Node slow = head;
        Node fast = head.link;
        while (slow != null) {
            if (fast == null || fast.link == null) {
                return false;
            }
            slow = slow.link;
            fast = fast.link.link;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        insert(1);
        insert(3);
        insert(4);
        traverse(head);
        System.out.println("Is there a loop: " + solution(head));
    }
}
