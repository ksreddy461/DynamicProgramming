package binarysearch;

public class SearchElementInASortedAndRotatedArray {

    public int search(int[] nums, int target) {

        int n = nums.length;
        if (nums[0] < nums[n - 1]) {
            return bSearch(nums, target, 0, n - 1);
        }
        int i = 0;
        int mid = 0;
        int j = nums.length - 1;
        int smallest = 0;
        while (i <= j) {

            mid = (i + j) / 2;
            int prev = (mid + n - 1) % n;
            int next = (mid + 1) % n;

            if (nums[mid] <= nums[prev] && nums[mid] <= nums[next]) {

                smallest = mid;
                if (nums[mid] == target)
                    return smallest;
                break;
            } else if (nums[mid] <= nums[j]) {
                j = mid - 1;
            } else if (nums[i] <= nums[mid]) {
                i = mid + 1;
            }
        }

        int left = bSearch(nums, target, 0, smallest - 1);
        int right = bSearch(nums, target, smallest + 1, nums.length - 1);
        if (left != -1)
            return left;
        else if (right != -1)
            return right;
        else
            return -1;
    }

    public int bSearch(int[] nums, int target, int s, int e) {

        while (s <= e) {
            int m = s + (e - s) / 2;
            if (nums[m] == target) {
                return m;
            } else if (nums[m] < target) {
                s = m + 1;
            } else if (nums[m] > target) {
                e = m - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchElementInASortedAndRotatedArray searchElementInASortedAndRotatedArray = new SearchElementInASortedAndRotatedArray();
        int[] a = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(searchElementInASortedAndRotatedArray.search(a, 0));
    }
}
