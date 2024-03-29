package backtracking;


/*
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
public class CuttingRod {

    public int maxProfit(int[] p, int l) {

        if (l == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < l; i++) {
            max = Math.max(max, p[i] + maxProfit(p, l - (i + 1)));
        }
        return max;
    }

    public static void main(String[] args) {
        CuttingRod cuttingRod = new CuttingRod();
        int a[] = {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println("Max profit is: " + cuttingRod.maxProfit(a, 8));
    }
}
