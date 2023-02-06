package LinkedListQuestion;

class Node {
    int data;
    Node link;

    Node(int data) {
        this.data = data;
        this.link = null;
    }
}

public class AddTwoNumbers {

    static void insert(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        }
        Node temp = head;
        while (temp.link != null) {
            temp = temp.link;
        }
        temp = newNode;

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

    public static void main(String args[]) {
        Node head1 = new Node(4);
        Node head2 = new Node(3);

        insert(head1, 5);
        traverse(head1);
    }
}
