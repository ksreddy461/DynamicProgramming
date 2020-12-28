package dynamicprogramming;

import static java.lang.Math.min;

public class PaintingHouseTopDown {


    private static final int RED = 0;
    private static final int BLUE = 1;
    private static final int GREEN = 2;

    public int minCost(int[][] cost) {

        int[][] dp = new int[cost.length][3];
        for (int i = 0; i < cost.length; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = -1;
            }
        }
        int redCost = minCost(cost, 0, RED, dp);
        int blueCost = minCost(cost, 0, BLUE, dp);
        int greenCost = minCost(cost, 0, GREEN, dp);
        return (min(redCost, min(blueCost, greenCost)));
    }

    private int minCost(int[][] cost, int i, int color, int[][] dp) {

        if (cost.length == i) {
            return 0;
        }

        if (dp[i][color] != -1) {
            return dp[i][color];
        }
        switch (color) {

            case RED: {
                int blueCost = minCost(cost, i + 1, BLUE, dp);
                int greenCost = minCost(cost, i + 1, GREEN, dp);
                return dp[i][color] = cost[i][RED] + min(blueCost, greenCost);
            }

            case BLUE: {
                int redCost = minCost(cost, i + 1, RED, dp);
                int greenCost = minCost(cost, i + 1, GREEN, dp);
                return dp[i][color] = cost[i][BLUE] + min(redCost, greenCost);
            }

            case GREEN: {
                int blueCost = minCost(cost, i + 1, BLUE, dp);
                int redCost = minCost(cost, i + 1, RED, dp);
                return dp[i][color] = cost[i][GREEN] + min(blueCost, redCost);
            }
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        PaintingHouseTopDown paintingHouseTopDown = new PaintingHouseTopDown();
        int[][] cost = {{17, 2, 17}, {16, 16, 5}, {14, 3, 9}};
        System.out.println(paintingHouseTopDown.minCost(cost));
    }
}
