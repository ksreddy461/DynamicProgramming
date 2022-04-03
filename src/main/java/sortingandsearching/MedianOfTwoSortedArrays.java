package sortingandsearching;

public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;

        int len = m + n;
        int mid = len / 2;
        int[] merged = new int[mid + 1];

        int i = 0, j = 0, k = 0;

        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }

            if (k == mid + 1) {
                break;
            }
        }
        if (k != mid + 1) {
            while (i < m) {
                merged[k++] = nums1[i++];
                if (k == mid + 1) {
                    break;
                }
            }
            while (j < n) {
                merged[k++] = nums2[j++];
                if (k == mid + 1) {
                    break;
                }
            }
        }

        if (len % 2 == 0) {
            return (double) (merged[mid - 1] + merged[mid]) / 2;
        }
        return merged[mid];
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        if (nums2.length < nums1.length) return findMedianSortedArrays2(nums2, nums1);
        int n1 = nums1.length;
        int n2 = nums2.length;
        int low = 0, high = n1;

        while (low <= high) {
            int cut1 = (low + high)/2;
            int cut2 = (n1 + n2 + 1) / 2 - cut1;


            int left1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int left2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];

            int right1 = cut1 == n1 ? Integer.MAX_VALUE : nums1[cut1];
            int right2 = cut2 == n2 ? Integer.MAX_VALUE : nums2[cut2];


            if (left1 <= right2 && left2 <= right1) {
                if ((n1 + n2) % 2 == 0)
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                else
                    return Math.max(left1, left2);
            } else if (left1 > right2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();

        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println("Median is : " + medianOfTwoSortedArrays.findMedianSortedArrays2(nums1, nums2));

        int[] nums3 = {1, 2};
        int[] nums4 = {3, 4};
        System.out.println("Median is : " + medianOfTwoSortedArrays.findMedianSortedArrays2(nums3, nums4));
    }
}
