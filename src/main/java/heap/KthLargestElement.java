package heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElement {

    public void BruteForce(Integer[] a, int k) {
        Arrays.sort(a,Collections.reverseOrder());
        System.out.println("Kth largest Element is: " + a[k - 1]);
    }
    public int largest(int[] a, int k) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();//Min heap

        for (int i = 0; i < a.length; i++) {
            if (pQueue.size() < k) {
                pQueue.add(a[i]);
            } else if ((pQueue.size() == k) && pQueue.peek() < a[i] && !pQueue.contains(a[i])) {
                pQueue.add(a[i]);
                pQueue.poll();
            }
        }

        System.out.println("Kth largest Element is: " + pQueue.peek());
        return 0;
    }

    public static void main(String[] agrs) {
        Integer[] a = {9, 8, 3, 2, 5, 7};
        KthLargestElement kthLargestElement = new KthLargestElement();
        kthLargestElement.BruteForce(a, 3);
        int[] c = {9, 8, 3, 2, 5, 7};
        kthLargestElement.largest(c,3);
    }
}
