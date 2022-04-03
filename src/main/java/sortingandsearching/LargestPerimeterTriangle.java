package sortingandsearching;

import java.util.Arrays;

//https://leetcode.com/problems/largest-perimeter-triangle/
public class LargestPerimeterTriangle {

    public int solve(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);
        int res = 0;
        for (int i = n - 1; i >= 2; i--) {
            if (nums[i - 1] + nums[i - 2] > nums[i]) {
                return nums[i] + nums[i - 1] + nums[i-2];
            }
        }
        return res;
    }

    public static void main(String[] args) {

        LargestPerimeterTriangle largestPerimeterTriangle = new LargestPerimeterTriangle();

        int[] a = {2, 1, 2};
        System.out.println("Largest perimeter is: " + largestPerimeterTriangle.solve(a));

        int[] b = {2, 1, 1};
        System.out.println("Largest perimeter is: " + largestPerimeterTriangle.solve(b));

        int[] c = {3, 2, 3, 4};
        System.out.println("Largest perimeter is: " + largestPerimeterTriangle.solve(c));
    }
}
