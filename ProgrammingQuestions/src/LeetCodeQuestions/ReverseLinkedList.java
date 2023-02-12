package LeetCodeQuestions;

public class ReverseLinkedList {
    static class ListNode {
        int val;
        ListNode link;

        ListNode(int val) {
            this.val = val;
            this.link = null;
        }
    }

    static ListNode head = null;

    static void insert(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
            return;
        }
        ListNode temp = head;
        while (temp.link != null) {
            temp = temp.link;
        }
        temp.link = newNode;
    }

    static void traversal() {
        if (head == null) {
            return;
        }
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.link;
        }
        System.out.println();
    }

    static ListNode reverse() {
        if (head == null) {
            return null;
        }

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while (curr != null) {
            next = curr.link;
            curr.link = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String args[]) {
        insert(1);
        insert(2);
        insert(3);
        insert(4);
        insert(5);
        traversal();
        head = reverse();
        traversal();
    }
}
