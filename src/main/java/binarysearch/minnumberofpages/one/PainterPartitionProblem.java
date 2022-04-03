package binarysearch.minnumberofpages.one;

public class PainterPartitionProblem {

    private boolean isValid(int[] a, int threshold, int k) {

        int sum = 0;
        int painters = 1;

        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            if (sum > threshold) {
                painters++;
                sum = a[i];
            }
            if (painters > k) {
                return false;
            }
        }
        return true;
    }

    public int solve(int[] a, int k) {
        int n = a.length;
        int max = Integer.MIN_VALUE;
        int sum = 0, res = -1;
        for (int i = 0; i < n; i++) {
            sum += a[i];
            if (max < a[i]) {
                max = a[i];
            }
        }

        int s = max, e = sum;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (isValid(a, mid, k)) {
                res = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {10, 10, 10, 10};
        int k = 2;

        PainterPartitionProblem painterPartitionProblem = new PainterPartitionProblem();
        System.out.println("Ans is:  " + painterPartitionProblem.solve(a, k));
        System.out.println("Ans is:  " + painterPartitionProblem.solve(a, 1));

        int[] b = {10, 20, 30, 40};
        k = 2;

        System.out.println("Ans is:  " + painterPartitionProblem.solve(b, k));
        System.out.println("Ans is:  " + painterPartitionProblem.solve(b, 1));
        System.out.println("Ans is:  " + painterPartitionProblem.solve(b, 3));
    }
}
