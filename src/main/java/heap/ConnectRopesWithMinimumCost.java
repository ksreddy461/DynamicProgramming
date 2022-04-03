package heap;

import java.util.PriorityQueue;

public class ConnectRopesWithMinimumCost {

    int solve(int[] a) {
        int n = a.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            minHeap.add(a[i]);
        }

        int cost = 0;
        while (minHeap.size() >= 2) {
            int first = minHeap.peek();
            minHeap.poll();
            int second = minHeap.peek();
            minHeap.poll();
            cost = cost + (first + second);
            minHeap.add(first + second);
        }
        return cost;
    }

    public static void main(String args[]) {
        int[] a = {4, 3, 2, 6};
        ConnectRopesWithMinimumCost connectRopesWithMinimumCost = new ConnectRopesWithMinimumCost();
        System.out.println("Total cost for connecting ropes is " + connectRopesWithMinimumCost.solve(a));
        System.out.println("-------------");
        int[] b = {1, 3, 2, 4, 5};
        System.out.println("Total cost for connecting ropes is " + connectRopesWithMinimumCost.solve(b));
    }
}
