package dynamicprogramming;

public class BinomialCoefficientBottomUp {

    public int BCoefficient(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
            if (i <= k) {
                dp[i][i] = 1;
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }
        return dp[n][k];
    }

    public static void main(String[] args) {
        BinomialCoefficientBottomUp binomialCoefficientBottomUp = new BinomialCoefficientBottomUp();
        System.out.println(binomialCoefficientBottomUp.BCoefficient(6, 2));
    }
}
