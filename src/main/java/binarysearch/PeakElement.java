package binarysearch;

public class PeakElement {

    public int peak(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return 0;
        } else if (n == 2) {
            return nums[0] > nums[1] ? 0 : 1;
        } else {
            int s = 0, e = n - 1;
            while (s <= e) {
                int mid = s + (e - s) / 2;
                if (mid == 0) {
                    if (nums[0] > nums[1]) {
                        return 0;
                    }
                    if (nums[mid] < nums[mid + 1]) {
                        s = mid + 1;
                    }
                } else if (mid == n - 1) {
                    if (nums[n - 1] > nums[n - 2]) {
                        return n - 1;
                    }
                    if (nums[mid] < nums[mid - 1]) {
                        e = mid - 1;
                    }
                }
                if (mid - 1 >= 0 && nums[mid] > nums[mid - 1] &&
                        mid + 1 < n && nums[mid] > nums[mid + 1]) {
                    return mid;
                } else if (mid - 1 >= 0 && nums[mid] < nums[mid - 1]) {
                    e = mid - 1;
                } else if (mid + 1 < n && nums[mid] < nums[mid + 1]) {
                    s = mid + 1;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 1};
        PeakElement peakElement = new PeakElement();
        System.out.println("Peak element is: " + peakElement.peak(a));
        int[] b = {1, 2, 1, 3, 5, 6, 4};
        System.out.println("Peak element is: " + peakElement.peak(b));
        int[] c = {6, 5, 4, 3, 2, 3, 2};
        System.out.println("Peak element is: " + peakElement.peak(c));
        int[] d = {3, 4, 3, 2, 1};
        System.out.println("Peak element is: " + peakElement.peak(d));
    }
}
