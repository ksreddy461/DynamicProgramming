package backtracking;

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

public class CuttingRod2 {

    public int maxProfit(int[] a, int[] p, int L, int i) {
        if (L == 0 || i == 0) {
            return 0;
        }

        if (L >= a[i - 1]) {
            int include = p[i - 1] + maxProfit(a, p, L - a[i - 1], i);
            int exclude = maxProfit(a, p, L, i - 1);
            return Math.max(include, exclude);
        } else {
            return maxProfit(a, p, L, i - 1);
        }
    }

    public static void main(String[] args) {
        CuttingRod2 cuttingRod2 = new CuttingRod2();
        int a[] = {1, 2, 3, 4, 5, 6, 7, 8};
        int p[] = {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println("Max profit for cutting Rod is : " + cuttingRod2.maxProfit(a, p, 8, a.length));
    }
}
