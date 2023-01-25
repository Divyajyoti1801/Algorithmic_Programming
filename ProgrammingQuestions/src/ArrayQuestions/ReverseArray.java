package ArrayQuestions;

public class ReverseArray {

    static void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        if (arr.length == 0) {
            return;
        }
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

    }

    // static void swapElement(int a, int b) {
    // int temp = a;
    // a = b;
    // b = temp;
    // }

    public static void main(String args[]) {
        int[] arr = new int[] { 1, 2, 3, 4, 5 };
        reverseArray(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

// Time Complexity: O(n)
// Space Complexity : O(1)