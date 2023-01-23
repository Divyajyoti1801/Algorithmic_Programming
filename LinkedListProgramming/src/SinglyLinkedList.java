// Singly Linked-List
// Operations: Insertion, Deletion and Traversing

public class SinglyLinkedList {

    static class Node {
        int data;
        Node link;

        Node(int data) {
            this.data = data;
            this.link = null;
        }
    }

    static Node head = null;

    // Insertion at last
    static void insertElement(int data) {
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

    // Insertion at first
    static void insertElementAtFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        head = newNode;
        newNode.link = temp;
    }

    // Deletion at last
    static void deletionElement() {
        if (head == null) {
            return;
        }

        Node temp = head;
        Node prev = null;
        while (temp.link != null) {
            prev = temp;
            temp = temp.link;
        }
        prev.link = null; // Last element got deleted
    }

    // Deletion at First
    static void deletionFirst() {
        if (head == null) {
            return;
        }
        head = head.link;
    }

    // Searching of Element in Linked List: O(n)
    static boolean searchElement(int search) {
        if (head == null) {
            return false;
        }
        Node temp = head;
        while (temp != null) {
            if (temp.data == search) {
                return true;
            }
            temp = temp.link;
        }
        return false;
    }

    // Traversing the Linked List
    static void traverseList() {
        if (head == null) {
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.link;
        }
        System.out.println("null");
    }

    public static void main(String args[]) {
        insertElement(1);
        insertElement(2);
        insertElement(3);
        insertElement(4);
        insertElement(5);
        traverseList();
        insertElementAtFirst(10);
        traverseList();
        System.out.println(searchElement(3));
        deletionElement();
        traverseList();
        deletionFirst();
        traverseList();
    }
}
