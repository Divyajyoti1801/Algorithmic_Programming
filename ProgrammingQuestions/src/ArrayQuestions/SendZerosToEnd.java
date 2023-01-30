package ArrayQuestions;

import java.util.Arrays;

public class SendZerosToEnd {
    public static void main(String args[]) {
        int arr[] = new int[] { 0, 1, 0, 3, 12 };
        solution(arr);
        System.out.println(Arrays.toString(arr));
    }

    // Know as Snowball Method
    static void solution(int[] arr) {
        int snowBallSize = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                snowBallSize++;
            } else if (snowBallSize > 0) {
                int t = arr[i]; // 3
                arr[i] = 0; // 0
                arr[i - snowBallSize] = t;
            }
        }
    }
}
