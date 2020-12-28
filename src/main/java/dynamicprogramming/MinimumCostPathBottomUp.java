package dynamicprogramming;

import java.util.Arrays;

public class MinimumCostPathBottomUp {

    public int minCostPathDPReconstruct(int[][] G) {
        int N = G.length;
        int[][] dp = new int[N][N];
        int[][] path = new int[N][N];
        for (int[] r : path) {
            Arrays.fill(r, -1);
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == 0 && j == 0)
                    continue;
                int minimum = Integer.MAX_VALUE;
                if (i > 0) {
                    minimum = Math.min(minimum, G[i][j] + dp[i - 1][j]);
                    path[i][j] = 0;// came from Left
                }
                if (j > 0) {
                    minimum = Math.min(minimum, G[i][j] + dp[i][j - 1]);
                    path[i][j] = 1;// came from Top
                }
                dp[i][j] = minimum;
            }
        }

        int i = N - 1, j = N - 1;
        while (i >= 0 && j >= 0) {
            int pos = path[i][j];
            System.out.println(i + "," + j);
            if (pos == 1) {
                j--;
            } else {
                i--;
            }
        }

        return dp[N - 1][N - 1];
    }


    public int minCostPath(int[][] G) {
        int N = G.length;
        int[][] dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == 0 && j == 0)
                    continue;
                int minimum = Integer.MAX_VALUE;
                if (i > 0) {
                    minimum = Math.min(minimum, G[i][j] + dp[i - 1][j]);
                }
                if (j > 0) {
                    minimum = Math.min(minimum, G[i][j] + dp[i][j - 1]);
                }
                /* if (i > 0 && j > 0) {
                    minimum = Math.min(minimum, G[i][j] + dp[i - 1][j - 1]);
                }*/ /* diagonally */
                dp[i][j] = minimum;
            }
        }
        return dp[N - 1][N - 1];
    }

    public static void main(String[] args) {
        MinimumCostPathBottomUp minimumCostPathBottomUp = new MinimumCostPathBottomUp();
        int[][] G = {{0, 47, 8, 18, 1}, {43, 25, 39, 36, 13}, {22, 8, 13, 38, 46}, {41, 41, 40, 25, 44}, {29, 43, 22, 50, 10}};
        System.out.println("Minimum cost path is:" + minimumCostPathBottomUp.minCostPath(G));
        System.out.println("Minimum cost path is:" + minimumCostPathBottomUp.minCostPathDPReconstruct(G));
    }
}
