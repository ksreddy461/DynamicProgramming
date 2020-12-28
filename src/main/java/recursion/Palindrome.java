package recursion;

public class Palindrome {

    boolean isPalindrome(String S, int i, int j) {
        if (i >= j)
            return true;

        if (S.charAt(i) == S.charAt(j)) {
            return isPalindrome(S, i + 1, j - 1);
        }
        return false;
    }

    public static void main(String[] args) {
        String S1 = "dabad", S2 = "xyyx", S3 = "ppq";
        Palindrome palindrome = new Palindrome();
        System.out.println("Given String " + S1 + " isPalindrome: " + palindrome.isPalindrome(S1, 0, S1.length() - 1));
        System.out.println("Given String " + S2 + " isPalindrome: " + palindrome.isPalindrome(S2, 0, S2.length() - 1));
        System.out.println("Given String " + S3 + " isPalindrome: " + palindrome.isPalindrome(S3, 0, S3.length() - 1));
    }
}
