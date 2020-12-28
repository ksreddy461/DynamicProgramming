package dynamicprogramming;

/*
Following unbounded knapsack approach
Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n.
Determine the maximum value obtainable by cutting up the rod and selling the pieces.
For example, if length of the rod is 8 and the values of different pieces are given as following,
then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)

length   | 1   2   3   4   5   6   7   8
--------------------------------------------
price    | 1   5   8   9  10  17  17  20
And if the prices are as following, then the maximum obtainable value is 24 (by cutting in eight pieces of length 1)

length   | 1   2   3   4   5   6   7   8
--------------------------------------------
price    | 3   5   8   9  10  17  17  20

Lenght = 8
 */

import java.util.Arrays;

public class CuttingRod2TopDown {

    public int maxProfit(int[] a, int[] p, int L, int pos) {
        int[][] cache = new int[pos + 1][L + 1];
        for (int[] row : cache) {
            Arrays.fill(row, -1);
        }
        return maxProfit(a, p, L, pos, cache);
    }

    public int maxProfit(int[] a, int[] p, int L, int i, int[][] cache) {
        if (L == 0 || i == 0) {
            return 0;
        }

        if (cache[i][L] != -1) {
            return cache[i][L];
        }
        if (L >= a[i - 1]) {
            int include = p[i - 1] + maxProfit(a, p, L - a[i - 1], i, cache);
            int exclude = maxProfit(a, p, L, i - 1, cache);
            return cache[i][L] = Math.max(include, exclude);
        } else {
            return cache[i][L] = maxProfit(a, p, L, i - 1, cache);
        }
    }

    public static void main(String[] args) {
        CuttingRod2TopDown cuttingRod2TopDown = new CuttingRod2TopDown();
        int a[] = {1, 2, 3, 4, 5, 6, 7, 8};
        int p[] = {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println("Max profit is: " + cuttingRod2TopDown.maxProfit(a, p, 8, a.length));
    }
}
