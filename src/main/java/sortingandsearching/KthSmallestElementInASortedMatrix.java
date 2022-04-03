package sortingandsearching;

import java.util.Arrays;
import java.util.PriorityQueue;

//https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/
public class KthSmallestElementInASortedMatrix {

    public int BruteForce(int[][] mat, int k) {

        int rows = mat.length;
        int cols = mat[0].length;

        int[] nums = new int[rows * cols];
        int p = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                nums[p++] = mat[i][j];
            }
        }

        Arrays.sort(nums);
        return nums[k - 1];
    }

    public int solve(int[][] mat, int k) {
        int rows = mat.length;
        int cols = mat[0].length;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> {
            return Integer.compare(mat[a[0]][a[1]], mat[b[0]][b[1]]);
        });

        for (int i = 0; i < rows; i++) {
            minHeap.add(new int[]{i, 0});
        }

        while (k > 1) {
            int[] p = minHeap.poll();
            if (p[1] < cols - 1) {
                minHeap.add(new int[]{p[0], p[1] + 1});
            }
            k--;
        }

        int[] res = minHeap.peek();
        return mat[res[0]][res[1]];
    }

    public int solve2(int[][] mat, int k) {
        int rows = mat.length;
        int cols = mat[0].length;

        int l = mat[0][0];
        int h = mat[rows - 1][cols - 1];

        int res = l;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            int count = 0;
            for (int i = 0, j = cols - 1; i < rows; i++) {
                while (j >= 0 && mat[i][j] > mid) {
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
        KthSmallestElementInASortedMatrix kthSmallestElementInASortedMatrix =
                new KthSmallestElementInASortedMatrix();

        int[][] mat = {{1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}};

        System.out.println("Ans is: " + kthSmallestElementInASortedMatrix.BruteForce(mat, 8));
        System.out.println("Ans is: " + kthSmallestElementInASortedMatrix.solve(mat, 8));
        System.out.println("Ans is: " + kthSmallestElementInASortedMatrix.solve2(mat, 8));

        int[][] mat2 = {{1,2},{1,3}};
        System.out.println("Ans is: " + kthSmallestElementInASortedMatrix.BruteForce(mat2, 3));
        System.out.println("Ans is: " + kthSmallestElementInASortedMatrix.solve(mat2, 3));
        System.out.println("Ans is: " + kthSmallestElementInASortedMatrix.solve2(mat2, 3));
    }
}
