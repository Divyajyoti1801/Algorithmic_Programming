public class GeneralizeLinkedList {

    static class Node {
        int data;
        Node link;

        Node(int data) {
            this.data = data;
            this.link = null;
        }
    }

    static class LinkedList {
        static Node head;

        static Node insertElement(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                return head;
            }
            Node temp = head;
            while (temp.link != null) {
                temp = temp.link;
            }
            temp.link = newNode;
            return head;
        }
    }

    static void traverse(Node head) {
        if (head == null) {
            System.out.println("Linked List is Empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " => ");
            temp = temp.link;
        }
        System.out.println("NULL");
    }

    public static void main(String args[]) {
        LinkedList ll = new LinkedList();
        Node head = ll.insertElement(1);
        head = ll.insertElement(2);
        head = ll.insertElement(3);
        head = ll.insertElement(4);
        traverse(head);

        LinkedList ll2 = new LinkedList();
        Node head2 = ll2.insertElement(2);
        head2 = ll2.insertElement(3);
        head2 = ll2.insertElement(4);
        head2 = ll2.insertElement(5);
        traverse(head2);

    }
}
