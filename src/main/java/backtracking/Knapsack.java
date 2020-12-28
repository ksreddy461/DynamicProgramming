package backtracking;


public class Knapsack {

    public int solveKnapsack(int[] w, int[] v, int W, int i) {

        if (W == 0 || i == 0) {
            return 0;
        }
        if (w[i - 1] <= W) {
            int include = v[i - 1] + solveKnapsack(w, v, W - w[i - 1], i - 1);
            int exclude = solveKnapsack(w, v, W, i - 1);
            return (Math.max(include, exclude));
        } else {
            return (solveKnapsack(w, v, W, i - 1));
        }
    }

    public static void main(String[] args) {
        Knapsack knapsack = new Knapsack();
        int[] w = {3, 7, 10, 6};
        int[] v = {4, 14, 10, 5};
        int W = 20;
        System.out.println("Solution is: " + knapsack.solveKnapsack(w, v, W, w.length));
    }
}
