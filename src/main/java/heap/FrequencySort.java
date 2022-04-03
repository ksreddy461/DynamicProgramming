package heap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySort {

    public class Pair implements Comparable<Pair> {

        Integer freq;
        Integer element;

        Pair(Integer freq, int element) {
            this.freq = freq;
            this.element = element;
        }

        public Integer getFreq() {
            return freq;
        }

        public void setFreq(Integer freq) {
            this.freq = freq;
        }

        public Integer getElement() {
            return element;
        }

        public void setElement(Integer element) {
            this.element = element;
        }

        @Override
        public int compareTo(Pair o) {
            return this.getFreq().compareTo(o.getFreq());
        }
    }

    public void solve(Integer[] a) {

        int n = a.length;
        HashMap<Integer, Integer> frequency = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (frequency.containsKey(a[i])) {
                frequency.put(a[i], frequency.get(a[i]) + 1);
            } else {
                frequency.put(a[i], 1);
            }
        }

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (Map.Entry<Integer, Integer> e : frequency.entrySet()) {
            maxHeap.add(new Pair(e.getValue(), e.getKey()));
        }

        System.out.print("Sorted Elements are: ");
        while (maxHeap.size() > 0) {
            Pair pair = maxHeap.peek();
            for (int i = 0; i < pair.getFreq(); i++) {
                System.out.print(pair.getElement() + " ");
            }
            maxHeap.poll();
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {3, 1, 4, 4, 5, 2, 6, 1};
        FrequencySort frequencySort = new FrequencySort();
        frequencySort.solve(arr);
        System.out.println();
        Integer[] b = {2, 5, 2, 8, 5, 6, 8, 8};
        frequencySort.solve(b);
        System.out.println();
        Integer[] c = {2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8};
        frequencySort.solve(c);
        System.out.println();
    }
}
