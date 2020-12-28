package dynamicprogramming;

/*
Exchanging row & column
0-1 Knapsack Problem
value[] = {60, 100, 120}; weight[] = {10, 20, 30}; W = 50;
Solution: 220
 */
public class KnapsackBottomup2 {

    public int knapsackDP(int[] weights, int[] values, int W) {
        int N = weights.length;
        int[][] dp = new int[N + 1][W + 1];

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= W; j++) {
                if (weights[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j - weights[i - 1]] + values[i - 1], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[N][W];
    }

    public static void main(String[] args) {
        KnapsackBottomup2 knapsack = new KnapsackBottomup2();
        int[] w = {10, 20, 30};
        int[] v = {60, 100, 120};
        int W = 50;
        System.out.println("Solution is: " + knapsack.knapsackDP(w, v, W));
    }
}
