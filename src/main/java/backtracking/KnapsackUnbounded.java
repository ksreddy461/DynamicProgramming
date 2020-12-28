package backtracking;

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
public class KnapsackUnbounded {

    public int maxProfit(int[] weights, int[] values, int W, int pos) {
        if (W == 0 || pos == 0) {
            return 0;
        }

        if (W >= weights[pos - 1]) {
            int include = values[pos - 1] + maxProfit(weights, values, W - weights[pos - 1], pos);
            int exclude = maxProfit(weights, values, W, pos - 1);
            return Math.max(include, exclude);
        } else {
            return maxProfit(weights, values, W, pos - 1);
        }
    }

    public static void main(String[] args) {
        KnapsackUnbounded knapsackUnbounded = new KnapsackUnbounded();
        int[] w = {1, 3, 4, 5};
        int[] v = {10, 40, 50, 70};
        int W = 8;
        System.out.println("Solution is: " + knapsackUnbounded.maxProfit(w, v, W, w.length));
    }
}
