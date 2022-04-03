package sortingandsearching;

import java.util.Arrays;

public class InsertionSort {

    public void sort(int[] a) {

        int n = a.length;
        for (int i = 1; i < n; i++) {
            int tmp = a[i];
            for (int j = i - 1; j >= 0; j--) {
                if (a[j] > tmp) {
                    a[j + 1] = a[j];
                    a[j] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {

        InsertionSort insertionSort = new InsertionSort();

        int[] a = {8, 4, 9, 3, 5, 1, 7, 8, 5, 3,};
        insertionSort.sort(a);
        System.out.println("Sorted Array is: " + Arrays.toString(a));
    }
}
