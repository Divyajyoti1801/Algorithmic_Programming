public class CircularDoublyLinkedList {
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

    static void insertionCDLL(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
        }
        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
        head.prev = newNode;
    }

    static void insertionFirstCDLL(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
        }
        Node temp = head;
        newNode.prev = temp.prev;
        temp.prev = newNode;
        newNode.next = temp;
        head = newNode;
    }

    static void deletionCDLL() {
        if (head == null) {
            return;
        }
        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        temp.prev.next = head;
        temp.prev = null;
    }

    static void deletionFirstCDLL() {
        if (head == null) {
            return;
        }
        Node temp = head;
        head = head.next;

    }

    static void traverseCDLL() {
        if (head == null) {
            return;
        }
        Node temp = head;
        while (temp.next != head) {
            System.out.print(temp.data + " <=> ");
            temp = temp.next;
        }
        System.out.print(temp.data + " <=> ");
        System.out.println("START");
    }

    public static void main(String args[]) {

    }
}
