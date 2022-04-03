package sortingandsearching;

import java.util.Arrays;

public class CountTriplets {

    public int count(int[] a) {
        int n = a.length;
        Arrays.sort(a);
        int count = 0;
        for (int i = n - 1; i >= 2; i--) {

            int l = 0, r = i - 1;
            while (l < r) {
                if (a[i] == a[l] + a[r]) {
                    l++;
                    r--;
                    count++;
                } else if (a[i] > a[l] + a[r]) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountTriplets countTriplets = new CountTriplets();

        int[] a = {1, 3, 5, 2, 7, 4};
        System.out.println("Ans is: " + countTriplets.count(a));
    }
}

