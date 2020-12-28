package dynamicprogramming;

public class CuttingRodTopDown {

    public int maxProfit(int[] p, int l) {

        int n = p.length;
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = -1;
        }
        return maxProfitUtil(p, l, dp);
    }

    private int maxProfitUtil(int[] p, int l, int[] dp) {
        if (l == 0) {
            return 0;
        }

        if (dp[l] != -1) {
            return dp[l];
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < l; i++) {
            max = Math.max(max, p[i] + maxProfitUtil(p, l - (i + 1), dp));
        }
        dp[l] = max;
        return dp[l];
    }

    public static void main(String[] args) {
        CuttingRodTopDown cuttingRodTopDown = new CuttingRodTopDown();
        int a[] = {1, 5, 8, 9, 10, 14, 17, 20, 24, 30};
        System.out.println("Max profit for Robbing: " + cuttingRodTopDown.maxProfit(a, 8));
    }
}
