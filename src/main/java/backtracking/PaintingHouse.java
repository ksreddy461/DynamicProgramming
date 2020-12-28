package backtracking;

import static java.lang.Math.min;

public class PaintingHouse {

    private static final int RED = 0;
    private static final int BLUE = 1;
    private static final int GREEN = 2;

    public int minCost(int[][] cost) {

        int redCost = minCost(cost, 0, RED);
        int blueCost = minCost(cost, 0, BLUE);
        int greenCost = minCost(cost, 0, GREEN);
        return (min(redCost, min(blueCost, greenCost)));
    }

    private int minCost(int[][] cost, int i, int color) {

        if (cost.length == i) {
            return 0;
        }

        switch (color) {

            case RED: {
                int blueCost = minCost(cost, i + 1, BLUE);
                int greenCost = minCost(cost, i + 1, GREEN);
                return cost[i][RED] + min(blueCost, greenCost);
            }

            case BLUE: {
                int redCost = minCost(cost, i + 1, RED);
                int greenCost = minCost(cost, i + 1, GREEN);
                return cost[i][BLUE] + min(redCost, greenCost);
            }

            case GREEN: {
                int blueCost = minCost(cost, i + 1, BLUE);
                int redCost = minCost(cost, i + 1, RED);
                return cost[i][GREEN] + min(blueCost, redCost);
            }
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        PaintingHouse paintingHouse = new PaintingHouse();
        int[][] cost = {{17, 2, 17}, {16, 16, 5}, {14, 3, 9}};
        System.out.println(paintingHouse.minCost(cost));
    }
}
