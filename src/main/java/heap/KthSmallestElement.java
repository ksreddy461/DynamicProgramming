package heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElement {

    public int BruteForce(int[] a, int k) {
        Arrays.sort(a);
        System.out.println("Kth Smallest Element is: " + a[k - 1]);
        return a[k - 1];
    }

    public int smallest(int[] a, int k) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());//Max heap

        for (int i = 0; i < a.length; i++) {
            if (pQueue.size() < k) {
                pQueue.add(a[i]);
            } else if ((pQueue.size() == k) && pQueue.peek() > a[i]) {
                pQueue.add(a[i]);
                pQueue.poll();
            }
        }

        System.out.println("Kth Smallest Element is: " + pQueue.peek());
        return pQueue.peek();
    }


    public static void main(String[] agrs) {
        int[] a = {9, 8, 3, 2, 5, 7};
        KthSmallestElement kthSmallestElement = new KthSmallestElement();
        kthSmallestElement.BruteForce(a, 3);
        int[] b = {9, 8, 3, 2, 5, 7};
        kthSmallestElement.smallest(b, 3);
    }


}
