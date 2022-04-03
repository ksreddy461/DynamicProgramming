package sortingandsearching;

import java.util.Arrays;

public class ChocolateDistribution {

    public int solve(int[] a, int m) {

        int n = a.length;
        Arrays.sort(a);

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n - m + 1; i++) {

            int min = a[i];
            int max = a[i + m - 1];
            if (res > max - min) {
                res = max - min;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        ChocolateDistribution chocolateDistribution = new ChocolateDistribution();

        int[] a = {3, 4, 1, 9, 56, 7, 9, 12};
        System.out.println("Ans is: " + chocolateDistribution.solve(a, 5));

    }
}
