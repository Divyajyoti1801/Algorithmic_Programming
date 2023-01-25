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
    static Node tail = null;

    static void insertCDLL(int data) {
        // From Last element Insertion
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }
        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        newNode.next = head; // temp.next=head;
        temp.next = newNode;
        newNode.prev = temp;
        head.prev = newNode;
        tail = newNode;
    }

    static void insertFirstCDLL(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
        }
        newNode.next = head;
        newNode.prev = head.prev;
        head.prev = newNode;
        head = newNode;
        newNode.prev.next = newNode;
    }

    static void deleteCDLL() {
        if (head == null) {
            return;
        }
        Node temp = head;
        Node delNode = temp.prev;
        delNode.prev.next = temp;
        temp.prev = delNode.prev;
        delNode.prev = null;
        delNode.next = null;
        tail = head.prev;
    }

    static void deleteFirstCDLL() {
        if (head == null) {
            return;
        }
        Node temp = head;
        temp.next.prev = temp.prev;
        temp.prev = null;
        head = temp.next;
        temp.next = null;
        head.prev.next = head;
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

    static void reverseTraversalDLL() {
        if (head == null) {
            return;
        }
        Node temp = tail;
        while (temp.prev != tail) {
            System.out.print(temp.data + " <=> ");
            temp = temp.prev;
        }
        System.out.print(temp.data + " <=> ");
        System.out.println("HEAD");
    }

    public static void main(String args[]) {
        insertCDLL(1);
        insertCDLL(2);
        insertCDLL(3);
        insertCDLL(4);
        insertCDLL(5);
        insertFirstCDLL(10);
        deleteCDLL();
        deleteFirstCDLL();
        traverseCDLL();
        reverseTraversalDLL();
    }
}
