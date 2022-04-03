package heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class KLargestElements {

    public void BruteForce(Integer[] a, int k) {
        Arrays.sort(a, Collections.reverseOrder());
        System.out.print("Kth largest Elements are: ");
        for (int i = 0; i < k; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public void largest(int[] a, int k) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();//Min heap

        for (int i = 0; i < a.length; i++) {
            if (pQueue.size() < k) {
                pQueue.add(a[i]);
            } else if ((pQueue.size() == k) && pQueue.peek() < a[i]) {
                pQueue.add(a[i]);
                pQueue.poll();
            }
        }

        System.out.print("Kth largest Elements are: ");
        while (pQueue.size() > 0) {
            System.out.print(pQueue.peek() + " ");
            pQueue.poll();
        }
    }

    public static void main(String[] agrs) {
        Integer[] a = {9, 8, 3, 2, 5, 7};
        KLargestElements kLargestElements = new KLargestElements();
        kLargestElements.BruteForce(a, 3);
        int[] c = {9, 8, 3, 2, 5, 7};
        kLargestElements.largest(c, 3);
    }
}
