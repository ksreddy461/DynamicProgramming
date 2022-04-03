package heap;

import java.util.PriorityQueue;

public class SortKSortedArrayORSortNearlySortedArray {


    void solve(Integer[] a, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();//Default minHeap
        int n = a.length;
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (i <= k) {
                minHeap.add(a[i]);
            } else {
                a[index++] = minHeap.peek();
                minHeap.poll();
                minHeap.add(a[i]);
            }
        }

        while (minHeap.size() > 0) {
            a[index++] = minHeap.peek();
            minHeap.poll();
        }
    }

    public static void main(String[] args) {
        SortKSortedArrayORSortNearlySortedArray kSortedArrayORSortNearlySortedArray = new SortKSortedArrayORSortNearlySortedArray();
        Integer[] arr = {2, 6, 3, 12, 56, 8};
        kSortedArrayORSortNearlySortedArray.solve(arr, 3);
        System.out.println("Following is sorted array");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        Integer[] b = {6, 5, 3, 2, 8, 10, 9};
        kSortedArrayORSortNearlySortedArray.solve(b, 3);
        System.out.println("Following is sorted array");
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }

        System.out.println();
        Integer[] c = {10, 9, 8, 7, 4, 70, 60, 50};
        kSortedArrayORSortNearlySortedArray.solve(c, 4);
        System.out.println("Following is sorted array");
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i] + " ");
        }
    }
}
