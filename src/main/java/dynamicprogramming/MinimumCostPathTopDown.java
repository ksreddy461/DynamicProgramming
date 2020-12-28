package dynamicprogramming;

import java.util.Arrays;

public class MinimumCostPathTopDown {

    public int minCostPath(int[][] G, int row, int col) {
        int[][] cache = new int[G.length][G.length];
        for (int[] r : cache) {
            Arrays.fill(r, -1);
        }
        return minCostPath(G, row, col, cache);
    }

    public int minCostPath(int[][] G, int row, int col, int[][] cache) {

        if (row == 0 && col == 0) {
            return G[0][0];
        }

        if (cache[row][col] != -1) {
            return cache[row][col];
        }
        int minimum = Integer.MAX_VALUE;
        if (row > 0) {
            minimum = Math.min(minimum, G[row][col] + minCostPath(G, row - 1, col, cache));
        }
        if (col > 0) {
            minimum = Math.min(minimum, G[row][col] + minCostPath(G, row, col - 1, cache));
        }
        cache[row][col] = minimum;
        return minimum;
    }

    public static void main(String[] args) {
        MinimumCostPathTopDown minimumCostPathTopDown = new MinimumCostPathTopDown();
        int[][] G = {{0, 47, 8, 18, 1}, {43, 25, 39, 36, 13}, {22, 8, 13, 38, 46}, {41, 41, 40, 25, 44}, {29, 43, 22, 50, 10}};
        System.out.println("Minimum cost path is:" + minimumCostPathTopDown.minCostPath(G, G.length - 1, G.length - 1));
    }
}
