package sortingandsearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

//https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
public class FindKPairsWithSmallestSums {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        int m = nums1.length;
        int n = nums2.length;

        PriorityQueue<List<Integer>> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b.get(0) + b.get(1), a.get(0) + a.get(1)));

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (maxHeap.size() < k) {
                    maxHeap.add(Arrays.asList(nums1[i], nums2[j]));
                } else {
                    List<Integer> list = maxHeap.peek();
                    if (nums1[i] + nums2[j] < list.get(0) + list.get(1)) {
                        maxHeap.poll();
                        maxHeap.add(Arrays.asList(nums1[i], nums2[j]));
                    }
                }
            }
        }
        return new ArrayList<>(maxHeap);
    }

    public List<List<Integer>> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> pairs = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return pairs;
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                (pair1, pair2) -> nums1[pair1[0]] - nums1[pair2[0]] + nums2[pair1[1]] - nums2[pair2[1]]
        );


        for (int i = 0; i < nums2.length; i++) {
            if (i == k) break;
            minHeap.offer(new int[]{0, i});
        }

        while (k-- > 0 && minHeap.size() > 0) {
            int[] smallest = minHeap.poll();
            List<Integer> pair = new ArrayList<>();
            pair.add(nums1[smallest[0]]);
            pair.add(nums2[smallest[1]]);
            pairs.add(pair);
            if (smallest[0] + 1 == nums1.length) continue;
            minHeap.offer(new int[]{smallest[0] + 1, smallest[1]});
        }
        return pairs;
    }

    public static void main(String[] args) {
        FindKPairsWithSmallestSums findKPairsWithSmallestSums = new FindKPairsWithSmallestSums();

        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        int k = 3;
        System.out.println(Arrays.asList(findKPairsWithSmallestSums.kSmallestPairs(nums1, nums2, k)));
        System.out.println(Arrays.asList(findKPairsWithSmallestSums.kSmallestPairs2(nums1, nums2, k)));

        int[] nums12 = {1,1,2};
        int[] nums22 = {1,2,3};
        int k2 = 2;
        System.out.println(Arrays.asList(findKPairsWithSmallestSums.kSmallestPairs(nums12, nums22, k2)));
        System.out.println(Arrays.asList(findKPairsWithSmallestSums.kSmallestPairs2(nums12, nums22, k2)));

        int[] nums13 = {1, 2};
        int[] nums23 = {3};
        int k3 = 3;
        System.out.println(Arrays.asList(findKPairsWithSmallestSums.kSmallestPairs(nums13, nums23, k3)));
        System.out.println(Arrays.asList(findKPairsWithSmallestSums.kSmallestPairs2(nums13, nums23, k3)));

    }
}
