package ArrayQuestions;

import java.util.Arrays;

public class CyclicallyRotateAnArrayByOne {
    public static void main(String args[]) {
        int arr[] = new int[] { 1, 2, 3, 4, 5 };
        solution(arr);
        System.out.println(Arrays.toString(arr));

    }

    static void solution(int arr[]) {
        int temp = arr[arr.length - 1];
        for (int i = arr.length - 1; i >= 1; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = temp;
    }
}
