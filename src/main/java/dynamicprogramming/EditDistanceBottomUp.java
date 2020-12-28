package dynamicprogramming;

public class EditDistanceBottomUp {

    public int minEditDistance(String A, String B) {
        int M = A.length();
        int N = B.length();
        int[][] dp = new int[M + 1][N + 1];
        for (int i = 0; i <= M; i++) {
            for (int j = 0; j <= N; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j - 1], dp[i - 1][j])) + 1;
                }
            }
        }
        return dp[M][N];
    }

    public int minEditDistanceDPReconstruct(String A, String B) {
        int M = A.length();
        int N = B.length();
        int[][] dp = new int[M + 1][N + 1];
        for (int i = 0; i <= M; i++) {
            for (int j = 0; j <= N; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j - 1], dp[i - 1][j])) + 1;
                }
            }
        }
        return dp[M][N];
    }

    public static void main(String[] args) {
        EditDistanceBottomUp editDistanceBottomUp = new EditDistanceBottomUp();
        String A = "GOAT", B = "GET";
        System.out.println("Edit distance between " + A + "," + B + " is : " +
                editDistanceBottomUp.minEditDistance(A, B));
    }
}
