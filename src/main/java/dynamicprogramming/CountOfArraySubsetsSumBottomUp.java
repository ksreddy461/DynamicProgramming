package dynamicprogramming;

/*
Given an array arr[] of length N and an integer X, the task is to find the number of subsets with sum equal to X.

Examples:

Input: arr[] = {1, 2, 3, 3}, X = 6
Output: 3
All the possible subsets are {1, 2, 3},
{1, 2, 3} and {3, 3}

Input: arr[] = {1, 1, 1, 1}, X = 1
Output: 4
 */
public class CountOfArraySubsetsSumBottomUp {

    public int subSetsSum(int[] a, int sum) {
        int N = a.length;
        int[][] dp = new int[N + 1][sum + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else if (j == 0) {
                    dp[i][j] = 1;
                } else if (i == 0) {
                    dp[i][j] = 0;
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j >= a[i - 1]) {
                    dp[i][j] = dp[i - 1][j - a[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[N][sum];
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 3};
        CountOfArraySubsetsSumBottomUp aountOfArraySubsetsSumBottomUp = new CountOfArraySubsetsSumBottomUp();
        System.out.print(aountOfArraySubsetsSumBottomUp.subSetsSum(a, 6));
    }
}
