package LinkedListQuestion;

import java.util.LinkedHashSet;

public class RemoveDuplicateUnsorted {
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
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        Node temp = head;
        while (temp != null) {
            set.add(temp.data);
            temp = temp.link;
        }
        Node x = new Node(-1);
        Node p = x;
        for (Integer y : set) {
            x.link = new Node(y);
            x = x.link;
        }
        return p.link;
    }

    public static void main(String args[]) {
        insert(5);
        insert(2);
        insert(2);
        insert(4);
        traverse(head);
        head = solution(head);
        traverse(head);
    }
}
