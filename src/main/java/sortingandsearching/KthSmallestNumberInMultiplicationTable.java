package sortingandsearching;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestNumberInMultiplicationTable {

    public int findKthNumber(int m, int n, int k) {
        int rows = m;
        int cols = n;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0] * a[1], b[0] * b[1]);
            }
        });

        for (int i = 0; i < rows; i++) {
            minHeap.add(new int[]{i + 1, 1});
        }

        while (k > 1) {
            int[] p = minHeap.poll();
            if (p[1] < cols) {
                minHeap.add(new int[]{p[0], p[1] + 1});
            }
            k--;
        }

        int[] res = minHeap.peek();
        return res[0] * res[1];
    }

    public int solve(int m, int n, int k) {

        int l = 1;
        int h = m * n;

        int res = l;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            int count = 0;
            for (int i = 0, j = n - 1; i < m; i++) {
                while (j >= 0 && (i + 1) * (j + 1) > mid) {
                    j--;
                }
                count += j + 1;
            }

            if (count < k) {
                l = mid + 1;
            } else {
                h = mid-1;
                res = mid;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        KthSmallestNumberInMultiplicationTable kthSmallestNumberInMultiplicationTable =
                new KthSmallestNumberInMultiplicationTable();

        System.out.println("Ans is: " + kthSmallestNumberInMultiplicationTable.findKthNumber(3, 3, 5));
        System.out.println("Ans is: " + kthSmallestNumberInMultiplicationTable.solve(3, 3, 5));

        System.out.println("Ans is: " + kthSmallestNumberInMultiplicationTable.solve(2, 3, 6));
    }

}
