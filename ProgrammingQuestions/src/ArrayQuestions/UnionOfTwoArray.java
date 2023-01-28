package ArrayQuestions;

import java.util.*;

public class UnionOfTwoArray {
    public static void main(String args[]) {
        int[] a = new int[] { 85, 25, 1, 32, 54, 6 };
        int[] b = new int[] { 85, 2 };
        System.out.println("The Size of the Union set: " + solution(a, b));

    }

    static int solution(int a[], int[] b) {
        HashSet<Integer> set = new HashSet<>();
        Arrays.sort(a);
        Arrays.sort(b);
        for (int i : a) {
            set.add(i);
        }
        for (int j : b) {
            set.add(j);
        }
        return set.size();
    }
}
