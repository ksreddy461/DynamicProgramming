package backtracking;

public class LongestIncreasingSubSequence {

    public int lic(int[] a, int pos) {
        if (pos == 0) {
            return 1;
        }
        int max = 0;
        for (int i = 0; i < pos; i++) {
            int lis = lic(a, i);
            if (a[pos] > a[i]) {
                lis += 1;
            }
            max = Math.max(max, lis);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestIncreasingSubSequence longestIncreasingSubSequence = new LongestIncreasingSubSequence();
        int[] a = {5, 2, 3, 6, 8};
        System.out.println("Longest increasing subsequence is: " + longestIncreasingSubSequence.lic(a, a.length - 1));
    }
}
