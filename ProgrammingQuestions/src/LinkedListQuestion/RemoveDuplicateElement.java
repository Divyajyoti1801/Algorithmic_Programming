package LinkedListQuestion;

public class RemoveDuplicateElement {
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

    static void solution(Node head) {
        if (head == null) {
            return;
        }
        Node temp = head;
        while (temp.link != null) {
            Node next = temp.link;
            if (temp.data == next.data) {
                temp.link = next.link;
                next.link = null;
            }
            temp = temp.link;
        }
    }

    public static void main(String args[]) {
        insert(2);
        insert(2);
        insert(4);
        insert(5);
        traverse(head);
        solution(head);
        traverse(head);
    }
}
