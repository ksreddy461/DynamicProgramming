package dynamicprogramming;


public class MatrixChainMultiplicationBottomUp {

    public int minOperations(int[] a) {

        int N = a.length;
        int[][] dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i >= j) {
                    dp[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < N; i++) {
            for (int j = N - 1; j >= 0; j--) {
                if(i<j){
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        int val = dp[i][k] + dp[k + 1][j] + a[i - 1] * a[k] * a[j];

                        if (val < dp[i][j]) {
                            dp[i][j] = val;
                        }
                    }
                }
            }
        }
        return dp[1][N - 1];
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 3};
        int arr2[] = {40, 20, 30, 10, 30};
        int arr3[] = {10, 20, 30, 40, 30};
        int arr4[] = {10, 20, 30};

        MatrixChainMultiplicationBottomUp matrixChainMultiplicationBottomUp = new MatrixChainMultiplicationBottomUp();
        System.out.println("Minimum number of multiplications are " + matrixChainMultiplicationBottomUp.minOperations(arr));
        System.out.println("Minimum number of multiplications are " + matrixChainMultiplicationBottomUp.minOperations(arr2));
        System.out.println("Minimum number of multiplications are " + matrixChainMultiplicationBottomUp.minOperations(arr3));
        System.out.println("Minimum number of multiplications are " + matrixChainMultiplicationBottomUp.minOperations(arr4));
    }
}
