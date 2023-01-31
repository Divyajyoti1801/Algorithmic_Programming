package LinkedListQuestion;

public class ReverseLinkedListInAGroup {
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

    static Node solution(Node head, int k) {
        if (head == null) {
            return null;
        }
        Node prev = null;
        Node curr = head;
        Node next = null;
        int count = 0;
        while (curr != null && count < k) {
            next = curr.link;
            curr.link = prev;
            prev = curr;
            curr = next;
            count++;
        }
        if (next != null) {
            head.link = solution(next, k);
        }
        return prev;
    }

    public static void main(String args[]) {
        insert(1);
        insert(2);
        insert(2);
        insert(4);
        insert(5);
        insert(6);
        insert(7);
        insert(8);
        traverse(head);
        System.out.println("The Grouped Reverse of LL: ");
        head = solution(head, 4);
        traverse(head);
    }
}
