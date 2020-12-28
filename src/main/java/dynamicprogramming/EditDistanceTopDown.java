package dynamicprogramming;

import java.util.Arrays;

public class EditDistanceTopDown {

    public int minEditDistance(int i, int j, String A, String B) {
        int[][] cache = new int[A.length()][B.length()];
        for (int[] row : cache) {
            Arrays.fill(row, -1);
        }
        return minEditDistance(i, j, A, B, cache);
    }

    public int minEditDistance(int i, int j, String A, String B, int[][] cache) {
        if (i == -1) {
            return j + 1;
        }
        if (j == -1) {
            return i + 1;
        }

        if (cache[i][j] != -1) {
            return cache[i][j];
        }
        if (A.charAt(i) == B.charAt(j)) {
            cache[i][j] = minEditDistance(i - 1, j - 1, A, B, cache);
            ;
        } else {
            cache[i][j] = Math.min(minEditDistance(i, j - 1, A, B, cache),
                    Math.min(minEditDistance(i - 1, j - 1, A, B, cache), minEditDistance(i - 1, j, A, B, cache))) + 1;

        }
        return cache[i][j];
    }

    public static void main(String[] args) {
        EditDistanceTopDown editDistanceTopDown = new EditDistanceTopDown();
        String A = "GOAT", B = "GET";
        System.out.println("Edit distance between " + A + "," + B + " is : " +
                editDistanceTopDown.minEditDistance(A.length() - 1, B.length() - 1, A, B));
    }
}
