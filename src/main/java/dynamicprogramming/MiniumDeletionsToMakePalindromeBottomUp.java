package dynamicprogramming;

public class MiniumDeletionsToMakePalindromeBottomUp {

    public int minDeletions(String S) {

        int N = S.length();
        int[][] dp = new int[N][N];
        for (int l = 1; l <= N; l++) {
            for (int i = 0; i <= N - l; i++) {
                int j = i + l - 1;
                if (i == j)
                    continue;
                if (S.charAt(i) == S.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i + 1][j]) + 1;
                }
            }
        }
        return dp[0][N - 1];
    }

    public static void main(String[] args) {

        MiniumDeletionsToMakePalindromeBottomUp miniumDeletionsToMakePalindromeBottomUp = new MiniumDeletionsToMakePalindromeBottomUp();
        String S = "KAZAYAKE";
        System.out.println("Minium Deletions to make " + S + " Palindrome is " +
                miniumDeletionsToMakePalindromeBottomUp.minDeletions(S));

    }

}
