package ArrayQuestions;

public class FindDuplicateInArray {
    public static void main(String args[]) {
        int arr[] = new int[] { 1, 3, 4, 2, 2 };
        System.out.println("Duplicate in Array: " + solution(arr));
    }

    // Use of Binary Searching:
    // Pigeonhole Principle: if n+1 integers are placed in an array of length n, at
    // least 1 integer will be repeated.
    static int solution(int[] arr) {
        int len = arr.length;
        int low = 0;
        int high = len - 1;
        while (low < high) {
            int mid = (low + (high - low)) / 2;
            int cnt = 0;
            for (int i = 0; i < len; i++) {
                if (arr[i] <= mid) {
                    cnt++;
                }
            }
            if (cnt <= mid) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
