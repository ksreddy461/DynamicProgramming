package sortingandsearching;

import java.util.Arrays;

public class CountTriangles {

    public int count(int[] a) {

        int n = a.length;
        Arrays.sort(a);

        int count = 0;

        for (int i = n - 1; i >= 2; i--) {

            int l = 0, r = i - 1;
            while (l < r) {
                if (a[l] + a[r] > a[i]) {
                    count += r - l;
                    r--;
                } else {
                    l++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountTriangles countTriangles = new CountTriangles();

        int[] a = {6, 4, 9, 2, 8};
        System.out.println("Ans is: " + countTriangles.count(a));
    }
}
