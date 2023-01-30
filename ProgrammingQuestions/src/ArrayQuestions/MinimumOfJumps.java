package ArrayQuestions;

public class MinimumOfJumps {
    public static void main(String args[]) {
        int[] arr = new int[] { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
        System.out.println("Minimum number of Jumps: " + solution(arr, arr.length));
    }

    static int solution(int arr[], int n) {
        int res = 0, curr = 0, temp = 0;
        for (int i = 0; i < n - 1; i++) {
            temp = Math.max(temp, arr[i] + i);
            if (i == curr) {
                res++;
                curr = temp;
            }
        }
        if (curr < n - 1) {
            return -1;
        }
        return res;
    }
}

// if(call>=res||i>=n)return;if(i+arr[i]>=n-1){res=min(call,res);
// // cout << res << " ";
// return;}for(

// int j = 1;j<=arr[i];j++){
// jumps(arr, n, i+j, call+1, res);
// }