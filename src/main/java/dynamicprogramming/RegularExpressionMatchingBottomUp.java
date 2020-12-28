package dynamicprogramming;

public class RegularExpressionMatchingBottomUp {

    public boolean matches(String S, String R) {
        int M = S.length();
        int N = R.length();
        boolean[][] dp = new boolean[M + 1][N + 1];
        dp[0][0] = true;
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (S.charAt(i - 1) == R.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (R.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (R.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }
        return dp[M][N];
    }

    public static void main(String[] args) {
        RegularExpressionMatchingBottomUp regularExpressionMatchingBottomUp = new RegularExpressionMatchingBottomUp();
        String S = "GREATS", R = "G*T*";
        System.out.println("Regular Expression " + R + " is matches with String " + S + " " +
                regularExpressionMatchingBottomUp.matches(S, R));
    }
}
