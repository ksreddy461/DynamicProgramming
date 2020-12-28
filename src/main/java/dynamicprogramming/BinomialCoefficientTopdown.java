package dynamicprogramming;

public class BinomialCoefficientTopdown {

    public int BCoefficient(int n, int k) {

        int[][] dp = new int[n+1][k+1];
        return BCoefficientUtil(n, k, dp);
    }

    public int BCoefficientUtil(int n, int k, int[][] dp) {
        if (n == k || k == 0) {
            return 1;
        }
        if (dp[n][k] != 0) {
            return dp[n][k];
        }
        dp[n][k] = BCoefficientUtil(n - 1, k - 1, dp) + BCoefficientUtil(n - 1, k, dp);
        return dp[n][k];
    }

    public static void main(String[] args) {
        BinomialCoefficientTopdown binomialCoefficientTopdown = new BinomialCoefficientTopdown();
        System.out.println(binomialCoefficientTopdown.BCoefficient(6, 2));
    }
}
