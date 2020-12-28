package backtracking;

/*
Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins,
how many ways can we make the change? The order of coins doesn’t matter.
For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}.
So output should be 4. For N = 10 and S = {2, 5, 3, 6},
there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}.
So the output should be 5.
 */
public class CoinsMaximumNumberWays {

    public int count(int[] coins, int sum, int i) {

        if (sum == 0) {
            return 1;
        }

        if (i == 0) {
            return 0;
        }

        if (sum >= coins[i - 1]) {
            int include = count(coins, sum - coins[i - 1], i);
            int exclude = count(coins, sum, i - 1);
            return include + exclude;
        } else {
            return count(coins, sum, i - 1);
        }
    }

    public static void main(String[] args) {
        CoinsMaximumNumberWays coinsMaximumNumberWays = new CoinsMaximumNumberWays();
        int[] a = {2, 5, 3, 6};
        System.out.println(coinsMaximumNumberWays.count(a, 10, a.length));
    }
}
