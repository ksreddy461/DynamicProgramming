package dynamicprogramming;

/*
Given a set of integers, the task is to divide it into two sets S1 and S2 such that the absolute difference between their sums is minimum.
If there is a set S with n elements, then if we assume Subset1 has m elements, Subset2 must have n-m elements and the value of abs(sum(Subset1) – sum(Subset2)) should be minimum.
Example:

Input:  arr[] = {1, 6, 11, 5}
Output: 1
Explanation:
Subset1 = {1, 5, 6}, sum of Subset1 = 12
Subset2 = {11}, sum of Subset2 = 11
 */
public class MinimumSubsetSumDiference {

    public static int miniumDiff(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        boolean dp[][] = subSetsSum(a, sum);
        int b[] = new int[sum + 1];
        int j = 0;
        for (int i = 0; i <= sum / 2; i++) {
            if (dp[a.length][i]) {
                b[j++] = i;
            }
        }

        int minimum = Integer.MAX_VALUE;
        for (int i = 0; i < j; i++) {
            minimum = Math.min(minimum, sum - 2 * b[i]);
        }
        return minimum;
    }

    public static boolean[][] subSetsSum(int[] a, int sum) {
        int N = a.length;
        boolean[][] dp = new boolean[N + 1][sum + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = false;
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j >= a[i - 1]) {
                    dp[i][j] = dp[i - 1][j - a[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        int[] a = {1, 6, 11, 5};
        MinimumSubsetSumDiference minimumSubsetSumDiference = new MinimumSubsetSumDiference();
        System.out.println("Minimum subset sum difference is: " + minimumSubsetSumDiference.miniumDiff(a));
    }
}
