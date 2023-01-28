package LinkedListQuestion;

public class ReverseTheLinkedList {
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

    static void traverse() {
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

    static void reverse() {
        if (head == null || head.link == null) {
            return;
        }
        Node current = head;
        Node prev = null;
        Node next = null;
        while (current != null) {
            next = current.link;
            current.link = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public static void main(String args[]) {
        insert(1);
        insert(2);
        insert(3);
        insert(4);
        insert(5);
        traverse();
        reverse();
        traverse();
    }
}
