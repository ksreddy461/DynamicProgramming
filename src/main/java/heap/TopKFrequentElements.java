package heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {


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

    public void solve(Integer[] a, int k) {

        int n = a.length;
        HashMap<Integer, Integer> frequency = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (frequency.containsKey(a[i])) {
                frequency.put(a[i], frequency.get(a[i]) + 1);
            } else {
                frequency.put(a[i], 1);
            }
        }

        PriorityQueue<Pair> minHeap = new PriorityQueue<>();

        for (Map.Entry<Integer, Integer> e : frequency.entrySet()) {

            if (k-- > 0) {
                minHeap.add(new Pair(e.getValue(), e.getKey()));
            } else {
                if (minHeap.size() > 0 && e.getValue() > minHeap.peek().getFreq()) {
                    minHeap.poll();
                    minHeap.add(new Pair(e.getValue(), e.getKey()));
                }
            }
        }

        while (minHeap.size() > 0) {
            Pair pair = minHeap.peek();
            System.out.println(pair.getElement() + " " + pair.getFreq());
            minHeap.poll();
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {3, 1, 4, 4, 5, 2, 6, 1};
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        topKFrequentElements.solve(arr, 2);
    }
}
