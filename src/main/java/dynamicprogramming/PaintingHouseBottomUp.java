package dynamicprogramming;

import static java.lang.Math.min;

public class PaintingHouseBottomUp {

    private static final int RED = 0;
    private static final int BLUE = 1;
    private static final int GREEN = 2;

    public int minCost(int[][] cost) {

        int[][] dp = new int[cost.length + 1][3];
        int n = cost.length;
        if (n == 0) {
            return 0;
        }

        for (int i = 1; i <= n; i++) {

            dp[i][RED] = cost[i - 1][RED] + min(dp[i - 1][BLUE], dp[i - 1][GREEN]);
            dp[i][BLUE] = cost[i - 1][BLUE] + min(dp[i - 1][GREEN], dp[i - 1][RED]);
            dp[i][GREEN] = cost[i - 1][GREEN] + min(dp[i - 1][BLUE], dp[i - 1][RED]);
        }
        return (min(dp[n][RED], min(dp[n][BLUE], dp[n][GREEN])));
    }

    public int minCostDPReconstruct(int[][] cost) {
        int[][] dp = new int[cost.length + 1][3];
        int[][] decisionPath = new int[cost.length + 1][3];
        int n = cost.length;
        if (n == 0) {
            return 0;
        }

        for (int i = 1; i <= n; i++) {

            //RED
            if (dp[i - 1][BLUE] < dp[i - 1][GREEN]) {
                decisionPath[i][RED] = BLUE;
                dp[i][RED] = cost[i - 1][RED] + dp[i - 1][BLUE];
            } else {
                decisionPath[i][RED] = GREEN;
                dp[i][RED] = cost[i - 1][RED] + dp[i - 1][GREEN];
            }


            //BLUE
            if (dp[i - 1][RED] < dp[i - 1][GREEN]) {
                decisionPath[i][BLUE] = RED;
                dp[i][BLUE] = cost[i - 1][BLUE] + dp[i - 1][RED];
            } else {
                decisionPath[i][BLUE] = GREEN;
                dp[i][BLUE] = cost[i - 1][BLUE] + dp[i - 1][GREEN];
            }

            //GREEN
            if (dp[i - 1][RED] < dp[i - 1][BLUE]) {
                decisionPath[i][GREEN] = RED;
                dp[i][GREEN] = cost[i - 1][GREEN] + dp[i - 1][RED];
            } else {
                decisionPath[i][GREEN] = BLUE;
                dp[i][GREEN] = cost[i - 1][GREEN] + dp[i - 1][BLUE];
            }
        }
        int ret = min(dp[n][RED], min(dp[n][BLUE], dp[n][GREEN]));

        int color = 0;
        if (ret == dp[n][RED]) {
            color = RED;
        } else if (ret == dp[n][BLUE]) {
            color = BLUE;
        } else {
            color = GREEN;
        }
        int i = n;
        do {
            System.out.println("House " + (i - 1) + ", Paint " + decisionPath[i][color] + " , Cost " + cost[i - 1][color]);
            color = decisionPath[i][color];
            i--;
        } while (i > 0);
        return ret;
    }

    public static void main(String[] args) {
        PaintingHouseBottomUp paintingHouseBottomUp = new PaintingHouseBottomUp();
        int[][] cost = {{17, 2, 17}, {16, 16, 5}, {14, 3, 9}};
        System.out.println(paintingHouseBottomUp.minCost(cost));
        System.out.println(paintingHouseBottomUp.minCostDPReconstruct(cost));
    }
}
