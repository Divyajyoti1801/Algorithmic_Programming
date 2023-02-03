package QueueCodes;

public class QueueWithArray {

    static class Queue {
        static int arr[];
        static int size;
        static int rear = -1;

        Queue(int size) {
            arr = new int[size];
            this.size = size;
        }

        static boolean isEmpty() {
            return rear == -1;
        }

        // Enqueue
        static void addElement(int data) {
            if (rear == size - 1) {
                System.out.println("Queue is full");
                return;
            }
            rear++;
            arr[rear] = data;
        }

        // Dequeue
        public static int removeElement() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            int front = arr[0];
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];
            }
            rear--;
            return front;
        }

        // Peek
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }

            return arr[0];
        }
    }

    public static void main(String args[]) {
        Queue q = new Queue(5);
        q.addElement(1);
        q.addElement(2);
        q.addElement(3);
        q.addElement(4);
        q.addElement(5);
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.removeElement();
        }
    }
}
