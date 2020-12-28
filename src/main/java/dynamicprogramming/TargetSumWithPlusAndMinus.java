package dynamicprogramming;

/*
Suppose we have a list of non-negative integers, a1, a2, ..., an, and another value, that is target, S.
Now we have 2 symbols + and -. For each integer, we should choose one from + and - as its new symbol.
we have to find out how many ways to assign symbols to make sum of integers same as the target value S.
So if the numbers are [1,1,1,1,1], and S = 3, then the output will be 5, as the combinations are – 1 + 1 + 1 + 1 + 1 = 3, + 1 – 1 + 1 + 1 + 1 = 3, + 1 + 1 – 1 + 1 + 1 = 3, + 1 + 1 + 1 – 1 + 1 = 3, + 1 + 1 + 1 + 1 – 1 = 3.
So there are five ways to assign them.
 */

public class TargetSumWithPlusAndMinus {

    public int targetSum(int[] a, int sum) {
        int N = a.length;
        int arrasySum = 0;
        for (int i = 0; i < N; i++) {
            arrasySum += a[i];
        }
        return subSetsSum(a, (arrasySum + sum) / 2);
    }

    public int subSetsSum(int[] a, int sum) {
        int N = a.length;
        int[][] dp = new int[N + 1][sum + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else if (j == 0) {
                    dp[i][j] = 1;
                } else if (i == 0) {
                    dp[i][j] = 0;
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j >= a[i - 1]) {
                    dp[i][j] = dp[i - 1][j - a[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[N][sum];
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 1, 1, 1};
        TargetSumWithPlusAndMinus targetSumWithPlusAndMinus = new TargetSumWithPlusAndMinus();
        System.out.print(targetSumWithPlusAndMinus.targetSum(a, 3));
    }
}
