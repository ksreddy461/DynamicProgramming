package binarysearch.minnumberofpages;

public class EKO {

    private boolean isValid(int[] a, int threshold, int m) {

        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > threshold) {
                sum += a[i] - threshold;
            }
            if (sum >= m) {
                return true;
            }
        }
        return false;
    }

    public int solve(int[] a, int m) {
        int n = a.length;
        int max = a[0];
        for (int i = 1; i < n; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }

        int s = 0, e = max, res = 0;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (isValid(a, mid, m)) {
                res = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {20, 15, 10, 17};
        int m = 7;
        EKO eko = new EKO();
        System.out.println("Ans is: " + eko.solve(a, m));

        int[] b = {4, 42, 40, 26, 46};
        m = 20;
        System.out.println("Ans is: " + eko.solve(b, m));
    }
}
