package backtracking;

public class MinimumDeletionsAndInsertionsToConvertStringAtoB {

    int minInsertDeletions(String A, String B, int i, int j) {

        if (i == 0 && j == 0) {
            return 0;
        } else if (i == 0) {
            return j - 1;
        } else if (j == 0) {
            return i - 1;
        }

        if (A.charAt(i - 1) == B.charAt(j - 1)) {
            return minInsertDeletions(A, B, i - 1, j - 1);
        } else {
            return (1 + Math.min(minInsertDeletions(A, B, i, j - 1), minInsertDeletions(A, B, i - 1, j)));
        }
    }

    public static void main(String[] args) {

        MinimumDeletionsAndInsertionsToConvertStringAtoB minimumDeletionsAndInsertionsToConvertStringAtoB = new MinimumDeletionsAndInsertionsToConvertStringAtoB();
        String A = "heap";
        String B = "pea";
        System.out.println("Minium Insertions and Deletions are: " +
                minimumDeletionsAndInsertionsToConvertStringAtoB.minInsertDeletions(A, B, A.length(), B.length()));

    }
}
