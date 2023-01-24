public class DoublyLinkedList {
    static class Node {
        Node prev;
        int data;
        Node next;

        Node(int data) {
            this.prev = null;
            this.data = data;
            this.next = null;
        }
    }

    static Node head = null;

    static void insertionDLL(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }

    static void insertionFrontDLL(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        temp.prev = newNode;
        head = newNode;
        head.next = temp;
    }

    static void deletionDLL() {
        if (head == null) {
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.prev.next = null;
    }

    static void deletionFirstDLL() {
        if (head == null) {
            return;
        }
        head = head.next;
        head.prev = null;
    }

    static void traverseDLL() {
        if (head == null) {
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <=> ");
            temp = temp.next;
        }
        System.out.println("Null");
    }

    public static void main(String args[]) {
        insertionDLL(1);
        insertionDLL(2);
        insertionDLL(3);
        insertionDLL(4);
        insertionDLL(5);
        insertionFrontDLL(10);
        deletionDLL();
        deletionFirstDLL();
        traverseDLL();
    }
}
