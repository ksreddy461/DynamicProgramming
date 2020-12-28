package backtracking;

public class MinimumCostPath {

    public int minCostPath(int[][] G, int row, int col) {

        if (row == 0 && col == 0) {
            return G[0][0];
        }
        int minimum = Integer.MAX_VALUE;
        if (row > 0) {
            minimum = Math.min(minimum, G[row][col] + minCostPath(G, row - 1, col));
        }
        if (col > 0) {
            minimum = Math.min(minimum, G[row][col] + minCostPath(G, row, col - 1));
        }
        return minimum;
    }

    public static void main(String[] args) {
        MinimumCostPath minimumCostPath = new MinimumCostPath();
        int[][] G = {{0, 47, 8, 18, 1}, {43, 25, 39, 36, 13}, {22, 8, 13, 38, 46}, {41, 41, 40, 25, 44}, {29, 43, 22, 50, 10}};
        System.out.println("Minimum cost path is:" + minimumCostPath.minCostPath(G, G.length - 1, G.length - 1));
    }
}
