package ArrayQuestions;

import java.util.Arrays;

public class MaxMinOfArray {
    public static void main(String args[]) {
        int[] arr = new int[] { 2, 4, 5, 3, 67 };
        Arrays.sort(arr);
        System.out.println("Max Element: " + arr[arr.length - 1]);
        System.out.println("Min Element: " + arr[0]);
    }
}
