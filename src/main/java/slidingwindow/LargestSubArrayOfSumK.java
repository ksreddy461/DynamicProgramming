package slidingwindow;

import java.util.HashMap;

public class LargestSubArrayOfSumK {

    boolean BruteForce(int[] a, int sum, int k) {
        int n = a.length;
        int i = 0, j = 0, sumSoFar = 0;
        while (j < n) {
            sumSoFar = sumSoFar + a[j];
            if (j - i + 1 == k) {
                if (sumSoFar == sum) {
                    return true;
                }
                sumSoFar = sumSoFar - a[i];
                i++;
            }
            j++;
        }
        return false;
    }

    /*
     * Not working for -ve numbers
     * */

    public int solve(int[] a, int k) {
        int n = a.length;
        int max = 0;

        int i = 0, j = 0;
        int sum = 0;
        while (j < n) {
            sum = sum + a[j];

            if (sum > k) {
                while (i < n && sum > k) {
                    sum = sum - a[i];
                    i++;
                }
            }

            if (sum == k) {
                if (max < j - i + 1) {
                    max = j - i + 1;
                }
            } else if (sum > k) {
                while (sum > k) {
                    sum = sum - a[i];
                    i++;
                }
            }
            j++;
        }
        return max;
    }

    public int solve2(int[] a, int k) {

        int n = a.length;
        HashMap<Integer, Integer> hash = new HashMap<>();
        int sumSoFar = 0, max = 0;
        for (int j = 0; j < n; j++) {

            sumSoFar += a[j];
            if (sumSoFar == k) {
                max = j + 1;
            }

            if (!hash.containsKey(sumSoFar)) {
                hash.put(sumSoFar, j);
            }

            if (hash.containsKey(sumSoFar - k)) {
                int prevPos = hash.get(sumSoFar - k);
                if (max < j - prevPos) {
                    max = j - prevPos;
                }
            }
        }
        return max;
    }

    public int solve3(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;

        int i = 0, j = 0;
        int p = 1;
        while (j < n) {
            p = p * nums[j];

            if (p > max) {
                max = p;
            } else if (max >= p) {
                while (i < j && max >= p) {
                    if (nums[i] == 0 && i + 1 <= j) {
                        p = nums[i + 1];
                    } else {
                        p = p / nums[i];
                    }
                    i++;
                    if (p > max) {
                        max = p;
                    }
                }
            }
            j++;
        }
        return max;
    }

    public static void main(String[] args) {
        LargestSubArrayOfSumK largestSubArrayOfSumK = new LargestSubArrayOfSumK();
        int[] a = {4, 1, 1, -2, 1, 5};
        int sum = 5;
        for (int k = a.length; k >= 0; k--) {
            if (largestSubArrayOfSumK.BruteForce(a, sum, k)) {
                System.out.println("Answer is: " + k);
                break;
            }
        }

        int[] b = {10, 5, 2, 7, 1, 9};
        for (int k = b.length; k > 0; k--) {
            if (largestSubArrayOfSumK.BruteForce(b, 15, k)) {
                System.out.println("Answer is: " + k);
                break;
            }
        }

        System.out.println("Max sub array size is: " + largestSubArrayOfSumK.solve2(a, sum));
        System.out.println("Max sub array size is: " + largestSubArrayOfSumK.solve2(b, 15));
        int[] c = {2, 3, -2, 4};
        int[] d = {-2, 0, -1};
        int[] e = {-2, 0, 1};
        int[] f = {-2,3,-4};
        System.out.println("Max Product is: " + largestSubArrayOfSumK.solve3(c));
        System.out.println("Max Product is: " + largestSubArrayOfSumK.solve3(d));
        System.out.println("Max Product is: " + largestSubArrayOfSumK.solve3(e));
        System.out.println("Max Product is: " + largestSubArrayOfSumK.solve3(f));
    }
}
