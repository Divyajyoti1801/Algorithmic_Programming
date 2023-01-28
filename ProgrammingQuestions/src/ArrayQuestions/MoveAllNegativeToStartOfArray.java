package ArrayQuestions;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MoveAllNegativeToStartOfArray {
    public static void main(String args[]) {
        int arr[] = new int[] { -12, 11, -13, -5, 6, -7, 5, -3, -6 };
        System.out.println("Moving All Negative Element To One Side: ");
        solution(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void solution(int arr[]) {
        Arrays.sort(arr);
    }

}
