package dynamicprogramming;

public class SubsetsSumBottomUp {

    public boolean subSetsSum(int[] a, int sum) {
        int N = a.length;
        boolean[][] dp = new boolean[N + 1][sum + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = false;
                } else if (j == 0) {
                    dp[i][j] = true;
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

        return dp[N][sum];
    }

    public static void main(String[] args) {
        int[] a = {10, 1, 2, 7, 6, 1, 5, 1};
        int[] b = {3, 34, 4, 12, 5, 2};
        SubsetsSumBottomUp subsetsSumBottomUp = new SubsetsSumBottomUp();
        System.out.println(subsetsSumBottomUp.subSetsSum(a, 20));
        System.out.println(subsetsSumBottomUp.subSetsSum(b, 9));
        System.out.println(subsetsSumBottomUp.subSetsSum(b, 30));
    }
}
