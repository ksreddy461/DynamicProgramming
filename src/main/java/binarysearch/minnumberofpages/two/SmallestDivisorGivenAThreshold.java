package binarysearch.minnumberofpages.two;

public class SmallestDivisorGivenAThreshold {

    private boolean isValid(int[] a, int mid, int threshold) {

        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += Math.ceil((double) a[i] / mid);
            if (sum > threshold) {
                return false;
            }
        }
        return true;
    }

    public int solve(int[] nums, int threshold) {
        int n = nums.length;
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        int s = 1, e = max, res = 0;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (isValid(nums, mid, threshold)) {
                res = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 5, 9};
        int m = 6;
        SmallestDivisorGivenAThreshold smallestDivisorGivenAThreshold = new SmallestDivisorGivenAThreshold();
        System.out.println("Ans is: " + smallestDivisorGivenAThreshold.solve(a, m));

        int[] b = {44, 22, 33, 11, 1};
        m = 5;
        System.out.println("Ans is: " + smallestDivisorGivenAThreshold.solve(b, m));
    }
}
