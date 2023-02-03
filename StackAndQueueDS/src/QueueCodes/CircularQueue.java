package QueueCodes;

public class CircularQueue {
    static class CQueue {
        static int arr[];
        static int size;
        static int front = -1;
        static int rear = -1;

        CQueue(int size) {
            arr = new int[size];
            this.size = size;
        }

        static boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        static boolean isFull() {
            return (rear + 1) % size == front;
        }

        static void addElement(int data) {
            if (isFull()) {
                System.out.println("Queue is Full");
                return;
            }
            // 1st element is added
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        static int removeElement() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            int result = arr[front];
            // Single Element Condition
            if (rear == front) {
                rear = front = -1;
            } else {
                front = (front + 1) % size;
            }
            return result;
        }

        static int peek() {
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }
            return arr[front];
        }
    }

    public static void main(String args[]) {
        CQueue c = new CQueue(5);
        c.addElement(1);
        c.addElement(2);
        c.addElement(3);
        c.addElement(4);
        c.addElement(5);
        System.out.println(c.removeElement());
        c.addElement(6);
        System.out.println(c.removeElement());
        c.addElement(7);
        while (!c.isEmpty()) {
            System.out.println(c.peek());
            c.removeElement();
        }
    }
}
