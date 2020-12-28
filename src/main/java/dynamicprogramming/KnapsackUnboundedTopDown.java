package dynamicprogramming;

import java.util.Arrays;

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
public class KnapsackUnboundedTopDown {

    public int maxProfit(int[] weights, int[] values, int W, int pos) {
        int[][] cache = new int[pos + 1][W + 1];
        for (int[] row : cache) {
            Arrays.fill(row, -1);
        }
        return maxProfit(weights, values, W, pos, cache);
    }

    private int maxProfit(int[] weights, int[] values, int W, int pos, int[][] cache) {
        if (W == 0 || pos == 0) {
            return 0;
        }

        if (cache[pos][W] != -1) {
            return cache[pos][W];
        }
        if (W >= weights[pos - 1]) {
            int include = values[pos - 1] + maxProfit(weights, values, W - weights[pos - 1], pos, cache);
            int exclude = maxProfit(weights, values, W, pos - 1, cache);
            return cache[pos][W] = Math.max(include, exclude);
        } else {
            return cache[pos][W] = maxProfit(weights, values, W, pos - 1, cache);
        }
    }

    public static void main(String[] args) {
        KnapsackUnboundedTopDown knapsackUnboundedTopDown = new KnapsackUnboundedTopDown();
        int[] w = {1, 3, 4, 5};
        int[] v = {10, 40, 50, 70};
        int W = 8;
        System.out.println("Solution is: " + knapsackUnboundedTopDown.maxProfit(w, v, W, w.length));
    }
}