package ArrayQuestions;

import java.util.*;

public class MergeIntervals {
    public static void main(String args[]) {
        int[][] arr = new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        int[][] res = solution(arr);
        for (int i[] : res) {
            System.out.println("{" + i[0] + "," + i[1] + "}");
        }
    }

    static int[][] solution(int arr[][]) {
        List<int[]> res = new ArrayList<>();
        if (arr.length == 0 || arr == null) {
            return res.toArray(new int[0][]);
        }
        // For Sorting
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        int start = arr[0][0];
        int end = arr[0][1];
        for (int i[] : arr) {
            if (i[0] <= end) {
                end = Math.max(end, i[1]);
            } else {
                res.add(new int[] { start, end });
                start = i[0];
                end = i[1];
            }
        }
        res.add(new int[] { start, end });
        return res.toArray(new int[0][1]);
    }
}
