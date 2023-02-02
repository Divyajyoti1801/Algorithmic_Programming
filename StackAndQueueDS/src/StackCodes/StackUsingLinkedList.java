package StackCodes;

public class StackUsingLinkedList {
    static class Node {
        int data;
        Node link;

        public Node(int data) {
            this.data = data;
            this.link = null;
        }
    }

    static class Stack {
        public static Node head;

        public static boolean isEmpty() {
            return head == null;
        }

        // Push Operation
        public static void push(int data) {
            Node newNode = new Node(data);
            if (isEmpty()) {
                head = newNode;
            }
            newNode.link = head;
            head = newNode;
        }

        // Pop Operation
        public static int pop() {
            if (isEmpty()) {
                return -1;
            }
            int top = head.data;
            Node temp = head;
            head = head.link;
            temp.link = null;
            return top;
        }

        // Peek Operation
        public static int peek() {
            if (isEmpty()) {
                return -1;
            }
            return head.data;
        }
    }

    public static void main(String args[]) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        System.out.println("Data Present in the Stack: ");
        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}
