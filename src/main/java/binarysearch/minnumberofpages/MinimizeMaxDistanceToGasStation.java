package binarysearch.minnumberofpages;

public class MinimizeMaxDistanceToGasStation {

    private boolean isValid(int[] a, int k, double threshold) {
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            count += (a[i + 1] - a[i]) / threshold;
        }
        return count <= k;
    }

    public double solve(int[] a, int k) {
        int n = a.length;
        double res = 0;

        double s = 0, e = a[n - 1] - a[0];
        while (e - s >= 1e-6) {
            double mid = s + (e - s) / 2;
            if (isValid(a, k, mid)) {
                res = mid;
                e = mid;
            } else {
                s = mid;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MinimizeMaxDistanceToGasStation minimizeMaxDistanceToGasStation =
                new MinimizeMaxDistanceToGasStation();

        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int k = 9;
        System.out.println(minimizeMaxDistanceToGasStation.solve(a, k));

        int[] b = {10, 19, 25, 27, 56, 63, 70, 87, 96, 97};
        k = 3;
        System.out.println(minimizeMaxDistanceToGasStation.solve(b, k));
    }
}
