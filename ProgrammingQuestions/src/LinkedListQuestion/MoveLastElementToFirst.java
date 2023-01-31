package LinkedListQuestion;

public class MoveLastElementToFirst {
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

    static Node solution(Node head) {
        if (head == null) {
            return null;
        }
        Node temp = head;
        Node prev = null;
        while (temp.link != null) {
            prev = temp;
            temp = temp.link;
        }
        Node tail = temp;
        prev.link = null;
        tail.link = head;
        head = tail;
        return head;
    }

    public static void main(String args[]) {
        insert(1);
        insert(2);
        insert(3);
        insert(4);
        insert(5);
        traverse(head);
        head = solution(head);
        traverse(head);
    }
}
