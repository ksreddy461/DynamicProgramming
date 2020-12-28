package dynamicprogramming;

/*
Input : W = 100
       val[]  = {1, 30}
       wt[] = {1, 50}
Output : 100
There are many ways to fill knapsack.
1) 2 instances of 50 unit weight item.
2) 100 instances of 1 unit weight item.
3) 1 instance of 50 unit weight item and 50
   instances of 1 unit weight items.
We get maximum value with option 2.

Input : W = 8
       val[] = {10, 40, 50, 70}
       wt[]  = {1, 3, 4, 5}
Output : 110
We get maximum value with one unit of
weight 5 and one unit of weight 3.
 */
public class KnapsackUnboundedBottomUp {

    public int maxProfit(int[] weights, int[] values, int W) {
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
                if (j >= weights[i - 1]) {
                    dp[i][j] = Math.max(dp[i][j - weights[i - 1]] + values[i - 1], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[N][W];
    }

    public static void main(String[] args) {
        KnapsackUnboundedBottomUp knapsackUnboundedBottomUp = new KnapsackUnboundedBottomUp();
        int[] w = {1, 3, 4, 5};
        int[] v = {10, 40, 50, 70};
        int W = 8;
        System.out.println("Solution is: " + knapsackUnboundedBottomUp.maxProfit(w, v, W));
    }
}
