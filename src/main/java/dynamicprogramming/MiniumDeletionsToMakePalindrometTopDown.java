package dynamicprogramming;

import java.util.Arrays;

public class MiniumDeletionsToMakePalindrometTopDown {

    public int minDeletions(int i, int j, String S) {
        int N = S.length();
        int[][] cache = new int[N][N];
        for (int[] row : cache) {
            Arrays.fill(row, -1);
        }
        return minDeletions(i, j, S, cache);
    }

    public int minDeletions(int i, int j, String S, int[][] cache) {
        if (i >= j) {
            return 0;
        }

        if (cache[i][j] != -1) {
            return cache[i][j];
        }
        if (S.charAt(i) == S.charAt(j)) {
            cache[i][j] = minDeletions(i + 1, j - 1, S, cache);
        } else {
            cache[i][j] = Math.min(minDeletions(i + 1, j, S, cache), minDeletions(i, j - 1, S, cache)) + 1;
        }
        return cache[i][j];
    }

    public static void main(String[] args) {

        MiniumDeletionsToMakePalindrometTopDown miniumDeletionsToMakePalindrometTopDown = new MiniumDeletionsToMakePalindrometTopDown();
        String S = "KAZAYAKE";
        System.out.println("Minium Deletions to make " + S + " Palindrome is " +
                miniumDeletionsToMakePalindrometTopDown.minDeletions(0, S.length() - 1, S));

    }
}
