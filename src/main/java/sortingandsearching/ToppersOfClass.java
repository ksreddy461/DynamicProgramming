package sortingandsearching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

//https://www.youtube.com/watch?v=z2PtKIRa1e0&list=PL-Jc9J83PIiHhXKonZxk7gbEWsmSYP5kq&index=43
// Largest K values
public class ToppersOfClass {

    private class Pair implements Comparable<Pair> {

        Integer marks;
        Integer position;

        public Pair(Integer marks, Integer position) {
            this.marks = marks;
            this.position = position;
        }

        public Integer getMarks() {
            return marks;
        }

        public void setMarks(Integer marks) {
            this.marks = marks;
        }

        public Integer getPosition() {
            return position;
        }

        public void setPosition(Integer position) {
            this.position = position;
        }

        @Override
        public int compareTo(Pair o) {

            if (this.marks == o.marks) {
                return o.getPosition() - this.position;
            }
            return this.marks - o.getMarks();
        }
    }

    public ArrayList<Integer> toppers(int[] a, int k) {

        PriorityQueue<Pair> minHeap = new PriorityQueue<>();
        int n = a.length;

        for (int i = 0; i < n; i++) {
            if (i < k) {
                minHeap.add(new Pair(a[i], i));
            } else {

                if (minHeap.size() > 0 && minHeap.peek().getMarks() < a[i]) {
                    minHeap.poll();
                    minHeap.add(new Pair(a[i], i));
                }
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        while (minHeap.size() > 0) {
            Pair pair = minHeap.peek();
            res.add(pair.getPosition());
            minHeap.poll();
        }

        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        ToppersOfClass toppersOfClass = new ToppersOfClass();

        int[] a = {2, 2, 1, 3, 1};
        int k = 3;
        System.out.println("Top K students are: " + toppersOfClass.toppers(a, k));

    }
}
