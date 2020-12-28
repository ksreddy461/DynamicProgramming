package dynamicprogramming;

import java.util.Arrays;

/*
Given a value V, if we want to make change for V cents, and we have infinite supply of each of C = { C1, C2, .. , Cm} valued coins, what is the minimum number of coins to make the change?
Examples:

Input: coins[] = {25, 10, 5}, V = 30
Output: Minimum 2 coins required
We can use one coin of 25 cents and one of 5 cents

Input: coins[] = {9, 6, 5, 1}, V = 11
Output: Minimum 2 coins required
We can use one coin of 6 cents and 1 coin of 5 cents

Input: coins[] = {1,2,3,4,5}, V = 11
Output: Minimum 3 coins required
We can use one coin of 2 cents, one coin of 4 cents  and one coin of 5 cents

 */
public class CoinsMinimumRequiredTopDown {

    public int minCoins(int[] a, int value, int pos) {
        int[][] cache = new int[pos + 1][value + 1];
        for (int[] row : cache) {
            Arrays.fill(row, -1);
        }
        return minCoins(a, value, pos, cache);
    }

    public int minCoins(int[] a, int value, int pos, int[][] cache) {
        if (value == 0) {
            return 0;
        }
        if (cache[pos][value] != -1) {
            return cache[pos][value];
        }

        int res = Integer.MAX_VALUE - 1;
        for (int i = 0; i < pos; i++) {
            if (value >= a[i]) {
                int subRes = 1 + minCoins(a, value - a[i], pos, cache);
                if (subRes < res) {
                    res = subRes;
                }
            }
        }
        return cache[pos][value] = res;
    }

    public static void main(String[] args) {
        CoinsMinimumRequiredTopDown coinsMinimumrequired = new CoinsMinimumRequiredTopDown();
        int[] a = {25, 10, 5};
        int[] b = {9, 6, 5, 1};
        int[] c = {1, 2, 3, 4, 5};
        System.out.println(coinsMinimumrequired.minCoins(a, 30, a.length));
        System.out.println(coinsMinimumrequired.minCoins(b, 11, b.length));
        System.out.println(coinsMinimumrequired.minCoins(c, 11, c.length));
    }
}
