package ArrayQuestions;

import java.util.Arrays;

public class MinimizeTheHeight {
    public static void main(String args[]) {
        int arr[] = new int[] { 3, 9, 12, 16, 20 };
        System.out.println("The minimum Possible height b/w longest and Smallest: " + solution(arr, arr.length, 3));
    }

    static int solution(int arr[], int n, int k) {
        if (n == 1) {
            return 0;
        }
        Arrays.sort(arr);
        int ans = arr[n - 1] + arr[0];
        int min, max;
        for (int i = 1; i < n; i++) {
            if (arr[i] - k < 0) {
                continue;
            }
            max = Math.max(arr[i - 1] + k, arr[n - 1] - k);
            min = Math.min(arr[i] - k, arr[0] + k);
            ans = Math.min(max, min);
        }
        return ans;
    }
}

// int getMinDiff(int[] arr, int n, int k) {
// if (n == 1) {
// return 0;
// }
// Arrays.sort(arr);
// int ans = arr[n - 1] - arr[0];
// int min, max;
// for (int i = 1; i < n; i++) {
// if (arr[i] - k < 0) {
// continue;
// }
// max = Math.max(arr[i - 1] + k, arr[n - 1] - k);
// min = Math.min(arr[i] - k, arr[0] + k);
// ans = Math.min(ans, max - min);
// }
// return ans;
// }