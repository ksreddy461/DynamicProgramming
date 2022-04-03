package binarysearch.minnumberofpages;

//https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/
public class MinNoOfDaysToMakeMBouquets {

    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        int min = bloomDay[0], max = bloomDay[0];
        for (int i = 1; i < n; i++) {
            if (bloomDay[i] > max) {
                max = bloomDay[i];
            } else if (bloomDay[i] < min) {
                min = bloomDay[i];
            }
        }

        int s = min, e = max, res = -1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (isValid(bloomDay, m, k, mid)) {
                res = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return res;
    }

    private boolean isValid(int[] a, int m, int k, int threshold) {

        int count = 0, flowers = 0, i = 0;
        int n = a.length;
        while (i < n) {
            flowers = 0;
            if (a[i] <= threshold) {
                flowers++;
                i++;
                while (flowers < k && i < n && a[i] <= threshold) {
                    flowers++;
                    i++;
                }
                if (flowers == k) {
                    count++;
                }
                if (count == m) {
                    return true;
                }
            } else {
                i++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MinNoOfDaysToMakeMBouquets minNoOfDaysToMakeMBouquets = new MinNoOfDaysToMakeMBouquets();
        int[] a = {1, 10, 3, 10, 2};
        int m = 3, k = 1;

        System.out.println("Ans is: " + minNoOfDaysToMakeMBouquets.minDays(a, m, k));
        k = 2;
        System.out.println("Ans is: " + minNoOfDaysToMakeMBouquets.minDays(a, m, k));

        int[] b = {7, 7, 7, 7, 12, 7, 7};
        m = 2;
        k = 3;

        System.out.println("Ans is: " + minNoOfDaysToMakeMBouquets.minDays(b, m, k));
        int[] c = {1, 10, 2, 9, 3, 8, 4, 7, 5, 6};
        m = 4;
        k = 2;
        System.out.println("Ans is: " + minNoOfDaysToMakeMBouquets.minDays(c, m, k));
    }
}
