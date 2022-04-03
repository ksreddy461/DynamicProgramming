package sortingandsearching;

import java.util.Arrays;

public class CountInversions {
    public int mergeSort(int[] a, int low, int high) {
        int count = 0;
        if (low < high) {
            int mid = low + (high - low) / 2;
            count += mergeSort(a, low, mid);
            count += mergeSort(a, mid + 1, high);
            count += merge(a, low, mid, high);
        }
        return count;
    }

    private int merge(int[] a, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int k = 0;
        int[] t = new int[high - low + 1];
        int count = 0;

        while (i <= mid && j <= high) {
            if (a[i] <= a[j]) {
                t[k++] = a[i++];
            } else {
                t[k++] = a[j++];
                count += (mid - i + 1);
            }
        }
        while (i <= mid) {
            t[k++] = a[i++];
        }

        while (j <= high) {
            t[k++] = a[j++];
        }

        for (int x = low, y = 0; x <= high; x++, y++) {
            a[x] = t[y];
        }
        return count;
    }

    public static void main(String[] args) {
        CountInversions countInversions = new CountInversions();

        int[] a = {8, 5, 2, 3, 5, 1, 4};
        int n = a.length;
        System.out.println("Inversion count is: " + countInversions.mergeSort(a, 0, n - 1));
        System.out.println(Arrays.toString(a));

        int[] b = {8, 5, 3, 4, 1, 6, 2};
        n = b.length;
        System.out.println("Inversion count is: " + countInversions.mergeSort(b, 0, n - 1));
        System.out.println(Arrays.toString(b));
    }
}
