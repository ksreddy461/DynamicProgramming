package dynamicprogramming;

import java.util.Arrays;

/*
0-1 Knapsack Problem
value[] = {60, 100, 120}; weight[] = {10, 20, 30}; W = 50;
Solution: 220


 */
public class KnapsackTopdown {

    public int solveKnapsack(int[] w, int[] v, int W, int i) {

        int[][] cache = new int[W + 1][w.length + 1];
        for (int row[] : cache) {
            Arrays.fill(row, -1);
        }
        return solveKnapsackHelper(w, v, cache, W, i);
    }

    private int solveKnapsackHelper(int[] w, int[] v, int[][] cache, int W, int i) {
        if (W == 0 || i == 0) {
            return 0;
        }

        if (cache[W][i] != -1) {
            return cache[W][i];
        }

        if (w[i - 1] <= W) {
            int include = v[i - 1] + solveKnapsackHelper(w, v, cache, W - w[i - 1], i - 1);
            int exclude = solveKnapsackHelper(w, v, cache, W, i - 1);
            cache[W][i] = Math.max(include, exclude);
            return cache[W][i];
        } else {
            return (cache[W][i] = solveKnapsackHelper(w, v, cache, W, i - 1));
        }
    }

    public static void main(String[] args) {
        KnapsackTopdown knapsack = new KnapsackTopdown();
        int[] w = {10, 20, 30};
        int[] v = {60, 100, 120};
        int W = 50;
        System.out.println("Solution is: " + knapsack.solveKnapsack(w, v, W, w.length));
    }
}
