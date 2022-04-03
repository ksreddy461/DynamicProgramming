package sortingandsearching;

//https://leetcode.com/problems/find-pivot-index/
public class FindPivotIndex {

    public int pivot(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = 0;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] + nums[i - 1];
        }

        right[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] + nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            if (left[i] == right[i]) {
                return i;
            }
        }
        return -1;
    }

    public int pivot2(int[] nums) {
        int n = nums.length;

        int sum = 0, leftSum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        for (int i = 0; i < n; i++) {
            if (leftSum == sum - leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] a = {1,7,3,6,5,6};
        int[] b = {1,2,3};
        int[] c = {2,1,-1};

        FindPivotIndex findPivotIndex = new FindPivotIndex();
        System.out.println("Ans is: "+ findPivotIndex.pivot(a));
        System.out.println("Ans is: "+ findPivotIndex.pivot(b));
        System.out.println("Ans is: "+ findPivotIndex.pivot(c));

        System.out.println("Ans is: "+ findPivotIndex.pivot2(a));
        System.out.println("Ans is: "+ findPivotIndex.pivot2(b));
        System.out.println("Ans is: "+ findPivotIndex.pivot2(c));
    }

}
