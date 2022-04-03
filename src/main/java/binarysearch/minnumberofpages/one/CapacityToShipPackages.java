package binarysearch.minnumberofpages.one;

public class CapacityToShipPackages {

    private boolean isValid(int[] a, int threshold, int requiredDays) {

        int weightSum = 0;
        int days = 1;

        for (int i = 0; i < a.length; i++) {
            weightSum += a[i];
            if (weightSum > threshold) {
                days++;
                weightSum = a[i];
            }
            if (days > requiredDays) {
                return false;
            }
        }
        return true;
    }

    public int solve(int[] weights, int days) {
        int n = weights.length;
        int max = Integer.MIN_VALUE;
        int sum = 0, res = -1;
        for (int i = 0; i < n; i++) {
            sum += weights[i];
            if (max < weights[i]) {
                max = weights[i];
            }
        }

        int s = max, e = sum;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (isValid(weights, mid, days)) {
                res = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int k = 5;

        CapacityToShipPackages capacityToShipPackages = new CapacityToShipPackages();
        System.out.println("Ans is:  " + capacityToShipPackages.solve(a, k));

        int[] b = {3, 2, 2, 4, 1, 4};
        k = 3;
        System.out.println("Ans is:  " + capacityToShipPackages.solve(b, k));
    }
}
