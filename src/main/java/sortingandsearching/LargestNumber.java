package sortingandsearching;

import java.util.Arrays;

//https://www.youtube.com/watch?v=VV_KPrG_PzE&list=PL-Jc9J83PIiHhXKonZxk7gbEWsmSYP5kq&index=39
public class LargestNumber {

    public String largestNumber(int[] nums) {

        int n = nums.length;
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(a,
                (x, y) -> {
                    long n1 = Long.parseLong(x + y);
                    long n2 = Long.parseLong(y + x);
                    if (n1 > n2) {
                        return 1;
                    } else if (n1 < n2) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
        );

        StringBuilder res = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            res.append(a[i]);
        }
        if (res.charAt(0) == '0') {
            return "0";
        }
        return res.toString();
    }

    public static void main(String[] args) {
        LargestNumber largestNumber = new LargestNumber();

        int[] nums = {3, 30, 34, 5, 9};
        System.out.println("Largest number is: " + largestNumber.largestNumber(nums));

        int[] nums2 = {111311, 1113};
        System.out.println("Largest number is: " + largestNumber.largestNumber(nums2));

        int[] nums3 = {0, 0};
        System.out.println("Largest number is: " + largestNumber.largestNumber(nums3));
    }
}
