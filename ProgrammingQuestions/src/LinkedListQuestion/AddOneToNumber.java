package LinkedListQuestion;

public class AddOneToNumber {
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
        int num = 0;
        while (temp != null) {
            num = num * 10 + (temp.data);
            temp = temp.link;
        }
        Node result = new Node(num + 1);
        return result;
    }

    public static void main(String args[]) {
        insert(4);
        insert(5);
        insert(6);
        traverse(head);
        head = solution(head);
        traverse(head);
    }
}
