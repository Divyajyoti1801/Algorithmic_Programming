package ArrayQuestions;

public class MaxContiguousArraySum {
    public static void main(String args[]) {
        int arr[] = new int[] { 1, 2, 3, -2, 5 };
        System.out.println("Solution: " + solution(arr));
    }

    // Practically using Kadanes Algorithm
    public static long solution(int arr[]) {
        long max_so_far = Integer.MIN_VALUE;
        long max_ending_here = 0;
        for (int i = 0; i < arr.length; i++) {
            max_ending_here += arr[i];
            if (max_so_far < max_ending_here) {
                max_so_far = max_ending_here;
            }
            if (max_ending_here < 0) {
                max_ending_here = 0;
            }
        }
        return max_so_far;
    }
}
