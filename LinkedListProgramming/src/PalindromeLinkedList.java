public class PalindromeLinkedList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
            // Empty Constructor
        }

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
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
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    static void traverse(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " => ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    static ListNode reverseLinkedList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    static int LLtonum(ListNode head) {
        if (head == null) {
            return -1;
        }
        ListNode temp = head;
        int num = 0;
        while (temp != null) {
            num = num * 10 + (temp.val);
            temp = temp.next;
        }
        return num;
    }

    public static void main(String args[]) {
        insert(1);
        insert(2);
        insert(2);
        insert(1);
        traverse(head);
        int num = LLtonum(head);
        System.out.println(num);
        ListNode rev = reverseLinkedList(head);
        int copy = LLtonum(rev);
        System.out.println(copy);
    }
}
