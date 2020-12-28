package dynamicprogramming;

public class LongestCommonSubsequenceBottomUp {

    public int lcs(String A, String B) {
        int M = A.length();
        int N = B.length();
        int[][] dp = new int[M + 1][N + 1];
        /* Base case initialization
         * here not required since array default value is '0'
         */
        for (int i = 0; i <= M; i++) {
            for (int j = 0; j <= N; j++) {
                if (i == 0 | j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[M][N];
    }

    public static void main(String[] args) {
        String A = "ACHEFMGLP";
        String B = "XCEPQMLG";
        LongestCommonSubsequenceBottomUp longestCommonSubsequenceBottomUp = new LongestCommonSubsequenceBottomUp();
        System.out.println("Longest Common Subsequence of " + A + "," + B + " is: " + longestCommonSubsequenceBottomUp.lcs(A, B));
    }
}
