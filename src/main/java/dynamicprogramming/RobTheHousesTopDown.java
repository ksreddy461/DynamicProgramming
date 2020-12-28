package dynamicprogramming;

public class RobTheHousesTopDown {
    public int maxProfit(int[] a, int i) {
        int[] dp = new int[a.length];
        for (int j = 0; j < dp.length; j++) {
            dp[j] = -1;
        }
        int maxProfit = maxProfitUtil(a, i, dp);
        return maxProfit;
    }

    public int maxProfitUtil(int[] a, int i, int[] dp) {
        if (i < 0) {
            return 0;
        }
        if (i == 0) {
            return a[0];
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int include = a[i] + maxProfitUtil(a, i - 2,dp);
        int exclude = maxProfitUtil(a, i - 1,dp);
        dp[i] = Math.max(include, exclude);
        return dp[i];
    }

    public static void main(String[] args) {
        RobTheHousesTopDown robTheHousesTopDown = new RobTheHousesTopDown();
        int a[] = {20, 25, 30, 15, 10};
        System.out.println("Max profit for Robbing: " + robTheHousesTopDown.maxProfit(a, a.length - 1));
    }
}
