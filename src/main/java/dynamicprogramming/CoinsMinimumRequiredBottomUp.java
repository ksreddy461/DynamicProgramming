package dynamicprogramming;

public class CoinsMinimumRequiredBottomUp {

    public int minCoins(int[] a, int value) {
        int N = a.length;
        int[][] dp = new int[N + 1][value + 1];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= value; j++) {
                if (j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 1; j <= value; j++) {
                dp[i][j] = Integer.MAX_VALUE - 1;
                if (j >= a[i]) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - a[i]] + 1);
                }
            }
        }
        return dp[1][value];
    }

    public static void main(String[] args) {
        CoinsMinimumRequiredBottomUp coinsMinimumrequired = new CoinsMinimumRequiredBottomUp();
        int[] a = {25, 10, 5};
        int[] b = {9, 6, 5, 1};
        int[] c = {1, 2, 3, 4, 5};
        System.out.println(coinsMinimumrequired.minCoins(a, 30));
        System.out.println(coinsMinimumrequired.minCoins(b, 11));
        System.out.println(coinsMinimumrequired.minCoins(c, 11));
    }
}
