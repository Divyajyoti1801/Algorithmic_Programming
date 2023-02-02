package ArrayQuestions;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String args[]) {
        int[] arr = new int[] { 1, 2, 3 };
        solution(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void solution(int arr[]) {
        int i, j;
        for (i = arr.length - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                break;
            }
        }
        if (i < 0) {
            reverse(arr, 0, arr.length - 1);
        } else {
            for (j = arr.length - 1; j >= 0; j++) {
                if (arr[j] > arr[i]) {
                    break;
                }
            }
            swap(arr, i, j);
            reverse(arr, i + 1, arr.length - 1);
        }
    }

    static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void reverse(int arr[], int i, int j) {
        while (i < j) {
            swap(arr, i++, j--);
        }
    }
}
