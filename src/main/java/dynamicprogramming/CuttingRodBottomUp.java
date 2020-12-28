package dynamicprogramming;

public class CuttingRodBottomUp {

    public int maxProfit(int[] p, int L) {
        int[] dp = new int[L + 1];
        for (int l = 1; l <= L; l++) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < l; i++) {
                max = Math.max(max, p[i] + dp[l - i - 1]);
            }
            dp[l] = max;
        }
        return dp[L];
    }

    public int maxProfitDPConstruct(int[] p, int L) {
        int[] dp = new int[L + 1];
        int[] cuts = new int[L + 1];
        for (int l = 1; l <= L; l++) {
            dp[l] = Integer.MIN_VALUE;
            int cut = -1;
            for (int i = 0; i < l; i++) {
                if (p[i] + dp[l - i - 1] > dp[l]) {
                    dp[l] = p[i] + dp[l - i - 1];
                    cut = i + 1;
                }
            }
            cuts[l] = cut;
        }

        int l = L;
        int cut = cuts[L];
        while (cut != 0) {
            System.out.println((cut) + " ");
            l = l - cut;
            cut = cuts[l];
        }
        System.out.println("");
        return dp[L];
    }

    public static void main(String[] args) {
        CuttingRodBottomUp cuttingRodBottomUp = new CuttingRodBottomUp();
        int a[] = {1, 5, 8, 9, 10, 14, 17, 20, 24, 30};
        System.out.println("Max profit for Robbing: " + cuttingRodBottomUp.maxProfit(a, 8));
        System.out.println("Max profit for Robbing: " + cuttingRodBottomUp.maxProfitDPConstruct(a, 8));
    }
}
