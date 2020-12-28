package dynamicprogramming;


public class KnapsackBottomup {

    public int knapsackDP(int[] weights, int[] values, int W) {
        int N = weights.length;
        int[][] dp = new int[W + 1][N + 1];
        for (int i = 0; i <= W; i++) {
            for (int j = 0; j <= N; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (weights[j - 1] <= i) {
                    dp[i][j] = Math.max(dp[i - weights[j - 1]][j - 1] + values[j - 1], dp[i][j - 1]);
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[W][N];
    }

    public static void main(String[] args) {
        KnapsackBottomup knapsack = new KnapsackBottomup();
        int[] w = {3, 7, 10, 6};
        int[] v = {4, 14, 10, 5};
        int W = 20;
        System.out.println("Solution is: " + knapsack.knapsackDP(w, v, W));
    }
}
