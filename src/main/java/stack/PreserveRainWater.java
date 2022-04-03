package stack;

import static java.lang.Math.min;

public class PreserveRainWater {

    int preserveRainWater(int[] a) {

        int totalVal = 0;
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int lMax = max(a, 0, i);
            int rMax = max(a, i + 1, n);

            int val = min(lMax, rMax);
            if (val - a[i] > 0) {
                totalVal += val - a[i];
            }
        }

        return totalVal;
    }

    int max(int[] a, int start, int end) {

        if (start < a.length) {
            int max = start;
            for (int i = start + 1; i < end; i++) {
                if (a[i] > a[max]) {
                    max = i;
                }
            }
            return a[max];
        }
        return 0;
    }

    public int[] lmax(int[] a) {
        int[] l = new int[a.length];

        l[0] = 0;
        for (int i = 1; i < a.length; i++) {
            if (l[i - 1] < a[i - 1]) {
                l[i] = a[i - 1];
            } else {
                l[i] = l[i - 1];
            }
        }
        return l;
    }

    public int[] rmax(int[] a) {
        int n = a.length;
        int[] r = new int[n];

        r[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (r[i + 1] < a[i + 1]) {
                r[i] = a[i + 1];
            } else {
                r[i] = r[i + 1];
            }
        }
        return r;
    }


    public int EfficientSoln(int[] a) {
        int waterSaved = 0;
        int n = a.length;
        int left_max = 0;
        int right_max = 0;
        int l = 0, r = n - 1;

        while (l <= r) {

            if (a[l] < a[r]) {

                if (a[l] > left_max) {
                    left_max = a[l];
                } else {
                    waterSaved += left_max - a[l];
                }
                l++;
            } else {

                if (a[r] > right_max) {
                    right_max = a[r];
                } else {
                    waterSaved += right_max - a[r];
                }
                r--;
            }
        }


        return waterSaved;
    }

    public static void main(String[] args) {

        PreserveRainWater preserveRainWater = new PreserveRainWater();
        int[] a = {3, 0, 2, 0, 4};
        System.out.println("Preserved water is: " + preserveRainWater.preserveRainWater(a));

        int[] b = preserveRainWater.lmax(a);
        int[] c = preserveRainWater.rmax(a);
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            int val = min(b[i], c[i]);
            if (val - a[i] > 0)
                sum += min(b[i], c[i]) - a[i];
        }
        System.out.println("Preserved water is: " + sum);
        System.out.println("Preserved water is: " + preserveRainWater.EfficientSoln(a));
    }
}

