package backtracking;

public class MiniumDeletionsToMakePalindrome {

    public int minDeletions(int i, int j, String S) {
        if (i >= j) {
            return 0;
        }
        if (S.charAt(i) == S.charAt(j)) {
            return minDeletions(i + 1, j - 1, S);
        } else {
            return Math.min(minDeletions(i, j - 1, S), minDeletions(i + 1, j, S)) + 1;
        }
    }

    public static void main(String[] args) {

        MiniumDeletionsToMakePalindrome miniumDeletionsToMakePalindrome = new MiniumDeletionsToMakePalindrome();
        String S = "KAZAYAKE";
        System.out.println("Minium Deletions to make " + S + " Palindrome is " +
                miniumDeletionsToMakePalindrome.minDeletions(0, S.length() - 1, S));

    }
}
