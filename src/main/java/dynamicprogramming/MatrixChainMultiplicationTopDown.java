package dynamicprogramming;

import java.util.Arrays;

public class MatrixChainMultiplicationTopDown {

    public int minOperations(int[] a, int i, int j) {
        int N = a.length;
        int[][] cache = new int[N][N];
        for (int[] row : cache) {
            Arrays.fill(row, -1);
        }
        return minOperations(a, i, j, cache);
    }

    public int minOperations(int[] a, int i, int j, int[][] cache) {

        if (i >= j) {
            return 0;
        }

        if (cache[i][j] != -1) {
            return cache[i][j];
        }

        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int val = minOperations(a, i, k, cache) +
                    minOperations(a, k + 1, j, cache) +
                    a[i - 1] * a[k] * a[j];

            if (val < min) {
                min = val;
            }
        }
        return cache[i][j] = min;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 3};
        int arr2[] = {40, 20, 30, 10, 30};
        int arr3[] = {10, 20, 30, 40, 30};
        int arr4[] = {10, 20, 30};

        MatrixChainMultiplicationTopDown matrixChainMultiplicationTopDown = new MatrixChainMultiplicationTopDown();
        System.out.println("Minimum number of multiplications are " + matrixChainMultiplicationTopDown.minOperations(arr, 1, arr.length - 1));
        System.out.println("Minimum number of multiplications are " + matrixChainMultiplicationTopDown.minOperations(arr2, 1, arr2.length - 1));
        System.out.println("Minimum number of multiplications are " + matrixChainMultiplicationTopDown.minOperations(arr3, 1, arr3.length - 1));
        System.out.println("Minimum number of multiplications are " + matrixChainMultiplicationTopDown.minOperations(arr4, 1, arr4.length - 1));
    }
}
