package ArrayQuestions;

public class SortingArray012 {
    public static void main(String args[]) {
        int arr[] = new int[] { 0, 2, 1, 2, 0 };
        System.out.println("Optimal Solution:");
        OptimalSolution(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // This solution using time Complexity O(3n) and Space Complexity of O(n)
    static int[] SolutionBruteForce(int arr[]) {
        int[] result = new int[arr.length];
        int start = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                result[start] = arr[i];
                start++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                result[start] = arr[i];
                start++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2) {
                result[start] = arr[i];
                start++;
            }
        }
        return result;
    }

    // If I have to Optimize no auxiliary space can be used
    static void swap(int a, int b, int arr[]) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static void OptimalSolution(int arr[]) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[mid] == 0) {
                swap(low, mid, arr);
                mid++;
                low++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                swap(mid, high, arr);
                high--;
            }
        }
    }

}
