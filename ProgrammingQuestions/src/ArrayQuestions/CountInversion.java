package ArrayQuestions;

public class CountInversion {
    public static void main(String args[]) {
        long arr[] = new long[] { 2, 4, 1, 3, 5 };
        System.out.println("Number of Inversions : " + solution(arr, arr.length));
    }

    static long merge(long[] arr, int l, int m, int h) {
        long inv = 0;
        long left[] = new long[m - l + 1];
        long right[] = new long[h - m];

        for (int i = 0; i < left.length; i++) {
            left[i] = arr[l + i];
        }
        for (int i = 0; i < right.length; i++) {
            right[i] = arr[m + 1 + i];
        }

        int i = 0, j = 0, k = l;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
                inv += left.length - i;
            }
        }
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
        return inv;

    }

    static long mergeSort(long[] arr, int low, int high) {
        long inv = 0;
        if (low < high) {
            int mid = (low + high) / 2;
            inv += mergeSort(arr, low, mid);
            inv += mergeSort(arr, mid + 1, high);
            inv += merge(arr, low, mid, high);
        }
        return inv;
    }

    static long solution(long arr[], long N) {
        if (arr.length == 0 || arr == null || isSorted(arr)) {
            return 0;
        }
        int low = 0;
        int high = (int) (N - 1);
        return mergeSort(arr, low, high);
    }

    static boolean isSorted(long arr[]) {
        if (arr == null || arr.length == 0) {
            return false;
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                return false;
            }
        }
        return true;
    }
}
