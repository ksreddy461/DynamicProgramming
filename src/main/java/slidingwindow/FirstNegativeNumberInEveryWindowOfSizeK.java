package slidingwindow;

import java.util.Arrays;
import java.util.LinkedList;

public class FirstNegativeNumberInEveryWindowOfSizeK {

    public int[] BruteForce(int[] a, int k) {
        int n = a.length;
        int[] res = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            for (int j = i; j < i + k; j++) {
                if (a[j] < 0) {
                    res[i] = a[j];
                    break;
                }
            }
        }
        return res;
    }


    public int[] solve(int[] nums, int k) {

        int n = nums.length;
        int[] res = new int[n - k + 1];
        LinkedList<Integer> DeQueue = new LinkedList<>();
        int i = 0, j = 0;
        while (j < n) {
            if (nums[j] < 0) {
                DeQueue.add(nums[j]);
            }
            if (j - i + 1 == k) {
                if (DeQueue.isEmpty()) {
                    res[i] = 0;
                } else {
                    res[i] = DeQueue.peek();
                    if (res[i] == nums[i]) {
                        DeQueue.remove();
                    }
                    i++;
                }
            }
            j++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;
        FirstNegativeNumberInEveryWindowOfSizeK firstNegativeNumberInEveryWindowOfSizeK = new FirstNegativeNumberInEveryWindowOfSizeK();
        System.out.println(Arrays.toString(firstNegativeNumberInEveryWindowOfSizeK.BruteForce(a, k)));
        System.out.println(Arrays.toString(firstNegativeNumberInEveryWindowOfSizeK.solve(a, k)));
    }
}
