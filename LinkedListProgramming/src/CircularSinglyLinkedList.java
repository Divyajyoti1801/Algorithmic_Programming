public class CircularSinglyLinkedList {
    static class Node {
        int data;
        Node link;

        Node(int data) {
            this.data = data;
            this.link = null;
        }

    }

    static Node head = null;

    // At last
    static void insertionCLL(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.link = head;
            return;
        }
        Node temp = head;
        while (temp.link != head) {
            temp = temp.link;
        }
        temp.link = newNode;
        newNode.link = head;
    }

    // At Last
    static void deletionCLL() {
        if (head == null) {
            return;
        }
        Node temp = head;
        Node prev = null;
        while (temp.link != head) {
            prev = temp;
            temp = temp.link;
        }
        prev.link = head;
        temp.link = null;
    }

    // At first Deletion
    static void deletionFirstCLL() {
        if (head == null) {
            return;
        }
        Node temp = head;
        head = head.link;
        temp.link = null;
        Node temp2 = head;
        while (temp2.link != temp) {
            temp2 = temp2.link;
        }
        temp2.link = head;
    }

    // Traverse Circular Linked list
    static void traverseCLL() {
        if (head == null) {
            return;
        }
        Node temp = head;
        while (temp.link != head) {
            System.out.print(temp.data + " -> ");
            temp = temp.link;
        }
        System.out.print(temp.data + " -> ");
        System.out.println("start");
    }

    public static void main(String args[]) {
        insertionCLL(1);
        insertionCLL(2);
        insertionCLL(3);
        insertionCLL(4);
        insertionCLL(5);
        deletionFirstCLL();
        deletionCLL();
        traverseCLL();
    }
}
