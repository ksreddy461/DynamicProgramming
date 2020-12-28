package dynamicprogramming;

public class RobTheHousesBottomUp {

    public int maxProfit(int[] a) {

        int n = a.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = a[0];
        for (int j = 2; j <= n; j++) {
            dp[j] = Math.max(a[j - 1] + dp[j - 2], dp[j - 1]);
        }
        return dp[n];
    }

    public int maxProfitDPReconstruct(int[] a) {
        int n = a.length;
        int[] dp = new int[n + 1];
        boolean[] rob = new boolean[n];
        rob[0] = true;
        dp[0] = 0;
        dp[1] = a[0];
        for (int j = 2; j <= n; j++) {
            if (a[j - 1] + dp[j - 2] > dp[j - 1]) {
                dp[j] = a[j - 1] + dp[j - 2];
                rob[j - 1] = true;
            } else {
                dp[j] = dp[j - 1];
                rob[j - 1] = false;
            }
        }

        int i = n - 1;
        while (i >= 0) {
            if (rob[i]) {
                System.out.println(i + " " + a[i]);
                i = i - 2;
            } else {
                i--;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        RobTheHousesBottomUp robTheHousesBottomUp = new RobTheHousesBottomUp();
        int a[] = {20, 25, 5, 15, 10};
        System.out.println("Max profit for Robbing: " + robTheHousesBottomUp.maxProfit(a));
        System.out.println("Max profit for Robbing: " + robTheHousesBottomUp.maxProfitDPReconstruct(a));
    }
}
