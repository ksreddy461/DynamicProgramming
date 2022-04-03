package binarysearch.minnumberofpages.one;

// https://leetcode.com/problems/split-array-largest-sum/
public class SplitArrayLargestSum {

    private boolean isValid(int[] a, int m, int threshold) {
        int sum = 0, count = 1;
        for (int i = 0; i < a.length; i++) {

            if (a[i] > threshold) {
                return false;
            }
            sum += a[i];
            if (sum > threshold) {
                count++;
                sum = a[i];
            }
            if (count > m) {
                return false;
            }
        }
        return true;
    }

    public int solve(int[] nums, int m) {

        int n = nums.length, sum = 0, max = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (max < nums[i]) {
                max = nums[i];
            }
        }

        int s = max, e = sum, res = -1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (isValid(nums, m, mid)) {
                res = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int[] a = {7, 2, 5, 10, 8};
        int m = 2;

        SplitArrayLargestSum splitArrayLargestSum = new SplitArrayLargestSum();
        System.out.println("Ans is: " + splitArrayLargestSum.solve(a, m));

        int[] b = {1, 2, 3, 4, 5};
        m = 2;
        System.out.println("Ans is: " + splitArrayLargestSum.solve(b, m));

        int[] c = {1, 4, 4};
        m = 3;
        System.out.println("Ans is: " + splitArrayLargestSum.solve(c, m));

    }
}
