package ArrayQuestions;

import java.util.Arrays;

public class KthMaxMinInArray {
    public static void main(String args[]) {
        int arr[] = new int[] { 7, 10, 4, 3, 20, 15 };
        System.out.println("The Kth Smallest Element: " + KthMinElement(arr, 3));
        System.out.println("The Kth Largest Element: " + KthMaxElement(arr, 5));
    }

    static int KthMaxElement(int arr[], int k) {
        Arrays.sort(arr);
        return arr[arr.length - k - 1];
    }

    static int KthMinElement(int arr[], int k) {
        Arrays.sort(arr);
        return arr[k - 1];
    }
}
