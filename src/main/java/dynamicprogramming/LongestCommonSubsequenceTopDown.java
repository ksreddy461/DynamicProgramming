package dynamicprogramming;

import java.util.Arrays;

public class LongestCommonSubsequenceTopDown {

    public int lcs(int i, int j, String A, String B) {
        int[][] cache = new int[A.length()+1][B.length()+1];
        for (int[] row : cache) {
            Arrays.fill(row, -1);
        }
        return (lcs(i, j, A, B, cache));
    }

    public int lcs(int i, int j, String A, String B, int[][] cache) {
        if (i == 0 || j == 0) {
            return 0;
        }
        if (cache[i][j] != -1) {
            return cache[i][j];
        }

        if (A.charAt(i - 1) == B.charAt(j - 1)) {
            cache[i][j] = 1 + lcs(i - 1, j - 1, A, B, cache);
        } else {
            cache[i][j] = Math.max(lcs(i - 1, j, A, B, cache), lcs(i, j - 1, A, B, cache));
        }
        return cache[i][j];
    }

    public static void main(String[] args) {
        String A = "ACHEFMGLP";
        String B = "XCEPQMLG";
        LongestCommonSubsequenceTopDown longestCommonSubsequenceTopDown = new LongestCommonSubsequenceTopDown();
        System.out.println("Longest Common Subsequence of " + A + "," + B + " is: " + longestCommonSubsequenceTopDown.lcs(A.length(), B.length(), A, B));
    }
}
