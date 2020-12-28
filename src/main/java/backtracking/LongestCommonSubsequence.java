package backtracking;

public class LongestCommonSubsequence {

    public int lcs(int i, int j, String A, String B) {
        if (i == 0 || j == 0) {
            return 0;
        }
        if (A.charAt(i - 1) == B.charAt(j - 1)) {
            return (1 + lcs(i - 1, j - 1, A, B));
        } else {
            return (Math.max(lcs(i - 1, j, A, B), lcs(i, j - 1, A, B)));
        }
    }

    public static void main(String[] args) {
        String A = "ACHEFMGLP";
        String B = "XYCEPQMLG";
        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        System.out.println("Longest Common Subsequence of " + A + "," + B + " is: " + longestCommonSubsequence.lcs(A.length(), B.length(), A, B));
    }
}
