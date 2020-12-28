package backtracking;

public class RegularExpressionMatching {

    public boolean matches(int i, int j, String S, String R) {
        if (i == -1 && j == -1 || R.substring(0, j + 1).equals("*")) {
            return true;
        } else if (i == -1 || j == -1) {
            return false;
        }

        if (S.charAt(i) == R.charAt(j)) {
            return matches(i - 1, j - 1, S, R);
        } else if (R.charAt(j) == '.') {
            return matches(i - 1, j - 1, S, R);
        } else if (R.charAt(j) == '*') {
            return matches(i - 1, j, S, R) || matches(i, j - 1, S, R);
        }
        return false;
    }

    public static void main(String[] args) {
        RegularExpressionMatching regularExpressionMatching = new RegularExpressionMatching();
        String S = "GREATS", R = "G*T*";
        System.out.println("Regular Expression " + R + " is matches with String " + S + " " +
                regularExpressionMatching.matches(S.length() - 1, R.length() - 1, S, R));
    }
}
