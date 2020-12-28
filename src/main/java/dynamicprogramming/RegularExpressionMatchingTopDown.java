package dynamicprogramming;

public class RegularExpressionMatchingTopDown {


    public boolean matches(int i, int j, String S, String R) {
        Boolean[][] cache = new Boolean[S.length()][R.length()];
        return matches(i, j, S, R, cache);
    }

    public boolean matches(int i, int j, String S, String R, Boolean[][] cache) {
        if (i == -1 && j == -1 || R.substring(0, j + 1).equals("*")) {
            return true;
        } else if (i == -1 || j == -1) {
            return false;
        }

        if (cache[i][j] != null) {
            return cache[i][j];
        }
        if (S.charAt(i) == R.charAt(j) || R.charAt(j) == '.') {
            cache[i][j] = matches(i - 1, j - 1, S, R, cache);
            return cache[i][j];
        } else if (R.charAt(j) == '*') {
            cache[i][j] = matches(i - 1, j, S, R, cache) || matches(i, j - 1, S, R, cache);
            return cache[i][j];
        }
        return false;
    }

    public static void main(String[] args) {
        RegularExpressionMatchingTopDown regularExpressionMatchingTopDown = new RegularExpressionMatchingTopDown();
        String S = "GREATS", R = "*T*";
        System.out.println("Regular Expression " + R + " is matches with String " + S + " " +
                regularExpressionMatchingTopDown.matches(S.length() - 1, R.length() - 1, S, R));
    }
}
