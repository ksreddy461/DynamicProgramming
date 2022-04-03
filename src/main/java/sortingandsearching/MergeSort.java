package sortingandsearching;

import java.util.Arrays;

public class MergeSort {

    public void mergeSort(int[] a, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(a, low, mid);
            mergeSort(a, mid + 1, high);
            merge(a, low, mid, high);
        }
    }

    private void merge(int[] a, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int k = 0;
        int[] t = new int[high - low + 1];

        while (i <= mid && j <= high) {
            if (a[i] <= a[j]) {
                t[k++] = a[i++];
            } else {
                t[k++] = a[j++];
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
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();

        int[] a = {8, 5, 2, 3, 5, 1, 4};
        int n = a.length;
        mergeSort.mergeSort(a, 0, n - 1);
        System.out.println(Arrays.toString(a));

        int[] b = {8, 5, 3, 4, 1, 6, 2};
        n = b.length;
        mergeSort.mergeSort(b, 0, n - 1);
        System.out.println(Arrays.toString(b));
    }
}
